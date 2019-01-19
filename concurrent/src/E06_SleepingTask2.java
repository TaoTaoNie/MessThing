import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leetHuam
 * @version 1.0
 */
public class E06_SleepingTask2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        if (args.length != 1) {
            System.err.println("provide the quantity of tasks to run");
            return;
        }
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            executorService.execute(new SleepingTask2());
        }
        Thread.yield();
        executorService.shutdown();
    }
}
