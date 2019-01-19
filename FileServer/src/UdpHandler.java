import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.TimeUnit;


public class UdpHandler implements Runnable{
    private DatagramSocket datagramSocket;
    private static int dataLen = 10240;

    public UdpHandler(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                DatagramPacket receiveDp = new DatagramPacket(new byte[1024], 1024);
                datagramSocket.receive(receiveDp);
                String msg = new String(receiveDp.getData(), 0, receiveDp.getLength());
//				System.out.println("udp:" + msg);
                File sendFile = new File(msg);
                if (sendFile.isFile()) {
                    byte[] sendBuff = new byte[dataLen];
                    int size = 0;
                    DatagramPacket sendDp = new DatagramPacket(sendBuff, size, receiveDp.getAddress(), receiveDp.getPort());
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sendFile));
                    while ((size = bis.read(sendBuff)) > 0) {
                        sendDp.setData(sendBuff, 0, size);
                        datagramSocket.send(sendDp);
                        TimeUnit.MICROSECONDS.sleep(1);// 限制传输速度
                    }
                    bis.close();
                } else {

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
