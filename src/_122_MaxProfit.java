/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-07 9:13:09
 */
public class _122_MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = new _122_MaxProfit().maxProfit(prices);
        System.out.println(maxProfit);
        int maxProfit2 = new _122_MaxProfit().maxProfit2(prices);
        System.out.println(maxProfit2);
    }

    /**
     * 贪心的解法 局部最优可以推出全局最优 因此可以试试贪心 这里的局部最优表示每两天利益的获得 都是正的 全局最优是局部最优的相加 因此非常适合贪心
     * 这里用到了技巧 要想利益最大化 即把所有上坡算出来即可
     * 由于股票的购买没有限制，因此整个问题等价于寻找 xx 个不相交的区间 区间大小相加即为最大利益
     * <p>
     * 需要说明的是，贪心算法只能用于计算最大利润，计算的过程并不是实际的交易过程。
     * 因为这里会频繁买入卖出 但是实际交易是不允许的
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    /**
     * 动态规划
     * 实现1：二维数组存储
     * 可以将每天持有与否的情况分别用 dp[i][0] 和 dp[i][1] 来进行存储
     * 时间复杂度：O(n)，空间复杂度：O(n)
     * dp[i][0]表示第i天持有股票所得现金
     * dp[i][1]表示第i天不持有股票所得最多现金
     * <p>
     * 递推公式：
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1]-prices[i])  保持现状 或者买入股票 买入股票则利润为前一天持有股票减去当前股票价格
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i]) 保持现状 或者卖出股票 卖出股票的利润是上一天不持有股票加上当前股票价格
     */
    public int maxProfit2(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];  // 第一天持有股票的利润
        dp[0][1] = 0;  // 第一天不持有股票的利润
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

}
