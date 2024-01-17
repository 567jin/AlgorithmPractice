import java.util.Arrays;

/**
 * @author jzy
 * @since 2024-01-17 21:12:05
 */
public class _238_ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ans = new _238_ProductExceptSelf().productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 很巧的方法 先计算左边所有值相乘的结果 再计算右边所有值相乘的结果
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] ans = new int[nums.length];
        ans[0] = 1;
        // 算左边的乘积
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int right = 1;
        // 算右边的乘积
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }
        return ans;
    }
}
