package server;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author leetHuam
 * @version 1.0
 */
public class SocketHandler implements Runnable {
    private SocketChannel socketChannel;

    public SocketHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            int num;
            while ((num = socketChannel.read(buffer)) > 0) {
                buffer.flip();
                byte[] bytes = new byte[num];
                buffer.get(bytes);
                String result = new String(bytes, "UTF-8");
                System.out.println("收到请求：" + result);

                ByteBuffer writeBuffer = ByteBuffer.wrap(("我已经收到你的请求，你的请求内容是：" + result).getBytes());
                socketChannel.write(writeBuffer);
                buffer.clear();
            }
        }catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
