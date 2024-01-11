/**
 * @author jzy
 * @since 2024-01-11 11:15:48
 */
public class _136_SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int number = new _136_SingleNumber().singleNumber(nums);
        System.out.println(number);
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
