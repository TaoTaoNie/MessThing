package Array;

import java.util.ArrayList;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Test {
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        int times = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length; j++) {
                if (array[j - 1] > array[j]) {
                    times++;
                }
            }
        }
        return times;
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
            } else if (result == array[i]) {
                times++;
            } else {
                times--;
            }
        }
        if (!checkIfThanHalf(array, result)) {
            result = 0;
        }
        return result;
    }

    private boolean checkIfThanHalf(int[] array, int result) {
        boolean thanHalf = true;
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                times++;
            }
        }
        if (times * 2 <= array.length) {
            thanHalf = false;
        }
        return thanHalf;
    }
    public static void main(String[] args) {
        int[] nums = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int k = 4;

        System.out.println(new Test().InversePairs(nums));
    }
}
