package Array;

/**
 * 剑指offer-P41
 * @author leetHuam
 * @version 1.0
 */
public class GetDuplication {
    /**
     * 不修改数组找出重复的数字
     * 在一个长度为 n+1 的数组里的所有数字都在 1~n 的范围内， 所以数组中至少有一个数字是重复的。请找出数组中任意一个
     * 重复的数字，但不能修改输入的数组。时间复杂度 O（nlogn） 空间复杂度 O（1）
     * @param numbers 不能修改的数组
     * @return 找到的一个重复的数字
     */
    private static int getDuplication(final int[] numbers) {
        if (numbers == null || numbers.length <= 0)
            return -1;
        int start = 1;
        int end = numbers.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, start, middle);
            if (end == start) {
                if (count > 1)
                    return start;
                else
                    break;
            }
            if (count > (middle - start) + 1)
                end = middle;
            else
                start = middle + 1;
        }
        return -1;
    }

    private static int countRange(final int[] numbers, int start, int end) {
        if (numbers == null || numbers.length <= 0)
            return 0;
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= start && numbers[i] <= end)
                ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getDuplication(numbers));

    }

}
