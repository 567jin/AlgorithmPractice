import utils.ListNode;

import java.util.List;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-27 9:27:47
 */
public class _25_ReverseKGroup {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.genList(nums);
        int k = 2;
        ListNode.printList(head);
//        ListNode listNode = new _25_ReverseKGroup().reverseKGroup(head, k);
//        ListNode.printList(listNode);

        ListNode listNode2 = new _25_ReverseKGroup().reverseKGroup2(head, k);
        ListNode.printList(listNode2);

    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;  // 反转区域的前驱
        ListNode end = dummy;  // 反转区域的末尾节点

        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) {
                    return dummy.next;
                }
            }

            ListNode start = pre.next;  // 反转区域的第一个节点
            ListNode next = end.next;  // 记录后继
            // 断链
            end.next = null;
            pre.next = reverse(start);

            // 接链  原来的start变成end了
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        // 每k个一组断链 反转后再接链
        while (head != null) {
            ListNode tail = pre;  // 记录链表反转区域的尾部
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {  // 不够k个了 不用反转了
                    return dummy.next;
                }
            }

            // 断链
            ListNode next = tail.next;  // 记录反转区域尾部的后面的链表
            ListNode[] reverse = reverseList(head, tail);
            head = reverse[0];
            tail = reverse[1];

            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }

        return dummy.next;
    }

    private ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }
}
