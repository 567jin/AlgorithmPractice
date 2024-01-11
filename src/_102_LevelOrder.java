import utils.TreeNode;

import java.util.*;

/**
 * @author jzy
 * @since 2024-01-11 10:19:27
 */
public class _102_LevelOrder {
    public static void main(String[] args) {
        Integer[] nodes = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.genTree(nodes);

        List<List<Integer>> lists = new _102_LevelOrder().levelOrder(root);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> path = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                path.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(new ArrayList<>(path));
        }

        return res;
    }
}
