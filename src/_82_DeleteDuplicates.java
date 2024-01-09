import utils.ListNode;

/**
 * @author jzy
 * @since 2024-01-09 20:32:41
 */
public class _82_DeleteDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 4, 5};
        nums = new int[]{1, 1, 1, 2, 3};
        ListNode head = ListNode.genList(nums);
        ListNode.printList(head);

        ListNode node = new _82_DeleteDuplicates().deleteDuplicates(head);
        ListNode.printList(node);

        ListNode node2 = new _82_DeleteDuplicates().deleteDuplicates2(head);
        ListNode.printList(node2);
    }

    /**
     * 递归解法
     *
     * @param head 头结点
     * @return 删除后的头结点
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.val != head.next.val) {
            // 如果当前节点和下一个节点的值不相同，不需要删除
            head.next = deleteDuplicates2(head.next);
            return head;
        } else {
            // 如果当前节点和下一个节点的值相同，说明出现了重复的，
            // 把重复的全部给删除。
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates2(head.next);
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummpy = new ListNode(-1);  // 虚拟头结点处理删除头结点的情况
        dummpy.next = head;
        ListNode pre = dummpy;  // 指向上一个不重复的节点
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                    pre.next = cur;  // 删除节点
                }
            } else {
                pre = cur;  // 保存上一个不重复的节点
                cur = cur.next;
            }
        }
        return dummpy.next;
    }
}
