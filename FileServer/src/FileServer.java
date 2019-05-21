package src;

import java.io.File;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FileServer {
    private final static int TCP_PORT = 2021;
    private final static int UDP_PORT = 2020;
    private final static int POOL_SIZE = 4;

    private ServerSocket serverSocket;
    private DatagramSocket datagramSocket;
    private ExecutorService executorService;
    private File root;

    private FileServer(File root) throws IOException {
        serverSocket = new ServerSocket(TCP_PORT);
        datagramSocket = new DatagramSocket(UDP_PORT);
        //
        executorService = Executors.newFixedThreadPool(POOL_SIZE);
        this.root = root;
        System.out.println("服务器启动。");
    }

    private void service() {
        Socket socket = null;
        // udp链接
        new Thread(new UdpHandler(datagramSocket)).start();
        // tcp连接
        while (true) {
            try {
                socket = serverSocket.accept();
                executorService.execute(new TcpHandler(root, socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String usage = "usage: java FileServer <dir>";
        if(args.length != 1) {
            System.out.println(usage);
            System.exit(0);
        } else {
            File root = new File(args[0]);
            if(!root.isDirectory()) {
                System.out.println(usage);
            } else {
                new FileServer(root).service();
            }
        }
    }

}
