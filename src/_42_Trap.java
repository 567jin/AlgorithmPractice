import com.sun.xml.internal.messaging.saaj.util.transform.EfficientStreamingTransformer;

import java.awt.*;
import java.awt.font.NumericShaper;
import java.util.Stack;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-27 10:20:41
 */
public class _42_Trap {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = new _42_Trap().trap(height);
        System.out.println(trap);

        int trap2 = new _42_Trap().trap2(height);
        System.out.println(trap2);

        int trap3 = new _42_Trap().trap3(height);
        System.out.println(trap3);
    }

    /**
     * 动态规划  两个数组分别记录其左边的最大值和右边的最大值
     * 一般的做法是 找到height[i]左右两边的最大值 然后雨水总量就是两边最大高度的最小值
     * <p>
     * 找两个数组记录左右两边的最大值 即用空间换时间
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];  // 记录当前点左边的最大值
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];  // 记录当前点右边的最大值
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }

    /**
     * 单调栈 其实也是用空间换时间的做法 栈中记录的是柱子高度单调递减的下标
     */
    public int trap2(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

// 栈中至少要存两个值才能计算雨水 一个是当前柱子的前一个 前一个的前一个 要计算的就是前一个柱子能接水的量(其左右两边的柱子都大于它)
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer pop = stack.pop();
                if (stack.isEmpty()) {  // 当前柱子的前一个柱子的左边没有柱子 没法接水
                    break;
                }
                Integer left = stack.peek();
                int curHeight = Math.min(height[i], height[left]) - height[pop];
                int width = i - stack.peek() - 1;
                ans += width * curHeight;
            }
            stack.push(i);
        }

        return ans;
    }

    /**
     * 双指针 其实就是解法一中 动态规划的降维写法
     */
    public int trap3(int[] height) {
        int n = height.length;
        int ans = 0;
        int left = 0;
        int right = n - 1;
        int leftMax = 0, rightMax = 0;  // 记录左右两边柱子的最大值
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];  // 计算左边的接雨水的量
                ++left;
            } else {
                ans += rightMax - height[right]; // 计算右边接雨水的量
                --right;
            }
        }

        return ans;
    }

}
