package search;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Search {
    /**
     * 剑指offer-P83
     * 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小
     * 元素。例如，数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，该数组的最小值为 1.
     *
     * @param numbers 查找的数组
     * @return 返回查找到的最小值
     */
    private int minSearch(int[] numbers) {
        if (numbers == null || numbers.length <= 0)
            return -1;
        int i = 0, j = numbers.length - 1, mid = 0;
        while (numbers[i] >= numbers[j]) {
            if ((j - i) == 1) {
                mid = j;
                break;
            }
            mid = (i + j) / 2;
            if (numbers[i] == numbers[j] && numbers[i] == numbers[mid])
                return minInOrder(numbers, i, j);
            if (numbers[mid] >= numbers[i])
                i = mid;
            else if (numbers[mid] <= numbers[j])
                j = mid;
        }
        return numbers[mid];
    }

    private int minInOrder(int[] numbers, int start, int end) {
        int result = numbers[start];
        for (int i = start + 1; i <= end; i++) {
            if (result > numbers[i])
                result = numbers[i];
        }
        return result;
    }

    /**
     * 剑指offer-P89
     * 使用回溯法在一个字符矩阵中寻找一条指定的字符串
     * 题目描述
     *          请设计一个函数，用来判断在一个据陈中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下
     *          移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如， 在下面的 3 * 4 的矩阵中包含一条字符串 “bfce” 的路径（路劲中的字母用
     *          下划线标出）。但矩阵中不包含字符串 “abfb” 的路径，因为字符串的第一个字符 b 占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     *          a   b   t   g
     *          c   f   c   s
     *          j   d   e   h
     * @param matrix 字符矩阵
     * @param rows 行数
     * @param cols 列数
     * @param str 对应的字符数组，以空格号结尾（由于 java 语言的原因）
     * @return 是否含有
     */
    private boolean hasPath(char[][] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null)
            return false;
        boolean[] visited = new boolean[rows * cols];
        Integer pathLength = new Integer(0);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean hasPathCore(final char[][] matrix, int rows, int cols, int row, int col, final char[] str, Integer pathLength, boolean[] visited) {
        if (new Character(str[pathLength]).equals(' '))
            return true;
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && new Character(matrix[row][col]).equals(str[pathLength]) && !visited[row * cols + col]) {
            ++pathLength;
            visited[row * cols + col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited) ||
                      hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited) ||
                      hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited) ||
                      hasPathCore(matrix, rows, cols, row  + 1, col, str, pathLength, visited);
            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    /**
     * 剑指offer-P92
     * 机器人的运动范围
     *                  地上有个m行n列的方格。一个机器人从坐标（0， 0）的格子开始移动，它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
     *                  大于k的格子。例如，当 k 为 18 时，机器人能够进入方格（35，37），因为 3 + 5 + 3 + 7 = 18.但他不能就如方格（35， 38），因为 3 + 5 + 3 + 8 = 19
     *                  请问该机器人能够到达多少个格子
     * @param threshold k值
     * @param rows 行数
     * @param cols 列数
     * @return 能够到达的格数
     */
    private int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0)
            return 0;
        boolean[] visited = new boolean[rows * cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if(check(threshold,rows, cols, row, col,visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                      + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                      + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                      + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && col >= 0 && row < rows && col < cols && getDigitSum(row) + getDigitSum(col) <= threshold && !visited[row * cols + col])
            return true;
        return false;
    }

    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    /**
     * 剑指offer-P96
     * 剪绳子
     *        给你一根长为 n 的绳子，请剪成 m 段（ m、n 都是整数， n > 1 并且 m > 1）,每段绳子的长度记为 k[0], k[1], ... ,k[m]. 请问 k[0] * k[1] * ... * k[m]可能的最大
     *        乘积是多少？例如，当绳子的长度是 8 时， 我们把它剪成长度分别为 2、3、3的三段，此时得到的最大的乘积是 18.
     * @param length 绳子长度
     * @return 最大的乘积
     */
    private int maxProductAfterCutting_solution_1(int length)
    {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; ++i) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i - j];
                if (max < product)
                    max = product;
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }

    /**
     * 剑指offer-P96
     * 剪绳子
     *        给你一根长为 n 的绳子，请剪成 m 段（ m、n 都是整数， n > 1 并且 m > 1）,每段绳子的长度记为 k[0], k[1], ... ,k[m]. 请问 k[0] * k[1] * ... * k[m]可能的最大
     *        乘积是多少？例如，当绳子的长度是 8 时， 我们把它剪成长度分别为 2、3、3的三段，此时得到的最大的乘积是 18.
     * @param length 绳子长度
     * @return 最大的乘积
     */
    private int maxProductAfterCutting_solution_2(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1)
            timesOf3 -= 1;
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int)(Math.pow(2, timesOf2));
    }

    public static void main(String[] args) {
        Search search = new Search();
//        int[] numbers = {3, 4, 5, 1, 2};
//        int[] numbers2 = {1};
//        int[] ints = null;
//        char[][] matrix = {{'a', 'b', 't', 'g'},
//                           {'c', 'f', 'c', 's'},
//                           {'j', 'd', 'e', 'h'}};
//        char[] str = {'b', 'f', 'c', 'e', ' '};
//        System.out.println(new Search().minSearch(numbers));
//        System.out.println(new Search().minSearch(numbers2));
//        System.out.println(new Search().minSearch(ints));
//        System.out.println(new Search().hasPath(matrix, 3, 4, str));
//        System.out.println(new Search().movingCount(18, 40, 51));
//        System.out.println(new Search().movingCount(0, 1, 0));
//        System.out.println(new Search().movingCount(-1, 3, 4));
        System.out.println(search.maxProductAfterCutting_solution_1(5));
        System.out.println(search.maxProductAfterCutting_solution_1(8));
        System.out.println(search.maxProductAfterCutting_solution_1(9));
        System.out.println(search.maxProductAfterCutting_solution_1(2));
        System.out.println(search.maxProductAfterCutting_solution_1(20));
        System.out.println(search.maxProductAfterCutting_solution_2(0));
        System.out.println(search.maxProductAfterCutting_solution_2(1));
        System.out.println(search.maxProductAfterCutting_solution_2(2));
        System.out.println(search.maxProductAfterCutting_solution_2(3));
        System.out.println(search.maxProductAfterCutting_solution_2(4));
    }
}
