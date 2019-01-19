package runnable;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author leetHuam
 * @version 1.0
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            /*
             * 设置该线程为后台线程
             */
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(100);
    }
}
