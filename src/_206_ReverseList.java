import utils.ListNode;

/**
 * @author jzy
 * @since 2024-01-05 11:15:16
 */
public class _206_ReverseList {
    public static void main(String[] args) {
        ListNode head = ListNode.genList(new int[]{1, 2, 3, 4, 5});
        ListNode.printList(head);

//        ListNode node = new _206_ReverseList().reverseList(head);
        ListNode node = new _206_ReverseList().reverseList2(head, null);
        ListNode.printList(node);

    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head, ListNode pre) {
        if (head == null) {
            return pre;
        }
        ListNode cur = head;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverseList2(temp, cur);
    }

}
