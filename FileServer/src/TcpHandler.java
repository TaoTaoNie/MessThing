import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class TcpHandler implements Runnable{
    private Socket socket;
    private File root;
    private File currentDir;
    private BufferedReader br;
    private BufferedWriter bw;
    private PrintWriter pw;

    public TcpHandler(File root, Socket socket) {
        this.socket = socket;
        this.root = root;
        this.currentDir = root;
    }

    public void initStream() throws IOException { //初始化输入输出流对象方法
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        pw = new PrintWriter(bw, true);
    }

    public void run() { // 执行的内容
        try {
            System.out.println("新连接，连接地址：" + socket.getInetAddress() + ": "
                    + socket.getPort());
            initStream();
            pw.println(socket.getInetAddress().getHostAddress() + ":" + socket.getPort()
                    + ">连接成功");
            String info = null;
            while (null != (info = br.readLine())) {
                if (info.equals("ls")) {
                    for (File f : currentDir.listFiles()) {
                        pw.println((f.isFile() ? "<file>" : "<dir>") + "\t"
                                + f.getName() + "\t\t" + f.length());
                    }
                } else if (info.startsWith("cd")) {
                    String dir = info.substring(2).trim();
                    File cdFile = new File(currentDir.getAbsolutePath() + File.separator + dir);
//					System.out.println(cdFile.getPath());
                    if(cdFile.isDirectory()) {
                        if(dir.equals(".")) {}
                        else if(dir.equals("..")) {
                            if(!currentDir.equals(root))
                                currentDir = currentDir.getParentFile();
                        } else {
                            currentDir = cdFile;
                        }
                        pw.println(currentDir.getName() + " > OK");
                    } else {
                        pw.println("unknown dir");
                    }
//					System.out.println(currentDir.getPath());
                } else if (info.startsWith("get")) {
                    String file = info.substring(3).trim();
                    File getFile = new File(currentDir.getAbsolutePath() + File.separator + file);
                    if(getFile.isFile()) {
                        pw.println("OK");
                        // 文件的决定路径
                        pw.println(getFile.getAbsolutePath());
                        pw.println(getFile.length());
                    } else {
                        pw.println("unknown file");
                    }
                } else if (info.equals("bye")) {
                    break;
                }
                pw.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
