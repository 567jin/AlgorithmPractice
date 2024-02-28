import java.util.Arrays;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-02-28 20:40:19
 */
public class _64_MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        grid = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int i = new _64_MinPathSum().minPathSum(grid);
        System.out.println(i);
    }

    /**
     * 递推公式   dp[m][n] = Math.min(grid[m][n] + dp[m - 1][n], grid[m][n] + dp[m][n - 1]);
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        // 初始化
        dp[0][0] = grid[0][0];
        for (int m = 1; m < row; m++) {
            dp[m][0] = grid[m][0] + dp[m - 1][0];
        }
        for (int n = 1; n < column; n++) {
            dp[0][n] = grid[0][n] + dp[0][n - 1];
        }
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        // 计算
        for (int m = 1; m < row; m++) {
            for (int n = 1; n < column; n++) {
                dp[m][n] = Math.min(grid[m][n] + dp[m - 1][n], grid[m][n] + dp[m][n - 1]);
            }
        }
        return dp[row - 1][column - 1];
    }
}
