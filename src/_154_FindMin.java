/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-04-08 15:10:06
 */
public class _154_FindMin {
    public static void main(String[] args) {
        System.out.println(new _154_FindMin().findMin(new int[]{3, 4, 5, 1, 2}));
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] < nums[right]) { // 中间值小于右边最大值 左边
                right = mid;
            } else if (nums[mid] > nums[right]) { // 在右边
                left = mid + 1;
            } else { // 相等 到达平台了 right--即可
                right--;
            }
        }
        return nums[left];
    }
}
