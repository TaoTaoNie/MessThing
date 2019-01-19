package Fibonacci;

/**
 * 剑指offer-P74
 * @author leetHuam
 * @version 1.0
 */
public class Fibonacci {
    /**
     * 求斐波那契数列的第 n 项 （使用递归求得， 适用于 n 比较小的时候）可以用来解决青蛙跳台阶的问题：
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级台阶. 求该青蛙跳上一个 n 级的台阶总共有多少种跳法
     * @param n 第 n 项
     * @return 所求到的第 n 项
     */
    private long fibonacci1(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    /**
     * 使用循环求斐波那契数列（适用于 n 比较大的情况）
     * @param n 第 n 项
     * @return 所求到的第 n 项
     */
    private long fibonacci2(int n) {
        int[] result = {0, 1};
        if (n < 2)
            return result[n];
        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }

    /**
     * 青蛙跳台阶的扩展问题：一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级 ...... 它也可以跳上 n 级，此时该青蛙跳上一个 n 级的台阶共有多少中跳法。
     * @param n 台阶数
     * @return 方法数
     */
    private long jump(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return jump(n - 1) * 2;
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibonacci1(5));
//        System.out.println(new Fibonacci().fibonacci2(5));
//        System.out.println(-7 % 23);
    }
}
