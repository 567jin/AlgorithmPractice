import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jzy
 * @since 2024-01-12 8:55:55
 */
public class _15_ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new _15_ThreeSum().threeSum(nums);
        System.out.println(lists);
    }

    /**
     * 给定一个数组 nums ，返回所有 可以由该数组中数字组成的 0 的个数。
     *
     * @param nums 给定的数组
     * @return 由数组中数字组成的 0 的所有可能组合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {   // 第一个指针大于0了 则后面不可能组合成0了
                return res;
            }
            // a的去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {  // 找到满足目标的子集了 添加进结果集 继续找下一个
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // b和c的去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return res;
    }

}
