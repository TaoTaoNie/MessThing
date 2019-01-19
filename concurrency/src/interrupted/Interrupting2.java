package interrupted;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Interrupting2 {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new Blocked2());
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing thread.interrupt()");
        thread.interrupt();
    }
}

class BlockedMutex {
    private Lock lock = new ReentrantLock();
    public BlockedMutex() {
        lock.lock();
    }

    public void f() {
        try {
            lock.lockInterruptibly();
            System.out.println("lock acquired in f()");
        } catch (InterruptedException e) {
            System.out.println("Interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable {
    BlockedMutex blockedMutex = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("Waiting for f() in BlockedMutex");
        blockedMutex.f();
        System.out.println("Broken out of blocked call");
    }
}
