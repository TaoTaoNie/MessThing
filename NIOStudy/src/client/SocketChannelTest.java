package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author leetHuam
 * @version 1.0
 */
public class SocketChannelTest {
    public static void main(String[] args) throws IOException{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));

        ByteBuffer buffer = ByteBuffer.wrap("123456789".getBytes());
        socketChannel.write(buffer);
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int num;
        if ((num = socketChannel.read(readBuffer)) > 0) {
            readBuffer.flip();
            byte[] recieve = new byte[num];
            readBuffer.get(recieve);
            String result = new String(recieve, "UTF-8");
            System.out.println("返回值：" + result);
        }
    }
}
