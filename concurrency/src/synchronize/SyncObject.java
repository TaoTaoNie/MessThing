package synchronize;

import java.util.concurrent.TimeUnit;

/**
 * @author leetHuam
 * @version 1.0
 */
public class SyncObject {
    public static void main(String[] args) throws InterruptedException{
        final DualSynch ds = new DualSynch();
        new Thread() {
            public void run() {
                ds.f();
            }
        }.start();
        TimeUnit.SECONDS.sleep(10);
        ds.g();
    }
}

class DualSynch {
//    private Object syncObject = new DualSynch();
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
