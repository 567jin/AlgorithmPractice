import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jzy
 * @since 2024-01-11 15:53:54
 */
public class _101_IsSymmetric {
    public static void main(String[] args) {
        Integer[] nodes = {1, 2, 2, 3, 4, 4, 3};
//        nodes = new Integer[]{1, 2, 2, null, 3, null, 3};
        nodes = new Integer[]{1, 2, 3};
        TreeNode root = TreeNode.genTree(nodes);
        boolean symmetric = new _101_IsSymmetric().isSymmetric(root);
        System.out.println(symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {  // 同时为null
            return true;
        }

        if (left == null || right == null) {  // 一个为null
            return false;
        }

        if (left.val != right.val) {  // 都不为null 可以和下面的语句直接合在一起
            return false;
        }

        return /*left.val == right.val && */ dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    /**
     * 迭代写法 队列实现
     */
    private boolean check(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();

            if (left == null && right == null) {  // 两者同时为null 跳过 比较下一个节点
                continue;
            }

            if (left == null || right == null || left.val != right.val) {  // 有一个为null 或者都不为null但值不等为false
                return false;
            }
            // 添加元素很有讲究 成对添加 相邻的两个节点是要比较的节点
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }

    /**
     * 迭代写法 栈的实现
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            // 重点是下面压入栈的次序 压栈的顺序必须是未来弹栈要比较的两个节点
            stack.push(left.left);
            stack.push(right.right);

            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }


}
