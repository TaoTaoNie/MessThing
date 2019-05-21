package D3_20;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Main {
    private int calculator(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();

        int res = 0;
        long preVal = 0;
        char sign = '+';
        int i = 0;
        while (i < length) {
            long curVal = 0;
            while (i < length && (int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48) {
                curVal = curVal*10 + (s.charAt(i) - '0');
                i++;
            }
            if (sign == '+') {
                res += preVal;
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;
                preVal = -curVal;
            }
            if (i < length) {
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }
    public static void main(String[] args) {
        String str = "23-86-6+37+24-8-13";
        System.out.println(new Main().calculator(str));
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        ExecutorService executorService3 = Executors.newScheduledThreadPool(5);
    }
}
