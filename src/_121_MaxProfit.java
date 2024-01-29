/**
 * @author jzy
 * @since 2024-01-29 8:52:21
 */
public class _121_MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = new _121_MaxProfit().maxProfit(prices);
        System.out.println(i);

        int j = new _121_MaxProfit().maxProfit2(prices);
        System.out.println(j);
    }

    /**
     * 暴力法过不了 会超时
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] > prices[i + 1]) {
                continue;
            }
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > res) {
                    res = prices[j] - prices[i];
                }
            }
        }

        return res == Integer.MIN_VALUE ? 0 : res;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int minPrice = prices[0];  // 记录历史最低价格
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= minPrice) {
                minPrice = prices[i];
            } else {
                int maxProfit = prices[i] - minPrice;
                if (maxProfit > res) {
                    res = maxProfit;
                }
            }
        }

        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
