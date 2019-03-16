package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author leetHuam
 * @version 1.0
 */
public class solution_0314 {
    static Map<Integer, Character> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        findPath(n, k, 1);
        System.out.println(map);
    }

    private static void findPath(int target, int k, int i) {
        if (target > 0 && k > 0) {
            if (i < target) {
                map.put(i, '+');
                target = target - i;
                k -= 1;
                findPath(target, k, 2 * i);
                findPath(target, k, 2 * i + 1);
            } else if (i == target) {
                map.put(i, '+');
                return;
            } else {
                map.put(i, '-');
                target += i;
                k -= 1;
                findPath(target, k, 2 * i);
                findPath(target, k, 2 * i + 1);
            }
        }
        if (target < 0 && k > 0) {
            if (abs(target) == i) {
                map.put(i, '-');
            } else if (abs(target) > i) {
                map.put(i, '-');
                target += i;
                k -= 1;
                findPath(target, k, 2 * i);
                findPath(target, k, 2 * i + 1);
            } else {
                map.put(2 * i, '+');
                target -= 2 * i;
                k -= 1;
                findPath(target, k, 2 * i);
                findPath(target, k, 2 * i + 1);
            }
        }

    }

    private static int abs(int n) {
        return n > 0 ? n : -n;
    }

}
