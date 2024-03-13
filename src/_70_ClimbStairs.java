/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-13 9:43:40
 */
public class _70_ClimbStairs {
    public static void main(String[] args) {
        int n = 3;
        int i = new _70_ClimbStairs().climbStairs(n);
        System.out.println(i);

        int i2 = new _70_ClimbStairs().climbStairs2(n);
        System.out.println(i2);
    }

    /**
     * 一维动态规划
     * 1 2 3 4 5 6 7 8 9 10
     * 1 2 3
     * dp[i] = dp[i-1]+dp[i-2]
     * dp[0]=1
     * dp[1]=1
     * dp[2]=2
     * dp[3]=3
     * dp[4]=5
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 从上面的递推公式可以看出 当前值只与前两个值有关 因此可以用两个变量保存这两个值
     */
    public int climbStairs2(int n) {
        int p = 0;
        int q = 1;
        int ans = p + q;
        for (int i = 1; i <= n; i++) {
            ans = p + q;
            p = q;
            q = ans;
        }
        return ans;
    }


}
