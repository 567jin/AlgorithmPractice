import utils.ListNode;

import java.util.HashSet;

/**
 * @author jzy
 * @since 2024-01-11 14:29:20
 */
public class _141_HasCycle {
    public static void main(String[] args) {

    }

    /**
     * 哈希表的解法  遍历所有节点 有相等的则说明有环
     */
    public boolean hasCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
            cur = cur.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && slow != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
