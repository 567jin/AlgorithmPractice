import java.util.HashSet;
import java.util.Set;

/**
 * @author jzy
 * @since 2024-01-25 8:46:42
 */
public class _202_IsHappy {
    public static void main(String[] args) {
        int n = 19;
        boolean happy = new _202_IsHappy().isHappy(n);
        System.out.println(happy);

    }

    /**
     * 双指针法
     */
    public boolean isHappy2(int n) {
        int slow = n;  // 起始点
        int fast = getNext(n);  // 下一步
        while (fast != 1 && slow != fast) {
            slow = getNext(slow); // 前进一步
            fast = getNext(getNext(fast));  // 前进两步
        }

        return fast == 1;
    }

    /**
     * 哈希表判断循环  一旦哈希表中有重复值就退出循环 并在最后判断n是否等于1
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {  // 两种情况 n==1是快乐数   set包含之前的数了进入死循环  不会无限制增长
            set.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    private int getNext(int n) {  // 得到下一个数
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
        }
        return sum;
    }
}
