/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-08 10:27:57
 */
public class _11_MaxArea {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = new _11_MaxArea().maxArea(height);
        System.out.println(i);
    }

    /**
     * 题目做法简单 就是左右指针为边界  不断地移动最小指针值  但是难点在于证明这个问题 即为什么这样做可以计算出最大容量
     * 可以简单的想一想 最大值的指针 定义了 容量的最大值 而最小值定义了容量实际值  因此不断地移动最小指针可以更新容量值
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
