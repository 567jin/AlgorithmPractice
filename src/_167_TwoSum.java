import java.util.Arrays;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-02-06 13:46:32
 */
public class _167_TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ints = new _167_TwoSum().twoSum(numbers, target);
        System.out.println(Arrays.toString(ints));

        int[] ints2 = new _167_TwoSum().twoSum2(numbers, target);
        System.out.println(Arrays.toString(ints2));
    }

    /**
     * 二分查找
     */
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;  // 题目要求不能使用相同的数 因此 left从i+1开始
            int sub = target - numbers[i];
            while (left <= right) {  // 对每一个数 都利用二分查找 看是否存在与之对应的另一个数满足相加等于target
                int mid = (right - left) / 2 + left;
                if (numbers[mid] == sub) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > sub) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }


        return new int[]{-1, -1};

    }

    /**
     * 双指针
     */
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length - 1;
        int left = 0;
        while (left < right) {
            int add = numbers[left] + numbers[right];
            if (add > target) {
                right--;
            } else if (add < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};  // 按照题目的意思 是一定存在正确且唯一的答案的 所以不会执行到这里
    }
}
