package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jzy
 * @since 2024-01-11 8:57:49
 */
public class TreeNode {
    public static void main(String[] args) {
        Integer[] nodes = {1, null, 2, 3};
        TreeNode node = TreeNode.genTree(nodes);

        TreeNode.printTree(node);
    }

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static TreeNode genTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode cur = queue.poll();

            if (nodes[i] != null) {
                cur.left = new TreeNode(nodes[i]);
                queue.offer(cur.left);
            }

            if (i + 1 < nodes.length && nodes[i + 1] != null) {
                cur.right = new TreeNode(nodes[i + 1]);
                queue.offer(cur.right);
            }
        }

        return root;
    }

    /**
     * 层序遍历的方式打印树
     */
    public static void printTree(TreeNode root) {  // 层序遍历的方式打印树
        if (root == null) {
            return;
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                res.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        System.out.println(res);
    }

}
