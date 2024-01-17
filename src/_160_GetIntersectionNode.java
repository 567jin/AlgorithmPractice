import utils.ListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author jzy
 * @since 2024-01-17 15:37:32
 */
public class _160_GetIntersectionNode {
    public static void main(String[] args) {

    }

    /**
     * 哈希表的解法
     */
    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            set.add(curA);
            curA = curA.next;
        }
        while (curB != null) {
            if (set.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }


    /**
     * 双指针 借助推理 比较难想到 短的到末尾后 移动到长的头部 长的到末尾后移动到短的头部 然后再相遇就是交叉节点
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;

    }

    /**
     * 栈的方法 找到最后一个弹栈并且相等的节点 就是相交节点 如果栈顶节点不相等则说明不相交(即末尾都不相交)
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) { // 压A入栈
            stackA.push(curA);
            curA = curA.next;
        }
        while (curB != null) { // 压A入栈
            stackB.push(curB);
            curB = curB.next;
        }
        // 弹栈比较
        if (stackA.peek() != stackB.peek()) {  // 顶部都不相等说明没有相交点
            return null;
        }
        // 尾部相等说明有相交点 第一个不相等节点的前一个节点就是相交点
        ListNode pre = stackA.peek();
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            curA = stackA.pop();
            curB = stackB.pop();
            if (curA != curB) {
                break;
            }
            pre = curA;
        }

        return pre;
    }


    /**
     * 对齐长度后进行比较
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sub = getSize(headA) - getSize(headB);  // 得到链表长度的差值
        if (sub == 0) {  // 相等
            return getNode(headA, headB, 0);
        } else if (sub < 0) {  // B较长 但是函数是以A长为基础的 所以交换二者的位置
            return getNode(headB, headA, -sub);
        } else {
            return getNode(headA, headB, sub);
        }
    }

    private ListNode getNode(ListNode headA, ListNode headB, int sub) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (sub-- > 0) {
            curA = curA.next;
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    /**
     * 获得链表长度
     */
    public static int getSize(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
}
