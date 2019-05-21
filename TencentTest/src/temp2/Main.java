package temp2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.valueOf(scanner.nextLine());
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.valueOf(strings[i]);
            }
            System.out.println(getLeastBuckets(nums, n));
        }
    }

    private static int getLeastBuckets(int[] nums, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        if (map.values().contains(1)) {
            return 0;
        }
        int min = Collections.min(map.values());
        for (Integer o : map.values()) {
            if (o % min != 0) {
                return 0;
            }
        }
        int times = 0;
        for (Integer o : map.values()) {
            while (o != 0) {
                times++;
                o -= min;
            }
        }
        return times;
    }
}
