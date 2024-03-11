import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-11 9:40:10
 */
public class _128_LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        nums = new int[]{0, -1};
        int i = new _128_LongestConsecutive().longestConsecutive(nums);
        System.out.println(i);
        int i2 = new _128_LongestConsecutive().longestConsecutive2(nums);
        System.out.println(i2);
        int i3 = new _128_LongestConsecutive().longestConsecutive3(nums);
        System.out.println(i3);
    }

    public int longestConsecutive3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxLen = Integer.MIN_VALUE;
        int n = nums.length;
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                len++;
            } else if (nums[i] == nums[i - 1]) {  // 等于时 直接跳过 不计数 但也不从头计数
            } else {
                maxLen = Math.max(maxLen, len);
                len = 1;
            }
        }
        return Math.max(maxLen, len);
    }

    /**
     * 优化一下解法1的while哈希查找过程
     */
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {  // 判断是否之前已经遍历过
                int len = 0;
                while (set.contains(num++)) {
                    len++;
                }
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }

    /**
     * 超时
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = Integer.MIN_VALUE;
        for (int num : nums) {
            int len = 0;
            while (set.contains(num++)) {
                len++;
            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}
