import utils.TreeNode;

import java.util.*;

/**
 * @author jzy
 * @since 2024-01-24 10:38:01
 */
public class _199_RightSideView {
    public static void main(String[] args) {
        Integer[] nodes = {1, 2, 3, null, 5, null, 4};
        TreeNode root = TreeNode.genTree(nodes);
        List<Integer> list = new _199_RightSideView().rightSideView(root);
        System.out.println(list);

        List<Integer> list2 = new _199_RightSideView().rightSideView2(root);
        System.out.println(list2);

    }

    private int maxHeight;
    private List<Integer> res;

    /**
     * 深度遍历 每遍历到一个深度就记录一下最右边的值
     */
    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        res = new ArrayList<>();
        maxHeight = 0;
        dfs(root, 1);

        return res;
    }

    private void dfs(TreeNode root, int height) { //height表示深度
        if (root == null) {
            return;
        }
        if (maxHeight < height) {
            res.add(root.val);
            maxHeight = height;
        }
        dfs(root.right, height + 1);
        dfs(root.left, height + 1);
    }


    /**
     * 层序遍历  层序遍历的最后一个节点就是最右边的节点 类似的还可以求左视图 只需要把节点添加顺序换一下即可(先右再左即可得左视图)
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = root;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(cur.val);
        }

        return res;
    }
}
