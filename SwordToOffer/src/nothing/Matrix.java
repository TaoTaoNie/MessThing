package nothing;

import java.util.ArrayList;

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
        int endY = columns - 1 - start;
        int endX = rows - 1 - start;
        for (int i = start; i <= endY; i++) {
            System.out.println(numbers[start][i]);
        }

        if (start < endY) {
            for (int i = start + 1; i <= endX; i++) {
                System.out.println(numbers[i][endY]);
            }
        }

        if (start < endY && start <endX) {
            for (int i = endY - 1; i >= start; --i) {
                System.out.println(numbers[endX][i]);
            }
        }

        if (start < endY && start < endX - 1) {
            for (int i = endX - 1; i >= start + 1; i--) {
                System.out.println(numbers[i][start]);
            }
        }
    }

    public static void main(String[] args) {
//        int[][] numbers = {{1, 2, 3, 4},
//                           {5, 6, 7, 8},
//                           {9, 10, 11, 12},
//                           {13, 14, 15, 16}};
//        int[][] numbers = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] numbers = {{1},{2},{3},{4},{5}};
        System.out.println(new Matrix().printMatrix(numbers));
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        final int times = 2;
        while (rows > start * times && columns > start * times) {
            addToList(result, matrix, rows, columns, start);
            ++start;
        }
        return result;
    }

    public void addToList(ArrayList<Integer> result, int[][] matrix, int rows, int columns, int start) {
        int endY = columns - 1 - start;
        int endX = rows - 1 - start;
        for (int i = start; i <= endY; i++) {
            result.add(matrix[start][i]);
        }
        if (endX > start) {
            for (int i = start + 1; i <= endX; i++) {
                result.add(matrix[i][endY]);
            }
        }
        if (endY > start && endX > start) {
            for (int i = endY - 1; i >= start; i--) {
                result.add(matrix[endX][i]);
            }
        }
        if (endX - 1 > start && endY > start) {
            for (int i = endX - 1; i > start; i--) {
                result.add(matrix[i][start]);
            }
        }

    }
}
