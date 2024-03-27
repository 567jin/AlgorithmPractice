import org.omg.CORBA.RepositoryIdHelper;

import java.util.HashSet;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-26 18:20:16
 */
public class _287_FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = new _287_FindDuplicate().findDuplicate(nums);
        System.out.println(duplicate);


        int duplicate2 = new _287_FindDuplicate().findDuplicate2(nums);
        System.out.println(duplicate2);

        int duplicate3 = new _287_FindDuplicate().findDuplicate3(nums);
        System.out.println(duplicate3);
    }

    /**
     * 按照快慢指针找链表回环的操作 找出那个重复数 但是数组的环不是我想的那样直接成环
     * 而是有索引下标指向数组的值 即如 1 3 4 2 2的数组 变成链表是
     * 0->1-> 3-> 2-> 4-> 2->4...(这里就成环了 )
     */
    public int findDuplicate3(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];  // 走一步
        fast = nums[nums[fast]];  // 走两步
        while (slow != fast) {
            slow = nums[slow];  // 走一步
            fast = nums[nums[fast]];  // 走两步
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];  // 走一步
            fast = nums[fast];  // 走一步
        }
        return slow;
    }

    /**
     * 抽屉原理
     * 即一个抽屉只能放一个数 二分查找，以mid作为抽屉编号，看数组中的数是否小于该抽屉编号，如果小于
     */
    public int findDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) >> 1 + left;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count <= mid) {  // 小于抽屉编号的数量与抽屉号相同 因此重复数在右边区间
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;
    }

    /**
     * 哈希的做法
     * O(n)的空间复杂度
     * O(n)的时间复杂度
     */
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }
}
