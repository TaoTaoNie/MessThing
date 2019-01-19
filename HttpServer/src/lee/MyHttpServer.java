package lee;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyHttpServer {
    private final static int PORT = 8080;

    private ServerSocket serverSocket;
    private File root;

    public MyHttpServer(File root) throws IOException {
        this.root = root;
        serverSocket = new ServerSocket(PORT);
        System.out.println("服务器启动");
    }

    public void service() {
        Socket socket = null;

        while (true) {
            try {
                socket = serverSocket.accept();
                new Handler(socket, root).start();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        String usage = "usage: java HttpServer <dir>";
        if(args.length != 1) {
            System.out.println(usage);
            System.exit(0);
        } else {
            File root = new File(args[0]);
            if(!root.isDirectory()) {
                System.out.println(usage);
            } else {
                //打印服务器根目录路径
                //System.out.println("服务器路径：" + root.getAbsolutePath());
                new MyHttpServer(root).service();
            }
        }
    }
}
