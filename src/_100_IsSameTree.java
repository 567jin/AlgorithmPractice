import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-02-23 12:53:50
 */
public class _100_IsSameTree {
    public static void main(String[] args) {
        Integer[] p = {1, 2, 3}, q = {1, 2, 3};
        TreeNode node1 = TreeNode.genTree(p);
        TreeNode node2 = TreeNode.genTree(q);
        boolean sameTree = new _100_IsSameTree().isSameTree(node1, node2);
        System.out.println(sameTree);
    }

    /**
     * 深度优先搜索
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    /**
     * 广度优先搜索 两个队列分别记录两个树的节点进行比较
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        // 判空
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left, right1 = node1.right;
            TreeNode left2 = node2.left, right2 = node2.right;
            // 有一个为null 即为false
            if (left1 == null ^ left2 == null) {  // 异或 相等时为false 不等为true  在这里表示同时为空或同时不为空才是false 有一个为空条件才是true 则返回false
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            //都不为null或都为null 加到队列中 进行下一轮比较
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }


}
