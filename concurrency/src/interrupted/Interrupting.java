package interrupted;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Interrupting {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    static void test(Runnable runnable) throws InterruptedException {
        Future<?> f = executorService.submit(runnable);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + runnable.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt sent to " + runnable.getClass().getName());
    }

    public static void main(String[] args) throws Exception{
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);

    }

}

class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream is) {
        in = is;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for read()");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted())
                System.out.println("Interrupted from blocked I/O");
            else
                throw new RuntimeException(e);
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true)
            Thread.yield();
    }

    public SynchronizedBlocked() {
        new Thread() {
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}
