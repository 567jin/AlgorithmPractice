import utils.TreeNode;

/**
 * @author jzy
 * @since 2024-01-11 15:40:52
 */
public class _104_MaxDepth {
    public static void main(String[] args) {
        Integer[] nodes = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.genTree(nodes);
        int maxDepth = new _104_MaxDepth().maxDepth(root);
        System.out.println(maxDepth);

    }

    private int maxDepth = Integer.MIN_VALUE;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return maxDepth == Integer.MIN_VALUE ? 0 : maxDepth;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = Math.max(depth, maxDepth);  // root=null了 可以更新最大值了
            return;
        }
        dfs(root.left, depth + 1);  // 每次递归调用代表深度加1
        dfs(root.right, depth + 1);
    }
}
