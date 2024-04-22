import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-04-10 19:46:57
 */
public class _00_YueSeFu {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 有N个小孩围成一圈，从1-3开始报数 报到3的出列 编码实现小孩出列顺序
        List<Integer> circle = getChildrenOutOfCircle(3, 3);
        System.out.println(circle);

        List<Integer> circle2 = getChildrenOutOfCircle2(3);
        System.out.println(circle2);

        List<Integer> circle3 = getChildrenOutOfCircle3(3, 3);
        System.out.println(circle3);
    }

    // N 表示有多少人 M表示报数
    public static List<Integer> getChildrenOutOfCircle(int n, int m) {
        List<Integer> children = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            children.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (!children.isEmpty()) {
            // 淘汰后 从其后面那一位开始数
            index = (index + m - 1) % children.size();  // 索引从零开始 因此这里是加m-1 而不是加m
//            result.add(children.get(index));
            result.add(children.remove(index));
//            children.remove(index);
        }

        return result;
    }

    public static List<Integer> getChildrenOutOfCircle2(int n) {
        List<Integer> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i <= n; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        current.next = head; // 构建循环链表

        while (current.next != current) {
            for (int i = 1; i < 3; i++) {
                current = current.next;
            }
            result.add(current.next.val);
            current.next = current.next.next;
        }
        result.add(current.val);

        return result;
    }

    /**
     * 圈中原来有n个孩子，按顺时针方向站成一个圈。现在从某个孩子开始报数，每次报数报到m的孩子出圈，
     * 然后从下一个孩子继续报数，直到最后只剩下一个人为止。
     */
    public static List<Integer> getChildrenOutOfCircle3(int n, int m) {
        List<Integer> result = new ArrayList<>();
        int lastChild = 0; // 记录每次报数后最后剩下的孩子的位置。

        // 计算最后剩下的孩子的位置。
        for (int i = 2; i <= n; i++) {
            lastChild = (lastChild + m) % i;
        }

        // 根据最后剩下的孩子的位置，推算所有剩下的孩子的站位顺序。
        for (int i = 1; i <= n; i++) {
            result.add((lastChild + i) % n);
        }
        return result;
    }
}
