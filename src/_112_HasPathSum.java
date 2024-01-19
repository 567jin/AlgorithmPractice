import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jzy
 * @since 2024-01-19 10:13:25
 */
public class _112_HasPathSum {
    public static void main(String[] args) {
        Integer[] nodes = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode root = TreeNode.genTree(nodes);
        TreeNode.printTree(root);
        int targetNum = 22;
        boolean a = new _112_HasPathSum().hasPathSum(root, targetNum);
        System.out.println(a);
        boolean b = new _112_HasPathSum().hasPathSum2(root, targetNum);
        System.out.println(b);
        boolean c = new _112_HasPathSum().hasPathSum3(root, targetNum);
        System.out.println(c);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * 广度优先搜索 层序遍历
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueVal = new LinkedList<Integer>();
        queueNode.offer(root);
        queueVal.offer(root.val);
        while (!queueNode.isEmpty()) {
            int size = queueNode.size();
            while (size-- > 0) {
                TreeNode cur = queueNode.poll();
                int num = queueVal.poll();
                if (cur.left == null && cur.right == null) {
                    if (num == targetSum) return true;
                    else continue;
                }
                if (cur.left != null) {
                    queueNode.offer(cur.left);
                    queueVal.offer(num + cur.left.val);
                }
                if (cur.right != null) {
                    queueNode.offer(cur.right);
                    queueVal.offer(num + cur.right.val);
                }
            }
        }

        return false;
    }

    /**
     * 广度优先搜索 层序遍历 但是队列中保存两个值，一个是节点另一个是遍历过程中的路径和
     */
    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, root.val});

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Object[] poll = queue.poll();
                TreeNode cur = (TreeNode) poll[0];
                int num = (int) poll[1];
                if (cur.left == null && cur.right == null) {  // 找到根节点了 如果符合则返回true 反之跳过
                    if (num == targetSum) return true;
                    else continue;
                }
                if (cur.left != null) {
                    queue.offer(new Object[]{cur.left, num + cur.left.val});
                }
                if (cur.right != null) {
                    queue.offer(new Object[]{cur.right, num + cur.right.val});
                }
            }
        }

        return false;
    }

}
