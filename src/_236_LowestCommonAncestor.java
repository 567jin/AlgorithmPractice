import utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-06 8:46:38
 */
public class _236_LowestCommonAncestor {
    public static void main(String[] args) {
        Integer[] nodes = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeNode.genTree(nodes);
        TreeNode p = root.left.left;
        TreeNode q = root.left.right;
        TreeNode node = new _236_LowestCommonAncestor().lowestCommonAncestor(root, p, q);
        System.out.println(node.val);
    }

    /**
     * 遍历的解法  先用一个HashMap存储所有节点的父结点 然后p和q同时向上找 记录各自找到的父结点 如果有重复的则说明有父结点
     */
    private final Map<Integer, TreeNode> parent = new HashMap<>();  // 存储所有节点的父结点
    private final Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {  // 从p开始往上不断找其所有的父节点并记录下来
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {  // 从q开始不断地找其父结点并判断 是否和p的有重合 如果有则该节点就是最近公共祖先(因为是从下往上找的 因此是最近的 又因为p和q的共同父结点因此是公共祖先)
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }

        return null;

    }

    private void dfs(TreeNode root) {  // 找所有节点的父结点
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }

    }


    /**
     * 以root为根节点 看看能否找到p和q 如果找到了则返回root
     * 如果只找到一个则
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {  // 以root为根节点的子树 是否能找到p和q
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null)
            return null;
        else if (left == null) //
            return right;
        else if (right == null)
            return left;
        else
            return root; // 找到了p q root即是最近公共祖先
    }


}
