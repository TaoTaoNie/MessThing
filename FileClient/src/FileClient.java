import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FileClient {
    private static final int TCP_PORT = 2021;
    private static final int UDP_PORT = 2020;
    private static final String HOST = "127.0.0.1"; // 连接地址
    private static int dataLen = 10240;
    private Socket socket = new Socket();
    private DatagramSocket datagramSocket;

    public FileClient() {
        try{
            socket = new Socket(HOST, TCP_PORT);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void connect() {
        try {
            // 客户端输出流，向服务器发消息
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream()));
            // 客户端输入流，接收服务器消息
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            PrintWriter pw = new PrintWriter(bw, true);
            System.out.println(br.readLine());

            Scanner in = new Scanner(System.in); // 接受用户信息
            String cmd = null;
            while ((cmd = in.nextLine().trim()) != null) {
                // System.out.println(cmd);
                if (cmd.equals("ls") || cmd.startsWith("cd") || cmd.equals("bye")) {
                    pw.println(cmd.trim());
                    String msg = null;
                    while ((msg = br.readLine()) != null && !msg.equals("")) {
                        System.out.println(msg);
                    }
                    if (cmd.equals("bye")) {
                        break; // 退出
                    }
                } else if (cmd.startsWith("get")) {
                    pw.println(cmd.trim());
                    String msg = br.readLine();
                    if (msg.equalsIgnoreCase("OK")) {
                        // 文件的绝对路径
                        String path = br.readLine();
                        // 这里是文件的大小
                        int fileLen = Integer.parseInt(br.readLine());
//						System.out.println(path + "  " + fileLen);
                        //开始下载文件
                        datagramSocket = new DatagramSocket();
                        // 把从服务器取来的文件绝对路径包装成字节流发到服务器取对应的文件
                        byte[] info = path.getBytes();
                        DatagramPacket sendDp = new DatagramPacket(info,
                                info.length, new InetSocketAddress(HOST, UDP_PORT));
                        datagramSocket.send(sendDp);
                        String fileName = path.substring(path.lastIndexOf(File.separatorChar)+1);
//						System.out.println("fileName: " + fileName);
                        File rcFile = new File(fileName);
                        rcFile.createNewFile();
//						System.out.println(rcFile.getAbsolutePath());
                        FileOutputStream fos = new FileOutputStream(rcFile);

                        int times = fileLen / dataLen;
                        if(fileLen % dataLen > 0) times ++;
                        DatagramPacket receiveDp = null;
                        byte[] inBuff = new byte[dataLen];
                        System.out.println("开始接收文件：" + fileName);
                        for (int i = 0; i < times; i++) {
                            receiveDp = new DatagramPacket(inBuff, inBuff.length);
                            datagramSocket.receive(receiveDp);
                            fos.write(inBuff, 0, receiveDp.getLength());
                            fos.flush();
                        }
                        fos.close();
                        datagramSocket.close();
                        System.out.println("文件接收完毕");
                        br.readLine();
                    } else {
                        System.out.println(msg);
                        br.readLine();
                    }
                } else {
                    System.out.println("unknown cmd");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != socket) {
                try {
                    socket.close(); // 断开连接
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws UnknownHostException,
            IOException {
        new FileClient().connect();
    }

}
