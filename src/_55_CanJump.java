/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-08 9:10:01
 */
public class _55_CanJump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        nums = new int[]{3, 2, 1, 0, 4};
        nums = new int[]{0, 1};
        boolean canJump = new _55_CanJump().canJump(nums);
        System.out.println(canJump);
    }

    /**
     * 数组下标表示 最远能达到的距离  遍历所有的点 当最远距离可以越过n-1时 说明n-1可达
     * 如果i都大于rightMost了 说明rightMost很久不更新了 n-1也就不可达了
     */
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 如果i大于最远距离了 直接退出返回false
     * 反之rightMost可以一直到达n-1
     */
    public boolean canJump2(int[] nums) {
        int rightMost = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > rightMost) {
                return false;
            }
            rightMost = Math.max(rightMost, i + nums[i]);
        }

        return true;
    }

}
