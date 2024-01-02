public class _704_DichotomousSearch {

    public static void main(String[] args) {
        System.out.println((new Solution()).search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println((new Solution()).search01(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println((new Solution()).search02(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

}


class Solution {


    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1; // 左闭右闭区间
        if (target < nums[0] || target > nums[right]) {
            return -1;
        }
        // 二分查找的左闭右闭形式
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = --mid;
            } else if (nums[mid] < target) {
                left = ++mid; // 前面已经判定mid不是target了 因此这里左加1 右减1 也就相当于左指针要移动到mid+1
                // 如果仅移动到mid 则会死循环 因为mid始终在left和right之间 那么永远就有left<=right了
            }
        }
        return -1;
    }

    public int search01(int[] nums, int target) {
        int left = 0, right = nums.length; // 左闭右开
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = ++mid;
            else if (nums[mid] > target)
                right = mid;
        }
        return -1;
    }

    // 左闭右开写法
    public int search02(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        if (target < nums[0] || target > nums[right - 1]) {
            return -1;
        }
        while (left < right) { // 因为右边是取不到的 所以判断条件改为 left<right
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid; // 右开 表示取不到
            } else if (nums[mid] < target) {
                left = --mid;
            }
        }
        return -1;
    }
}