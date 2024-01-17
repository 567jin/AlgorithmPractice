import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jzy
 * @since 2024-01-17 10:49:23
 */
public class _230_KthSmallest {
    public static void main(String[] args) {
        Integer[] nodes = {3, 1, 4, null, 2};
        TreeNode root = TreeNode.genTree(nodes);
        int k = 1;
        int i = new _230_KthSmallest().kthSmallest(root, k);
        System.out.println(i);

        int j = new _230_KthSmallest().kthSmallest2(root, k);
        System.out.println(j);
    }

    /**
     * 利用二叉搜索树的性质 第k个最小值 即第k个中序遍历过程中被弹栈的值
     */
    public int kthSmallest2(TreeNode root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (--k == 0) {
                return cur.val;
            }
            cur = cur.right;
        }

        return Integer.MIN_VALUE;
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = dfs(root, new ArrayList<>());
        return res.get(k - 1);
    }

    /**
     * 中序遍历二叉搜索树 返回的是排序的数组 然后找到第k小的即可 缺点是没有利用二叉搜索树的性质，并且占额外O(n)的存储空间
     */
    private List<Integer> dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
        return res;
    }
}
