/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-07 11:00:59
 */
public class _392_IsSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        boolean subsequence = new _392_IsSubsequence().isSubsequence(s, t);
        System.out.println(subsequence);
    }

    /**
     * 贪心的思想 从前往后一个一个遍历着匹配时最优解
     * 使用双指针去匹配
     */
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j++)) {
                i++;
            }
        }
        return i == m;
    }

    /**
     * 贪心匹配的话 只能用于一对字符串 即如果又有了新的字符串s 则又需要从头开始匹配
     * 可以先对t进行预处理 记录一下它的字符出现的位置 这样即使s是字符串流 也可以不断地匹配了
     * 定义一个二维数组dp[i][j] 表示字符串t中第i个位置的字符 从i开始往后字符j第一次出现的位置
     * <p>
     * 对于abc这个字符串t dp是
     * 0  1  2  3  3  3...
     * 0  1  3  3  3  3...
     * 0  3  3  3  3  3...
     * 3  3  3  3  3  3...
     * <p>
     * s是ac 则
     */
    public boolean isSubsequence2(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[n + 1][26];
        // 终止条件
        for (int i = 0; i < 26; i++) {
            dp[n][i] = n;  // 表示 到最后边界了 即没匹配上
        }
        // 计算dp
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    dp[i][j] = i;  // 当前字符就是j 则当前字符第一次出现的位置 就是i  否则就是上一个的结果即dp[i+1][j]
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        // 利用dp 匹配字符串
        int add = 0;
        for (int i = 0; i < m; i++) {
            if (dp[add][s.charAt(i) - 'a'] == n) {  // 到达t的边界了也没匹配到
                return false;
            }
            add = dp[add][s.charAt(i) - 'a'] + 1;
        }

        return true;
    }


}
