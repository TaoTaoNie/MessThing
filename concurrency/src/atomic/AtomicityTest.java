package atomic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leetHuam
 * @version 1.0
 */
public class AtomicityTest implements Runnable {
//    private int i = 0;
//    public int getValue() {return i;}
//    private synchronized void evenIncrement() {i++; i++;}
//    public void run() {
//        while (true)
//            evenIncrement();
//    }

    private AtomicInteger i = new AtomicInteger(0);

    public int getValue() {
        return i.get();
    }

    public void evenIncrement() {
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        executorService.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
