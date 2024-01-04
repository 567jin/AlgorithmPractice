import jdk.nashorn.internal.objects.NativeNumber;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author jzy
 * @since 2024-01-04 10:09:21
 * 滑动窗口最大值 单调队列的应用
 */
public class _239_MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        nums = new int[]{1, -1};
        k = 2;
        int[] ints = new _239_MaxSlidingWindow().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int ri = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 移除超出窗口范围的元素
            if (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.removeFirst();
            }
            // 维护窗口中的单调队列
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            // 达到一个窗口了 可以开始赋值了
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[queue.peekFirst()];
            }
        }

        return res;
    }
}
