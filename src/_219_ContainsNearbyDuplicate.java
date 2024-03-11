import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-11 8:54:08
 */
public class _219_ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
//        nums = new int[]{1, 0, 1, 1};
        int k = 3;
        boolean b = new _219_ContainsNearbyDuplicate().containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }

    /**
     * 结合hashSet和滑动窗口
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (i > k) {  // set中保存的值已经超过k个了 从头开始去除值
                set.remove(nums[i - k - 1]);
            }

            if (!set.add(num)) {
                return true;
            }

        }
        return false;
    }


    /**
     * hashMap的解法 使用一个map存储值和索引  key是值 value是索引
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();  // 存储值对应的索引 key保存值 value是索引
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
