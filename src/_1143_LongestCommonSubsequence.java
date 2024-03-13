import java.util.Arrays;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-13 14:19:17
 */
public class _1143_LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "ace", text2 = "abcdce";
        int i = new _1143_LongestCommonSubsequence().longestCommonSubsequence(text1, text2);
        System.out.println(i);
    }

    /**
     * 二维动态规划   类似于最长公共子串 但是这里是序列(元素可删除)
     * <p>
     * 这里多加了一行 就不用处理 i-1或者j-1的边界了
     * - - a b c d e
     * - 0 0 0 0 0 0
     * a 0 1 1 1 1 1
     * c 0 1 1 2 2 2
     * e 0 1 1 1 1 3
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);   // 不等的话 为当前行的前一个和上一行之间的最大值
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[m][n];
    }
}
