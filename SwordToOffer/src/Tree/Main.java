package Tree;

import java.util.*;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Main {
    private static int getNumber(int n) {
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 3;
        }
        if (n == 3) {
            return 4;
        }
        return getNumber(n - 2) + getNumber(n - 3);
    }

    private static int[] getNumberArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = getNumber(i + 1);
        }
        return array;
    }

    private static int reverse(int n) {
        int result = 0;
        while (n != 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }

    private static int partition(int[] numbers, int left, int right) {
        int i = left, j = right, base = numbers[left];
        while (i < j) {
            while (i < j && numbers[j] < base) {
                j--;
            }
            numbers[i] = numbers[j];
            if (i < j) {
                i++;
                while (i < j && numbers[i] > base) {
                    i++;
                }
                numbers[j] = numbers[i];
            }
        }
        numbers[i] = base;
        return i;
    }

    public static void main(String[] args) {
        String s = "sdfasdfa";
        String[] ss = s.split(",");
        System.out.println(ss);
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        int length = nums.length;
        List<Integer> list = new ArrayList<>(length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list, (o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        });
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
}
