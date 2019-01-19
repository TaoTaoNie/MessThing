package sort;

/**
 * 实现一些经典的排序算法同时含有这些经典算法的各种比较 （以空间复杂度换时间复杂度）
 *
 *  排序算法    时间复杂度（平均）   时间复杂度（最坏）   时间复杂度（最好）   空间复杂度    稳定性(指排序完成后相等的值会不会交换位置，不交换贼为稳定，交换则为不稳定)
 *
 *  插入排序    O(n^2)              O(n^2)              O(n)                O(1)        稳定
 *
 *  希尔排序    O(n^1.3)            O(n^2)              O(n)                O(1)        不稳定
 *
 *  选择排序    O(n^2)              O(n^2)              O(n)                O(1)        不稳定
 *
 *  堆排序      O(n log n)          O(n log n)          O(n log n)          O(1)        不稳定
 *
 *  冒泡排序    O(n^2)              O(n^2)              O(n)                O(1)        稳定
 *
 *  快速排序    O(n log n)          O(n^2)              O(n log n)          O(n log n)  不稳定
 *
 *  归并排序    O(n log n)          O(n log n)          O(n log n)          O(n)        稳定
 *
 *
 *  计数排序    O(n + k)            O(n + k)            O(n + k)            O(n + k)    稳定
 *
 *  桶排序      O(n + k)            O(n^2)              O(n)                O(n + k)    稳定
 *
 *  基数排序    O(n*k)              O(n*k)              O(n*k)              O(n + k)    稳定
 *
 * @author leetHuam
 * @version 1.0
 */
public class Sort {
    /**
     * 冒泡排序
     * 算法描述
     *          1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     *          2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     *          3.针对所有的元素重复以上的步骤，除了最后一个；
     *          4.重复步骤1~3，直到排序完成。
     * @param numbers 被排序的
     */
    private void bubbleSort(int[] numbers) {
        if (numbers == null || numbers.length <= 0)
            return;
        for (int i = 0; i < numbers.length -1; i++){
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if(numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 算法描述
     *          1.初始状态：无序区为 R[1..n], 有序区为空
     *          2.第i趟排序 (i = 1, 2, 3, 4....n-1) 开始时，当前有序区和无序区分别为 R[1..i-1] 和 R[i..n], 该
     *            该趟排序从当前无序区中选出关键字最小的记录 R[k],将它与无序区的第 1 个记录 R 交换，使 R[1..i] 和
     *            R[i+1..n] 分别变为记录个数增加 1 个的有序区和记录减少 1 个的无序区；
     *          3.n-1 趟，数组有序了
     * @param numbers 进行排序的数组
     */
    private void selectSort(int[] numbers) {
        if (numbers == null || numbers.length <= 0)
            return;
        int minIndex, temp;
        for (int i = 0; i < numbers.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex])
                    minIndex = j;
            }
            temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
    }

    /**
     * 插入排序
     * 算法描述
     *          1.从第一个元素开始，该元素可以认为已经被排序；
     *          2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
     *          3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
     *          4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     *          5.将新元素插入到该位置后；
     *          6.重复步骤2~5
     * @param numbers 需要排序的数组
     */
    private void insertSort(int[] numbers) {
        if (numbers == null || numbers.length <= 0)
            return;
        int preIndex, current;
        for (int i = 1; i < numbers.length; i++) {
            preIndex = i - 1;
            current = numbers[i];
            while (preIndex >= 0 && numbers[preIndex] > current) {
                numbers[preIndex + 1] = numbers[preIndex];
                preIndex--;
            }
            numbers[preIndex + 1] = current;
        }
    }

    /**
     * 希尔排序
     * 算法描述
     *          1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     *          2.按增量序列个数k，对序列进行k 趟排序；
     *          3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     *            仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param numbers 需要排序的数组
     */
    private void shellSort(int[] numbers) {
        if (numbers == null || numbers.length <= 0)
            return;
        for (int gap = numbers.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < numbers.length; i++) {
                int j = i;
                int temp = numbers[j];
                if (numbers[j] < numbers[j - gap]) {
                    while (j - gap >= 0 && temp < numbers[j - gap]) {
                        numbers[j] = numbers[j - gap];
                        j -= gap;
                    }
                    numbers[j] = temp;
                }
            }
        }
    }

