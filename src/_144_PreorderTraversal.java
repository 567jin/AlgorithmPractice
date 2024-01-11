import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author jzy
 * @since 2024-01-11 9:29:21
 */
public class _144_PreorderTraversal {
    public static void main(String[] args) {
        Integer[] nodes = {1, null, 2, 3};
        TreeNode root = TreeNode.genTree(nodes);
        List<Integer> list = new _144_PreorderTraversal().preorderTraversal(root);
        System.out.println(list);

        List<Integer> list2 = new _144_PreorderTraversal().preorderTraversal2(root);
        System.out.println(list2);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }

        return res;
    }

}
