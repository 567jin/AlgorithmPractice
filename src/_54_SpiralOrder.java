import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-02-26 14:14:43
 */
public class _54_SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix = new int[][]{{6, 9, 7}};
        List<Integer> list = new _54_SpiralOrder().spiralOrder(matrix);
        System.out.println(list);
    }

    /**
     * 一圈一圈的打印 四个点定位左上左下 右上右下 四个for循环打印这四个点确定的圈  难点在于边界条件的判定
     * <p>
     * [1, 2, 3]
     * [4, 5, 6]
     * [7, 8, 9]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, top = 0, bottom = rows - 1, right = columns - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {  // 打印上边那一行
                res.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {  // 右边那一列
                res.add(matrix[row][right]);
            }

            if (left < right && top < bottom) {  // 判断这四个点所围 是否有四条边
                for (int column = right - 1; column > left; column--) {  // 打印下边那一行
                    res.add(matrix[bottom][column]);
                }

                for (int row = bottom; row > top; row--) {  // 打印左边那一列
                    res.add(matrix[row][left]);
                }
            }
            // 一圈打印完毕 缩圈
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
