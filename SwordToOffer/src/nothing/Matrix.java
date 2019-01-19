package nothing;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Matrix {
    /**
     * 剑指offer-P161
     * 题目描述
     *          输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * @param numbers 该矩阵
     * @param columns 矩阵列数
     * @param rows 矩阵列数
     */
    private void printMatrixClockWisely(int[][] numbers, int columns, int rows) {
        if (numbers == null || columns <= 0 || rows <= 0)
            return;
        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            printMatrixInCircle(numbers, columns, rows, start);
            ++start;
        }
    }

    private void printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        for (int i = start; i <= endX; i++) {
            System.out.println(numbers[start][i]);
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.println(numbers[i][endX]);
            }
        }

        if (start < endX && start <endY) {
            for (int i = endX - 1; i >= start; --i) {
                System.out.println(numbers[endY][i]);
            }
        }

        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                System.out.println(numbers[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] numbers = {{1, 2, 3, 4},
                           {5, 6, 7, 8},
                           {9, 10, 11, 12},
                           {13, 14, 15, 16}};
        new Matrix().printMatrixClockWisely(numbers, 4, 4);
    }
}
