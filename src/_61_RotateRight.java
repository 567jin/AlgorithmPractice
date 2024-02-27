import utils.ListNode;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-02-27 9:08:49
 */
public class _61_RotateRight {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.genList(nums);
        ListNode.printList(head);
        ListNode node = new _61_RotateRight().rotateRight(head, 2);
        ListNode.printList(node);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int num = 0;
        ListNode tail = null;  // 右半段链表的尾部
        while (cur != null) {
            tail = cur;
            cur = cur.next;
            num++;
        }
        k = k % num;
        if (k == 0) {
            return head;
        }
        int move = num - k;
        cur = head;
        while (--move > 0) {
            cur = cur.next;
        }
        System.out.println(cur.val);
        ListNode right = cur.next;
        cur.next = null;
        tail.next = head;
        return right;
    }
}
