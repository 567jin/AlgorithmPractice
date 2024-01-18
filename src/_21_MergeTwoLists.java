import utils.ListNode;


/**
 * @author jzy
 * @since 2024-01-18 9:31:52
 */
public class _21_MergeTwoLists {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};
        ListNode list1 = ListNode.genList(nums1);
        ListNode list2 = ListNode.genList(nums2);
        ListNode node = new _21_MergeTwoLists().mergeTwoLists(list1, list2);
        ListNode.printList(node);

        list1 = ListNode.genList(nums1);
        list2 = ListNode.genList(nums2);
        ListNode node2 = new _21_MergeTwoLists().mergeTwoLists2(list1, list2);
        ListNode.printList(node2);
    }

    /**
     * 递归写法 递的过程不接链 归的过程接链
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }


    /**
     * 迭代写法
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode dummpy = new ListNode(-1);
        ListNode cur = dummpy;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur.next = cur1 == null ? cur2 : cur1;
        return dummpy.next;
    }
}
