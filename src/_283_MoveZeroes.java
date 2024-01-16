import java.util.Arrays;

/**
 * @author jzy
 * @since 2024-01-16 8:55:11
 */
public class _283_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
//        nums = new int[]{0, 1};
        System.out.println(Arrays.toString(nums));
        new _283_MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println("----------------------");
        nums = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        new _283_MoveZeroes().moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * 采用的是双指针 先移动非零值到前面 然后记录有几个非零值 最后在数组后面补上0(有点作弊 因为不是真的移动零了)
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int fast = 0;
        int slow = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        // 后面补零
        int size = fast - slow;
        while (size-- > 0) {
            nums[--fast] = 0;
        }
    }

    /**
     * 移动零 (交换)
     *
     * @param nums 待移动零的数组
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                // 如果当前元素非零，将其与第一个零交换位置
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
    }


    /**
     * 传入数组的两个索引值 交换其位置
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
