import utils.ListNode;

/**
 * @author jzy
 * @since 2024-01-11 14:10:29
 */
public class _2_AddTwoNumbers {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};
        nums1 = new int[]{9, 9, 9, 9, 9, 9, 9};
        nums2 = new int[]{9, 9, 9, 9};

        ListNode l1 = ListNode.genList(nums1);
        ListNode l2 = ListNode.genList(nums2);
        ListNode node = new _2_AddTwoNumbers().addTwoNumbers(l1, l2);

        ListNode.printList(l1);
        ListNode.printList(l2);
        ListNode.printList(node);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummpy = new ListNode(-1);  // 虚拟头结点
        ListNode cur = dummpy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;  // 记录进位

        while (cur1 != null || cur2 != null) {
            int add = (cur1 != null ? cur1.val : 0) + (cur2 != null ? cur2.val : 0) + carry;
            carry = add > 9 ? 1 : 0;
            add = add > 9 ? (add - 10) : add;  // add>9 需要进位
            ListNode newNode = new ListNode(add);

            cur.next = newNode;
            cur = cur.next;
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
        }
        if (carry != 0) {  // 处理最后一个进位
            cur.next = new ListNode(1);
        }

        return dummpy.next;
    }
}
