import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author jzy
 * @since 2024-01-11 9:43:39
 */
public class _94_InorderTraversal {
    public static void main(String[] args) {
        Integer[] nodes = {1, null, 2, 3};
        TreeNode root = TreeNode.genTree(nodes);

        List<Integer> list = new _94_InorderTraversal().inorderTraversal(root);
        System.out.println(list);

        List<Integer> list2 = new _94_InorderTraversal().inorderTraversal2(root);
        System.out.println(list2);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }


}
