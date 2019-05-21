package nothing;

import java.util.HashMap;

/**
 * 经典的 Top K 问题，面试官经常问(下面是最小的 k 个数的解法（使用的是大顶堆），如果是最大的 K 个数的话，使用小顶堆就好了)
 * 还有一种解决 top k 的算法就是利用快排的思想：分治
 * 详情请见：https://blog.csdn.net/luochoudan/article/details/53736752
 * @author leetHuam
 * @version 1.0
 */
public class TopK {
    /**
     * 利用堆解决 TOP K问题
     * @param array 建立堆的数组
     */
    private static void buildHeap(int[] array) {
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heaplify(array, i, length);
        }
    }

    private static void heaplify(int[] array, int index, int length) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (index != largest) {
            swap(array, index, largest);
            heaplify(array, largest, length);
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void setTop(int[] array, int top) {
        array[0] = top;
        heaplify(array, 0, array.length);
    }

    private static int[] topN(int[] array, int k) {
        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = array[i];
        }
        buildHeap(top);
        for (int j = k; j < array.length; j++) {
            if (array[j] < top[0]) {
                setTop(top, array[j]);
            }
        }
        return top;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 5, 2, 6, 7, 10, 3, 14, 34};
        int[] array1 = { 9, 3, 1, 10, 5, 7, 6, 2, 8, 0};
        int k = 4;
        int[] result = topN(array1, k);
        for (int i = 0; i < k; i++) {
            System.out.println(result[i]);
        }
        System.out.println("----------------------------------");
        topK(array, k);
        for (int i = 0; i < k; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    private static int partition(int[] array, int low, int high) {
        int i = low, j = high, base = array[low];
        while (i < j) {
            while (array[j] >= base && j > i) {
                j--;
            }
            if (j > i) {
                array[i] = array[j];
                i++;
                while (array[i] <= base && i < j) {
                    i++;
                }
                if (i < j) {
                    array[j] = array[i];
                    j--;
                }
            }
        }
        array[i] = base;
        return i;
    }

    private static void topK(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return;
        }
        int low = 0;
        int high = array.length - 1;
        int index = partition(array, low, high);
        while (index != k - 1) {
            if (index > k - 1) {
                high = index - 1;
                index = partition(array, low, high);
            }
            if(index < k - 1) {
                low = index + 1;
                index = partition(array, low, high);
            }
        }
    }
}
