import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-02-25 12:19:21
 */
public class _129_SumNumbers {
    public static void main(String[] args) {
        Integer[] nodes = {1, 2, 3};
        TreeNode root = TreeNode.genTree(nodes);
        int sumNumbers = new _129_SumNumbers().sumNumbers(root);
        System.out.println(sumNumbers);

        int sumNumbers2 = new _129_SumNumbers().sumNumbers2(root);
        System.out.println(sumNumbers2);
    }

    /**
     * 深度优先遍历
     */
    private int res = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int path) {
        if (root == null) {
            return;
        }
        path = path * 10 + root.val;
        if (root.left == null && root.right == null) { // 叶子结点
            res += path;
            return;
        }
        dfs(root.left, path);
        dfs(root.right, path);
    }

    /**
     * 广度优先搜索
     */
    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();  // 维护节点
        Queue<Integer> numQueue = new LinkedList<Integer>();  // 维护节点对应的数字
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode cur = nodeQueue.poll();
            int sum = numQueue.poll();
            if (cur.left == null && cur.right == null) {
                res += sum;
            } else {
                if (cur.left != null) {
                    nodeQueue.offer(cur.left);
                    numQueue.offer(sum * 10 + cur.left.val);
                }
                if (cur.right != null) {
                    nodeQueue.offer(cur.right);
                    numQueue.offer(sum * 10 + cur.right.val);
                }
            }

        }

        return res;
    }

}