    /**
     * 归并排序
     * 算法描述
     *          1.把长度为n的输入序列分成两个长度为n/2的子序列；、
     *          2.对这两个子序列分别采用归并排序；
     *          3.将两个排序好的子序列合并成一个最终的排序序列。
     * @param numbers 排序的数组
     * @param left 数组的左起点
     * @param right 数组的右起点
     */
    private void mergeSort(int[] numbers, int left, int right) {
        if (numbers == null || numbers.length <= 0 || left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(numbers, left, mid);
        mergeSort(numbers, mid + 1, right);
        merge(numbers, left, mid, right);
    }

    private void merge(int[] numbers, int left, int mid, int right) {
        int[] temp = new int[numbers.length];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (numbers[i] <= numbers[j])
                temp[k++] = numbers[i++];
            else
                temp[k++] = numbers[j++];
        }
        while (i <= mid)
            temp[k++] = numbers[i++];
        while (j <= right)
            temp[k++] = numbers[j++];
        for(i = 0; i < k; i++)
            numbers[left + i] = temp[i];
    }

    /**
     * 快速排序
     * 算法描述
     *          1.从数列中挑出一个元素，称为 “基准”（pivot）;
     *          2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     *            在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     *          3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param numbers 排序的数组
     * @param left 数组左边边界
     * @param right 数组右边边界
     */
    private void quickSort(int[] numbers, int left, int right) {
        int i = left, j = right, base = numbers[left];
        while (i < j) {
            while (numbers[j] >= base && j > i)
                j--;
            if (j > i) {
                numbers[i] = numbers[j];
                i++;
                while (numbers[i] <= base && i < j)
                    i++;
                if (i < j) {
                    numbers[j] = numbers[i];
                    j--;
                }
            }
        }
        numbers[i] = base;
        if (left < (i - 1))
            quickSort(numbers, left, i - 1);
        if ((j + 1) < right)
            quickSort(numbers, j + 1, right);
    }

    /**
     * 堆排序
     * 算法描述
     *          1.将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
     *          2.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
     *          3.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后
     *            一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
     * @param numbers 排序的数组
     */
    private void heapSort(int[] numbers) {
        if (numbers == null || numbers.length <= 0)
            return;
        for (int i = numbers.length/2 - 1; i >= 0; i--) {
            buildBigHeap(numbers, i, numbers.length);
        }
        for (int j = numbers.length - 1; j > 0; j--) {
            int temp = numbers[j];
            numbers[j] = numbers[0];
            numbers[0] = temp;
            buildBigHeap(numbers, 0, j);
        }
    }

    private void buildBigHeap(int[] numbers, int current, int length) {
        int temp = numbers[current];
        for (int k = 2 * current + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && numbers[k] < numbers[k + 1])
                k++;
            if (numbers[k] > temp) {
                numbers[current] = numbers[k];
                current = k;
            }else {
                break;
            }
        }
        numbers[current] = temp;
    }

    public static void main(String[] args){
        int[] numbers = {80, 30, 60, 40, 20, 10, 50, 70, 55, 45, 34, 65, 63, 23, 65, 23, 76, 23, 52};
        new Sort().heapSort(numbers);
        new Sort().mergeSort(numbers, 0, numbers.length - 1);
        new Sort().bubbleSort(numbers);
        new Sort().selectSort(numbers);
        new Sort().shellSort(numbers);
        new Sort().insertSort(numbers);
        new Sort().quickSort(numbers, 0, numbers.length - 1);
        for(int i : numbers)
            System.out.println(i);
    }
}
