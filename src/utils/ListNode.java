package utils;

/**
 * @author jzy
 * @since 2024-01-05 11:15:54
 */
public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode genList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode newNode = new ListNode(nums[i]);
            cur.next = newNode;
            cur = cur.next;
        }

        return head;
    }

    /**
     * 打印链表
     *
     * @param head 链表头结点
     */
    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.getVal() + ", ");
            cur = cur.next;
        }
        System.out.println();

    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
