package CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author leetHuam
 * @version 1.0
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        System.out.println(testTry());
    }

    private static int testTry() {
        int i = 1;
        try {
            return i;
        } finally {
            i = 2;
            return i;
        }
    }
}
