package Array;

/**
 * 剑指offer-P44
 * @author leetHuam
 * @version 1.0
 */
public class FindInArray {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个
     * 函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。空间复杂度 O（1） 时间复杂度 O（n）
     * @param matrix 该二维数组
     * @param rows 数组行数
     * @param columns 数组列数
     * @param number 要找的数字
     * @return 返回结果
     */
    private static boolean find(int[][] matrix, int rows, int columns, int number) {
        boolean found = false;
        if (matrix != null && rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0) {
                if (matrix[row][column] == number) {
                    found = true;
                    break;
                } else if (matrix[row][column] > number)
                    --column;
                else
                    ++row;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9},
                          {2, 4, 9, 12},
                          {4, 7, 10, 13},
                          {6, 8, 11, 15}};
        System.out.println(find(matrix, 4, 4, 20));
    }
}
