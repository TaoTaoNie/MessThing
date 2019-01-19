package src.zxy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    ServerSocket serverSocket;
    private final int PORT = 2021; //端口
    private String rootPath; //初始根目录

    public EchoServer(String rootPath) throws IOException {
        serverSocket = new ServerSocket(PORT, 2); // 创建服务器端套接字
        serverSocket.setSoTimeout(3000);
        // 判断该文件夹是否存在，不存在的话就使用服务器所在的根目录作为根目录
        File file = new File(rootPath);
        if (file.exists()) {
            this.rootPath = rootPath; // 通过构造器初始化
        } else {
            this.rootPath = "notExists";
        }
        System.out.println("服务器启动。");
    }

    public static void main(String[] args) throws IOException {
        new EchoServer(".\\").service(); // 启动服务
    }

    /**
     * service implements
     */
    public void service() {
        Socket socket = null;
        while (true) {
            try {
                socket = serverSocket.accept(); //等待并取出用户连接，并创建套接字
                System.out.println("新连接，连接地址：" + socket.getInetAddress() + "："
                        + socket.getLocalPort()); //客户端信息
                //输入流，读取客户端信息
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                //输出流，向客户端写信息
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                        socket.getOutputStream()));
                PrintWriter pw = new PrintWriter(bw, true);//装饰输出流，true,每写一行就刷新输出缓冲区，不用flush
                //pw.println(socket.getInetAddress() + ":" + socket.getLocalPort() + ">连接成功");
                String info = null; //接收用户输入的信息
                while ((info = br.readLine()) != null) {
                    System.out.println(info);
                    if (info.equals("ls")) {
                        if (rootPath.equals("notExists")) {
                            File fileS = new File("");
                            this.rootPath = fileS.getAbsolutePath();
                            File file = new File(rootPath);
                            //System.out.println(file.getAbsolutePath());
                            File fl[] = file.listFiles();
                            //System.out.println(fl.length);
                            for (int i = 0; i < fl.length; i++) {
                                File file1 = fl[i];
                                if (file1.isDirectory()) {
                                    pw.println("<dir>      " + file1.getName() + "          " + file1.length());
                                } else {
                                    pw.println("<file>     " + file1.getName() + "          " + file1.length());
                                }
                            }
                        } else {
                            File file = new File(rootPath);
                            File fl[] = file.listFiles();
                            for (int i = 0; i < fl.length; i++) {
                                File file1 = fl[i];
                                if (file1.isDirectory()) {
                                    pw.println("<dir>      " + file1.getName() + "          " + file1.length());
                                } else {
                                    pw.println("<file>     " + file1.getName() + "          " + file1.length());
                                }
                            }
                        }
                    } else if (info.substring(0,3).equals("get")) {

                    } else if (info.substring(0,2).equals("cd")) {
                        String[] s1 = info.split(" ");
                        File file = new File(rootPath);
                        File fl[] = file.listFiles();
                        int flag = 0;
                        for (int i = 0; i < fl.length; i++) {
                            File file1 = fl[i];
                            if (file1.isDirectory()) {
                                if (s1[1].equals(file1.getName())) {
                                    flag = 1;
                                }
                            }
                        }
                        if (flag == 1) {
                            rootPath = rootPath +"/" + s1[1];
                            pw.println(s1[1] + ">OK");
                        } else {
                            pw.println("unknown dir");
                        }

                    }else if (info.equals("cd..")) {

                    } else if (info.equals("quit")) {//如果用户输入“quit”就退出
                        System.out.println("再见");
                        break;
                    } else {
                        System.out.println("unknown cmd");
                    }
                }
            } //如果客户端断开连接，则应捕获该异常，但不应中断整个while循环，使得服务器能继续与其他客户端通信
            catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null != socket) {
                    try {
                        socket.close(); //断开连接
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
