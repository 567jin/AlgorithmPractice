/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-01-30 10:31:12
 */
public class _35_SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int i = new _35_SearchInsert().searchInsert(nums, target);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
