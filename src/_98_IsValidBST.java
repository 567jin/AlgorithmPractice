import utils.TreeNode;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-14 10:08:35
 */
public class _98_IsValidBST {
    public static void main(String[] args) {
        Integer[] nodes = {2, 1, 3};
//        nodes = new Integer[]{5, 1, 4, null, null, 3, 6};
//        nodes = new Integer[]{2, 2, 2,};
        TreeNode root = TreeNode.genTree(nodes);
        boolean validBST = new _98_IsValidBST().isValidBST2(root);
        System.out.println(validBST);
    }

    /**
     * 递归  一个二叉搜索树 的每个子树也是一个二叉搜索树
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }


    /**
     * 迭代 中序遍历
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        double inorder = -Double.MAX_VALUE;  // 中序遍历前一个节点值
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.val <= inorder) {
                return false;
            }
            inorder = cur.val;
            cur = cur.right;
        }
        return true;
    }
}
