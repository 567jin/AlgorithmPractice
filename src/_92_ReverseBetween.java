import utils.ListNode;


/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-11 14:43:20
 */
public class _92_ReverseBetween {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5};
        int left = 2;
        int right = 4;
        ListNode head = ListNode.genList(nodes);
        ListNode.printList(head);
        System.out.println("---------------------------");
        ListNode node = new _92_ReverseBetween().reverseBetween2(head, left, right);
        ListNode.printList(node);
    }

    /**
     * 断链 接链的解法   找到中间要反转的链表 断开反转之后 再接回去
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);  // 虚拟头结点
        dummy.next = head;
        ListNode cur = dummy;
        int diff = right - left;
        while (--left > 0) {
            cur = cur.next;
        }
        ListNode leftTail = cur;
        ListNode newHead = cur.next;  // 子链的头结点
        cur.next = null;  // 断链
        cur = newHead;
        while (diff-- > 0) {
            cur = cur.next;
        }
        ListNode rightHead = cur.next;  // 子链尾节点的后面的链
        cur.next = null;
        ListNode node = reverseList(newHead);  // 反转子链
        leftTail.next = node;  // 接链
        newHead.next = rightHead;
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 一次遍历「穿针引线」反转链表（头插法）
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy; // pre 指向反转区域的前一个节点
        int diff = right - left;

        // 将pre指向反转区域的前一个节点
        while (--left > 0) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        ListNode prev = null; // 记录反转区域的前一个节点

        while (diff-- >= 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // 连接反转后的子链和原链表  cur指向尾节点   pre为1->2   cur=5   prev 4->3->2->null
        pre.next.next = cur;
        pre.next = prev;

        return dummy.next;
    }

    public ListNode reverseBetween3(ListNode head, int left, int right) {  // 头插法
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        int num = right - left;
        while (left-- > 1) {  // 反转区域的前一个节点
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode curNext;

        while (num-- > 0) {  // 头插num次  即把cur的next节点 插到cur的前面
            curNext = cur.next;
            cur.next = curNext.next;
            curNext.next = pre.next;
            pre.next = curNext;
        }

        return dummy.next;
    }
}
