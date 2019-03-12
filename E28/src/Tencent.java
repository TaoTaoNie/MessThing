import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Tencent {
    public int largestSumAfterKNegations(int[] A, int K) {
        int length = A.length;
        if (A == null || length == 0 ) {
            System.out.println("数组有问题");
            return 0;
        }
        int negative = negativeNums(A, length);
        if (negative == 0) {
            Arrays.sort(A);
            min(A, K);
            return sum(A, length);
        } else if (negative >= K) {
            minKnumNegation(A, K);
            return sum(A, length);
        } else {
            minKnumNegation(A, negative);
            min(A, K - negative);
            return sum(A, length);
        }

    }

    private int negativeNums(int[] nums, int length) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0) {
                count++;
            }
        }
        return count;
    }

    private int sum(int[] nums, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private void minKnumNegation(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            nums[i] = -nums[i];
        }
        Arrays.sort(nums);
    }

    private void min(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            nums[0] = -nums[0];
        }
    }

    public int clumsy(int N) {
        List<Integer> list = new ArrayList<>();
        int i = N;
        int flag = 0;
        for (; i >= 4; i -= 4) {
            if (flag == 0) {
                int temp = i * (i -1) / (i - 2) + (i - 3);
                list.add(temp);
                flag = 1;
            } else {
                int temp = i * (i -1) / (i - 2) - (i - 3);
                list.add(temp);
            }
        }
        if(i == 3) {
            list.add(6);
        }
        if (i == 2) {
            list.add(2);
        }
        if (i == 1) {
            list.add(1);
        }
        int sum = list.get(0);
        for (int j = 1; j < list.size(); j++) {
            sum -= list.get(j);
        }
        return sum;
    }

    public int minDominoRotations(int[] A, int[] B) {
        int aLen = A.length, bLen = B.length;
        if (A == null || aLen == 0 || B == null || bLen == 0) {
            return -1;
        }
        if (aLen != bLen) {
            return -1;
        }
        int[] times = new int[7];
        for (int i = 0; i < aLen; i++) {
            times[A[i]]++;
            times[B[i]]++;
        }
        if (max(times, times.length) < aLen) {
            return -1;
        }
        int target = maxIndex(times, times.length);
        for (int i = 0; i < aLen; i++) {
            if (A[i] != target && B[i] != target) {
                return -1;
            }
        }
        int a = aLen - containTimes(A, target);
        int b = aLen - containTimes(B, target);
        return a < b ? a : b;
    }

    private int max(int[] nums, int length) {
        int temp = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] > temp) {
                temp = nums[i];
            }
        }
        return temp;
    }

    private int maxIndex(int[] nums, int length) {
        int temp = 0;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] > temp) {
                temp = nums[i];
                index = i;
            }
        }
        return index;
    }

    private int containTimes(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,3,0,4};
        int k = 3;
        int[] a = new int[1];
        int[] b = {2};
        String s = "pwwkew";

        System.out.println(new Tencent().lengthOfLongestSubstring(s));
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map =new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        int times = array.length / 2 + 1;
        Iterator iterator = map.keySet().iterator();
        int result = 0;
        while (iterator.hasNext()) {
            int key = (int)iterator.next();
            int value = map.get(key);
            if (times <= value) {
                result = key;
                break;
            }
        }
        return result;
    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int temp = 1;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(numbers[i])) {
                duplication[0] = numbers[i];
                temp = numbers[i];
                break;
            }
            map.put(numbers[i], 1);
        }
        return duplication[0] == temp;
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        Set<Character> set = new HashSet();
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
