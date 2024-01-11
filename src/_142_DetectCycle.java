import utils.ListNode;

import java.util.HashSet;

/**
 * @author jzy
 * @since 2024-01-11 14:44:38
 */
public class _142_DetectCycle {
    /**
     * 哈希表的解法
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode cur = head;
        HashSet<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }

        return null;
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

            if (fast == slow) {  // 有环
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

        }
        return null;
    }
}
