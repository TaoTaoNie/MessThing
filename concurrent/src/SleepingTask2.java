import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author leetHuam
 * @version 1.0
 */
public class SleepingTask2 implements Runnable {
    private static Random random = new Random();
    private final int sleep_time = random.nextInt(10) + 1;
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(sleep_time);
        }catch (InterruptedException e) {
            System.out.println("Interrupted: " + e);
        }
        System.out.println(sleep_time);
    }
}
