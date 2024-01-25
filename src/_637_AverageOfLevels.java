import utils.TreeNode;

import java.util.*;

/**
 * @author jzy
 * @since 2024-01-25 9:22:10
 */
public class _637_AverageOfLevels {
    public static void main(String[] args) {
        Integer[] nodes = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.genTree(nodes);
        List<Double> doubles = new _637_AverageOfLevels().averageOfLevels(root);
        System.out.println(doubles);

        List<Double> doubles2 = new _637_AverageOfLevels().averageOfLevels2(root);
        System.out.println(doubles2);
    }

    private List<Double> sums;  // 计算每一层的和
    private List<Integer> nodes;  // 存储节点数

    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> res = new ArrayList<>();
        sums = new ArrayList<>();
        nodes = new ArrayList<>();
        dfs(root, 0);
        for (int i = 0; i < sums.size(); i++) {
            res.add(sums.get(i) / nodes.get(i));
        }
        return res;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            nodes.set(level, nodes.get(level) + 1);
        } else {
            sums.add(1.0 * root.val);
            nodes.add(1);
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);

    }

    /**
     * 层序遍历  计算每一层的总和再平均
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int n = size;
            Double sum = 0.0;
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(sum / n);
        }

        return res;
    }
}
