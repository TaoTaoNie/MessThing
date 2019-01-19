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
        if (push == null || pop == null)
            return false;
        if (push.length != pop.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);
            while ((!stack.empty()) && (stack.peek() == pop[j])) {
                stack.pop();
                j++;
            }
        }
        if (stack.empty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {4, 3, 5, 1, 2};
        System.out.println(StackTest.isPopOrder(push, pop1));
        System.out.println(StackTest.isPopOrder(push, pop2));
    }
}
