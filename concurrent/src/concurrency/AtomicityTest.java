package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leetHuam
 * @version 1.0
 */
public class AtomicityTest implements Runnable {
    private int i = 0;
    public synchronized int getValue() {return i;}
    private synchronized void evenIncrement() {
        i++;
        i++;
    }
    public void run() {
        while(true)
            evenIncrement();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        executorService.execute(at);
        while(true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(1);
            }
        }
    }
}
