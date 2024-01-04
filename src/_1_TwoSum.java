import javax.swing.text.html.HTML;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jzy
 * @since 2024-01-04 9:52:28
 * 两数之和
 */
public class _1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = new _1_TwoSum().twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return res;

    }
}
