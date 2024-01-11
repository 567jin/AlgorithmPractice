import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author jzy
 * @since 2024-01-11 9:53:20
 */
public class _145_PostorderTraversal {
    public static void main(String[] args) {
        Integer[] nodes = {1, null, 2, 3};
        TreeNode root = TreeNode.genTree(nodes);
        List<Integer> list = new _145_PostorderTraversal().postorderTraversal(root);
        System.out.println(list);

        List<Integer> list2 = new _145_PostorderTraversal().postorderTraversal2(root);
        System.out.println(list2);

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;  // 记录上一个弹出节点
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode peek = stack.peek();  // 当前要弹出节点
            // 只有当前要弹出节点的右节点等于上一个节点或为null时 说明右子树处理过了 可以弹出了
            if (peek.right == pre || peek.right == null) {
                pre = stack.pop();
                res.add(pre.val);
            } else { // 当前要弹出节点的右子树没有处理过 继续处理
                cur = peek.right;
            }

        }
        return res;
    }

}
