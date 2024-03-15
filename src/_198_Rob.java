/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-14 10:39:04
 */
public class _198_Rob {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int rob = new _198_Rob().rob(nums);
        System.out.println(rob);
        int rob2 = new _198_Rob().rob2(nums);
        System.out.println(rob2);
    }

    /**
     * dp[i]的定义是从i个房子中 偷盗的最大金额
     * dp[i] = max(dp[i-1], dp[i-2])+nums[i] 推导错误  分析是正确的就是连续的两间房子选一个 但是没有将公式推导明白
     * 正确的公式是 dp[i]=max(dp[i-1](偷了i-1家那么第i家就不能偷了),dp[i-2]+nums[i-1](偷前i-2间加上当前这个房子的钱，注意nums中的i从0开始 dp中的i从1开始))   dp[0]=0表示第0家   dp[1]表示偷盗第一家
     * <p>
     * 每次只能选择两个房屋中的一个进行偷盗
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 0;  // i为0 表示没有房子 初始化为0
        dp[1] = nums[0];  // i为1 只有一间房子 只能偷这一间
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);  // 要么偷当前的(上一件没偷过dp[i-2]) 要么不偷(上一间偷过了dp[i-1])
        }
        return dp[n];
    }

    /**
     * 空间优化
     */
    public int rob2(int[] nums) {
        int maxMoney = 0;  // dp[i-1]
        int prev = 0;  // dp[i-2]
        for (int num : nums) {
            int temp = maxMoney;  // dp[i-2]的结果
            maxMoney = Math.max(prev + num, maxMoney);
            prev = temp;
        }
        return maxMoney;
    }

}
