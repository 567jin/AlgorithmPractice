import utils.ListNode;

import java.util.List;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-04-22 20:16:32
 */
public class _86_Partition {
    public static void main(String[] args) {
        int[] nodes = {1, 4, 3, 2, 5, 2};
        ListNode head = ListNode.genList(nodes);
        ListNode.printList(head);
        int x = 3;
        ListNode partition = new _86_Partition().partition(head, x);
        ListNode.printList(partition);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode small = smallHead, big = bigHead;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;  // 砍断big节点与原链表的联系  防止成环  big节点是原链表的节点，如果不砍断他后面的连接 在连接新链表之后 会成环
        small.next = bigHead.next;
        return smallHead.next;
    }
}
