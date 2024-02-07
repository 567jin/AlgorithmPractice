import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-02-07 13:18:25
 */
public class _228_SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
//        nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        List<String> strings = new _228_SummaryRanges().summaryRanges(nums);
        System.out.println(strings);
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i;  // 区间左边端点
            // 分组循环 即每个点 使用while循环找对应的右端点
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {  // 找区间右边端点
                i++;
            }

            int right = i;
            if (left < right) {  // 即左右端点存在的情况 说明找到了左右两个区间
                res.add(nums[left] + "->" + nums[right]);
            } else {
                res.add(String.valueOf(nums[left]));  // 没有找到区间 单独一个数就是一个区间
            }
        }

        return res;
    }
}
