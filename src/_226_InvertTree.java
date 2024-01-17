import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jzy
 * @since 2024-01-17 9:03:27
 */
public class _226_InvertTree {
    public static void main(String[] args) {
        Integer[] nodes = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeNode.genTree(nodes);
        TreeNode.printTree(root);
        TreeNode node = new _226_InvertTree().invertTree(root);
        TreeNode.printTree(node);

        System.out.println("-----------------");
        nodes = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode root2 = TreeNode.genTree(nodes);
        TreeNode.printTree(root2);
        TreeNode node2 = new _226_InvertTree().invertTree2(root2);
        TreeNode.printTree(node2);


    }

    /**
     * 翻转二叉树 递归的写法
     */
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        dfs(root.left);  // 左子树
        dfs(root.right);  // 右子树
    }

    /**
     * 迭代写法 使用队列或者栈都可以 只要能保存下一个节点即可 然后再下一次循环中取出即可
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 交换左右子树
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return root;
    }


}
