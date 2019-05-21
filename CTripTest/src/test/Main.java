package test;

import java.util.Scanner;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            int n = scanner.nextInt();
            s = s.substring(1, s.length() - 1);
            String[] arr = s.split(",");
            int len = arr.length;
            if (n > len || n <= 0) {
                print(arr);
                continue;
            }
            int i = 1;
            while (i * n <= len) {
                swap(arr, (i - 1) * n, i * n - 1);
                i++;
            }
            print(arr);
        }
    }

    private static void swap(String[] arr, int start, int end) {
        String tmp;
        while (start < end) {
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    private static void print(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
        System.out.println("]");
    }
}
