package Array;

/**
 * 剑指offer-P129
 * 题目描述
 *          输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * @author leetHuam
 * @version 1.0
 */
public class ReorderArray {
    private void reorderOddEven(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return;
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            while (start < end && (numbers[start] & 0x1) != 0)
                start++;
            while (start < end && (numbers[end] & 0x1) == 0)
                end--;
            if (start < end) {
                int temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
            }
        }
    }
}
