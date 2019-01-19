package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指offer-P39
 *
 * @author leetHuam
 * @version 1.0
 */
public class Duplicate {
    /**
     * 这是一个用来查找一维数组中重复的数字的方法，可以选择返回第一个重复的数字
     * 时间复杂度 O（n） 空间复杂度 O（1）
     *
     * @param numbers 这个一维数组
     * @param dup     第一个重复的数字
     * @return 是否含有重复，如果有，返回true，否则返回false
     */
    private static boolean duplicate(int[] numbers, Integer dup) {
        /*如果传进来的数组为空（java传递数组也是引用传递，其实就是传的对象的引用）*/
        if (numbers == null || numbers.length <= 0)
            return false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1)
                return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    dup = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] numbers = {1,2,3,4,5,5,6,7,9,8};
//        Integer dup = 0;
//        boolean test = duplicate(numbers, dup);
//        System.out.println(test);
//        System.out.println(dup);
        List<Integer> NumberList = new ArrayList<Integer>();
        NumberList.add(2);
        NumberList.add(4);
        NumberList.add(1);
        NumberList.add(3);
        NumberList.add(5);
        for (int i = 0; i < NumberList.size(); ++i) {
            int v = NumberList.get(i);
            if (v % 2 == 0) {
                NumberList.remove(v);
            }
        }
        System.out.println(NumberList);
    }
}
