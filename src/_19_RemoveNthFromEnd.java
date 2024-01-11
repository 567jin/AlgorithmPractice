import utils.ListNode;

import java.util.Stack;

/**
 * @author jzy
 * @since 2024-01-11 15:02:04
 */
public class _19_RemoveNthFromEnd {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.genList(nums);
        ListNode.printList(head);
        ListNode node = new _19_RemoveNthFromEnd().removeNthFromEnd(head, 2);
        ListNode.printList(node);
        System.out.println("------------------");

        head = ListNode.genList(nums);
        ListNode.printList(head);
        ListNode node2 = new _19_RemoveNthFromEnd().removeNthFromEnd2(head, 2);
        ListNode.printList(node2);

        System.out.println("------------------");
        head = ListNode.genList(nums);
        ListNode.printList(head);
        ListNode node3 = new _19_RemoveNthFromEnd().removeNthFromEnd3(head, 2);
        ListNode.printList(node3);

    }

    /**
     * 双指针解法，快慢指针找到要删除节点 不要忘了处理头结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode fast = dummpy;
        ListNode slow = dummpy;
        while (n-- > 0) {
            fast = fast.next;
        }
        // 定位要删除的节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除节点
        slow.next = slow.next.next;
        return dummpy.next;
    }

    /**
     * 栈的方法 遍历链表依次入栈 第N个弹出栈的节点就是要删除的节点 N+1个就是它的前一个前节点
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode cur = dummpy;
        while (cur != null) { // 入栈
            stack.push(cur);
            cur = cur.next;
        }

        while (n-- >= 0) { // 弹栈 弹N+1次
            cur = stack.pop();
        }
        cur.next = cur.next.next;

        return dummpy.next;
    }

    /**
     * 统计长度的方法
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode cur = dummpy;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        
        count = count - n - 1;  // 计算正数多少个节点 找到待删除节点的前驱结点
        cur = dummpy;
        // 定位节点
        while (count-- > 0) {
            cur = cur.next;
        }
        // 删除节点
        cur.next = cur.next.next;
        return dummpy.next;
    }

}
