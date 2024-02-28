import java.util.Arrays;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-02-28 20:06:23
 */
public class _62_UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        int i = new _62_UniquePaths().uniquePaths(m, n);
        System.out.println(i);
        int j = new _62_UniquePaths().uniquePaths2(m, n);
        System.out.println(j);
    }

    /**
     * 降维
     */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int row = 1; row < m; row++) {
            dp[0] = 1;  // 第一个数 代表第一列的值 永远为1
            for (int column = 1; column < n; column++) {
                dp[column] = dp[column] + dp[column - 1];  // 自身加上左边的值
            }
        }
        return dp[n - 1];
    }


    /**
     * f[i][j] = f[i - 1][j] + f[i][j - 1]
     * f[0][j]=1
     * f[i][0]=1
     * 三行两列的结果:
     * 1  1  1  1  1  1  1
     * 1  2  3  4  5  6  7
     * 1  3  6  10 15 21 28
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        Arrays.fill(dp[0], 1);

        for (int row = 1; row < m; row++) {
            for (int column = 1; column < n; column++) {
                dp[row][column] = dp[row - 1][column] + dp[row][column - 1];  // 递推公式
            }
        }
        return dp[m - 1][n - 1];
    }
}
