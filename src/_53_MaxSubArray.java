import java.util.Arrays;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-07 18:45:50
 */
public class _53_MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        nums = new int[]{5, 4, -1, 7, 8};
        int maxSubArray = new _53_MaxSubArray().maxSubArray(nums);
        System.out.println(maxSubArray);

        int maxSubArray2 = new _53_MaxSubArray().maxSubArray2(nums);
        System.out.println(maxSubArray2);
    }

    /**
     * 动态规划  dp[i]表示 以数组第i个结尾的连续数组最大和
     * dp[i] = max(dp[i-1]+nums[i],nums[i])
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        Arrays.sort(dp);
        return dp[n - 1];
    }

    // 优化空间 可以看到 只有最大值有用 因此不需要记录每一个  以当前点结尾的连续子数组和最大值是pre 然后不断地记录maxSum即可 其实就相当于在dp过程中记录最大值
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int maxSum = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }
}
