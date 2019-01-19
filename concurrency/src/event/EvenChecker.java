package event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leetHuam
 * @version 1.0
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        int val = generator.next();
        if (val % 2 != 0) {
            System.out.println(val + " not even!");
            generator.cancel();
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++)
            executorService.execute(new EvenChecker(gp, i));
        executorService.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
