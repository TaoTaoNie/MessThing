package nothing;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Shift {
    /**
     * 剑指offer-P102
     * 题目描述
     *          请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
     * @param n 输入的整数
     * @return 1 的个数
     */
    private int numberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = n & (n -1);
        }
        return count;
    }

    /**
     * 剑指offer-P110
     * 题目描述
     *          实现函数 double power(double base, int exponent)，求 base 的 exponent 次方，不考虑大数的情况
     * @param base 基数
     * @param exponent 次方
     * @return 结果
     */
    private double power(double base, int exponent) throws Exception{
        if (base == 0.0 && exponent < 0) {
            throw new Exception("错误输入！");
        }
        double result = 1.0;
        if (exponent < 0) {
            exponent = -exponent;
            for (int i = 1; i <= exponent; i++) {
                result *= base;
            }
            result = 1.0 / result;
            return result;
        }else {
            for (int i = 1; i <= exponent; i++) {
                result *= base;
            }
            return result;
        }
    }

    /**
     * 剑指offer-P114
     * 题目描述
     *          输入数字 n，按顺序从 1 打印到最大的 n 位十进制数，比如输入 3 ，打印 1，2 ，3 到最大的 3 位数 999.
     * @param n n 位数字
     */
    private void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] numbers = new char[n];
        Arrays.fill(numbers, '0');
        while (!increment(numbers)) {
            printNumber(numbers);
        }
    }

    private boolean increment(char[] numbers) {
        boolean isOverflow = false;
        int size = numbers.length;
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {
            int temp = numbers[i] - '0' + carry;
            if (i == size - 1) {
                temp++;
            }
            if (temp >= 10) {
                // 最高位溢出
                if (i == 0) {
                    isOverflow = true;
                } else {
                    temp -= 10;
                    carry = 1;
                    numbers[i] = (char)('0' + temp);
                }
            }else {
                numbers[i] = (char)('0' + temp);
                break;
            }
        }
        return isOverflow;
    }

    private void printNumber(char[] numbers) {
        int size = numbers.length;
        int i = 0;
        while (i < size && numbers[i] == '0') {
            i++;
        }
        if (i == size) {
            return;
        }
        char[] printNum = Arrays.copyOfRange(numbers, i, size);
        System.out.println(printNum);
    }

    public static void main(String[] args) {
        try {
            new Shift().power(0, -1);
        }catch (Exception e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            if (string.equals("bye")) {
                break;
            } else {
                System.out.println(string);
            }
        }
        System.out.println("hello world");
    }
}
