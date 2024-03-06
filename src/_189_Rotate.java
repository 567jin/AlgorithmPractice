import java.util.Arrays;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-06 10:01:01
 */
public class _189_Rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(nums));
        new _189_Rotate().rotate2(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate2(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
        reverse(nums, 0, k % nums.length - 1);
//        System.out.println(Arrays.toString(nums));
        reverse(nums, k % nums.length, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int left, int right) {  // 反转start到end之间的数组元素
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 数组元素的复制  使用一个新的数组记录原数组元素轮转后的位置 最后把新数组整体复制到原数组即可
     */
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        int[] newArr = new int[length];
        for (int i = 0; i < length; i++) {
            newArr[(i + k) % length] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, length);
    }

}
