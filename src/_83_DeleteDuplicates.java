import utils.ListNode;

/**
 * @author jzy
 * @since 2024-01-10 9:01:59
 */
public class _83_DeleteDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2,};
        ListNode head = ListNode.genList(nums);
        ListNode.printList(head);
        ListNode node = new _83_DeleteDuplicates().deleteDuplicates(head);
        ListNode.printList(node);

        head = ListNode.genList(nums);
        ListNode.printList(head);
        ListNode node2 = new _83_DeleteDuplicates().deleteDuplicates2(head);
        ListNode.printList(node2);

    }

    /**
     * 递归写法
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDuplicates2(head.next);  // 不删除节点
            return head;
        } else {
            // 删除重复节点
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates2(head);
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummpy.next;
    }
}
