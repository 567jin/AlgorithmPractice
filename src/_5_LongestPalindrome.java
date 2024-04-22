import org.junit.Test;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-13 10:09:26
 */
public class _5_LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        s = "cbbd";

        String s1 = new _5_LongestPalindrome().longestPalindrome3(s);
        System.out.println(s1);
    }

    String ans = "";

    public String longestPalindrome3(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        for (int i = 0; i < n; i++) {
            expandAroundCenter(s, i, i);  // 扩散一个 奇数情况 A(B)A
            expandAroundCenter(s, i, i + 1);  // 扩散两个 偶数的情况 A(BB)A
        }
        return ans;
    }

    /**
     * 中心扩散法
     */
    public void expandAroundCenter(String s, int left, int right) {
        // 在区间[left,right]不断地像两边移动 直到达到最长回文子串
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        if (right - left - 1 > ans.length()) {
            ans = s.substring(left + 1, right);
        }
    }


    /**
     * 中心扩散结合动态规划
     * 注意到 如果是回文子串则去掉两端字符后仍然是回文子串 即[i,j]是否是回文串可以由 [i+1,j-1]推导出来 因此可以得到一个状态转移方程
     * dp[i][j]区间内的字符串是否是回文串有三种情况：
     * i==j 则 肯定为回文串 区间内只有1个字符
     * j-i<=2 即2或3 则需要判断s[i]==s[j]
     * j-i>2时 则需要判断d[i+1][j-1]的情况并且s[i]==[j]则能是回文串
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        String ans = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {   // 倒着遍历是为了在计算dp[i][j]时 dp[i+1][j-1]的结果已经计算出来了
            dp[i][i] = true;  // 在这里初始化也一样 反正就是 区间内只有一个字符设置为 true
            for (int j = i; j < n; j++) {
                boolean b = s.charAt(i) == s.charAt(j);
                // 根据递推公式写代码
                /*if (i == j) {
                    dp[i][j] = true;
                } else */
                if (j - i <= 2) {
                    dp[i][j] = b;
                } else {
                    dp[i][j] = (dp[i + 1][j - 1]) && b;
                }
                if (dp[i][j] && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }

            }
        }

        return ans;
    }


    /**
     * 暴力解法  朴素字符串匹配 不断地以s各个位置的下标为起始点 查找最长回文子串
     */
    public String longestPalindrome1(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j - i + 1 > res.length() && isPalindrome(s, i, j)) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * 我是想转换成 两个序列的最长子序列
     * 一个序列是原序列 另一个序列是原序列的倒序 但是不知道为啥不行(力扣就剩十几个用例过不了) 比如s = "aacabdkacaa"
     */
    public String longestPalindrome0(String s) {
        return "";
    }

}
