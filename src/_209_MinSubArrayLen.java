import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jzy
 * @since 2024-01-24 9:46:19
 */
public class _209_MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 11;
        int i = new _209_MinSubArrayLen().minSubArrayLen(target, nums);
        System.out.println(i);
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;  // 窗口左边界
        int sum = 0;   // 记录窗口内的和

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                res = Math.min(res, right - left + 1);  // 更新最小长度
                sum -= nums[left];  // 移动左边界
                left++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * 这个是求队列中的值等于target的情况
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();  // 窗口
        int add = 0;  // 记录窗口内的和
        for (int num : nums) {
            if (add == target) {
                if (res > queue.size()) {
                    res = queue.size();
                    add -= queue.poll();  // 寻找下一个
                }
            }
            queue.add(num);
            add += num;
            while (add > target) {
                if (!queue.isEmpty()) {  // 踢出队列
                    add -= queue.poll();
                }
            }
        }

        // 最后处理一下窗口内的值 为2 4 3
        while (add >= target) {
            if (add == target) {
                if (res > queue.size()) {
                    res = queue.size();
                }
            }
            add -= queue.poll();
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
