import java.util.Arrays;

/**
 * @author jzy
 * @since 2024-01-26 9:39:07
 */
public class _80_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int i = new _80_RemoveDuplicates().removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, i)));


        nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int j = new _80_RemoveDuplicates().removeDuplicates2(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, j)));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums == null ? 0 : nums.length;
        }

        int slow = 2, fast = 2;  // 直接从第三个开始比较
        while (fast < nums.length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    /**
     * 采用计数标记的方式  或其他使用哈希表的方式
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums == null ? 0 : nums.length;
        }
        int idx = 1;
        boolean allowDuplicates = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (allowDuplicates) {
                    nums[idx++] = nums[i];
                    allowDuplicates = false; // 只在允许重复的情况下更新标记
                }
            } else {
                nums[idx++] = nums[i];
                allowDuplicates = true; // 重置为允许重复，因为遇到新数字了
            }
        }

        return idx;
    }

}
