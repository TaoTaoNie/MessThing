package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.*;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            executorService.execute(new SocketHandler(socketChannel));
        }
    }
}
