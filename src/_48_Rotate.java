import java.util.Arrays;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-08 11:02:56
 */
public class _48_Rotate {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9,}};
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        new _48_Rotate().rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 注意到题目中的矩阵都是方形矩阵 因此必有规律可循
     * 每个元素
     */
    public void rotate2(int[][] matrix) {
        if (matrix[0].length == 1) {
            return;
        }


    }

    /**
     * 使用一个额外数组的解法
     */
    public void rotate(int[][] matrix) {
        if (matrix[0].length == 1) {
            return;
        }
        // 使用一个额外数组
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        int col = matrix[0].length - 1;
        for (int[] rowNums : matrix) {
            int row = 0;
            for (int num : rowNums) {
                newMatrix[row++][col] = num;
            }
            col--;
        }
        System.arraycopy(newMatrix, 0, matrix, 0, matrix.length);
    }
}
