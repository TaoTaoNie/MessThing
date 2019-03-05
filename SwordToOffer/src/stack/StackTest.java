package stack;

import java.util.Stack;

/**
 * @author leetHuam
 * @version 1.0
 */
public class StackTest {
    /**
     * 剑指offer-P168
     * 题目描述：
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。假设压入栈的所有数字均不相等
     * 例如，序列 {1, 2, 3, 4, 5}是某栈的压栈序列，序列 {4, 5, 3, 2, 1}是该压栈序列对应的一个弹出序列，但 {4, 3, 5, 1, 2}
     *
     * @param push 压入栈的序列
     * @param pop  弹出序列
     * @return 返回是否可以是该序列的一个弹出序列
     */
    private static boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null) {
            return false;
        }
        if (push.length != pop.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);
            while ((!stack.empty()) && (stack.peek() == pop[j])) {
                stack.pop();
                j++;
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        return verify(sequence, 0, sequence.length - 1);
    }

    public boolean verify(int[] array, int start, int end) {
        if (end <= start) {
            return true;
        }
        int j = -1;
        for (int i = start; i < end - 1; i++) {
            if (j == -1 && array[i] > array[end - 1]) {
                j = i;
            }
            if (j != -1 && array[i] < array[end - 1]) {
                return false;
            }

        }
        if (j == -1) {
            return verify(array, start, end - 2);
        }
        return verify(array, start, j - 1) && verify(array, j, end - 2);
    }

    public static void main(String[] args) {
//        int[] push = {1, 2, 3, 4, 5};
//        int[] pop1 = {4, 5, 3, 2, 1};
//        int[] pop2 = {4, 3, 5, 1, 2};
//        System.out.println(StackTest.isPopOrder(push, pop1));
//        System.out.println(StackTest.isPopOrder(push, pop2));
        int[] array1 = {4, 7, 9, 6, 5};
        int[] array2 = {2, 1, 5, 4, 3, 9};
        int[] array3 = {2, 1, 6, 5, 4, 3};
        int[] array4 = {4};
//        System.out.println(new StackTest().VerifySquenceOfBST(array1));
        System.out.println(new StackTest().VerifySquenceOfBST(array4));
//        System.out.println(new StackTest().VerifySquenceOfBST(array3));
    }
}
