import sun.reflect.generics.tree.Tree;
import utils.TreeNode;

import java.util.*;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-14 9:34:24
 */
public class _173_BSTIterator {
    public static void main(String[] args) {
        Integer[] nodes = {7, 3, 15, null, null, 9, 20};
        TreeNode root = TreeNode.genTree(nodes);

        BSTIterator bstIterator = new BSTIterator(root);

    }

    /**
     * 直接使用中序遍历 题目的意思就是把中序遍历拆开 拆成两个函数
     */
    class BSTIterator2 {
        private TreeNode cur;
        private Stack<TreeNode> stack;

        public BSTIterator2(TreeNode root) {
            this.cur = root;
            stack = new Stack<>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int ans = cur.val;
            cur = cur.right;
            return ans;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }

    /**
     * 使用一个数组保存所有结果
     */
    static class BSTIterator {
        private TreeNode root;
        public LinkedList<Integer> list;

        public BSTIterator(TreeNode root) {
            this.root = root;
            TreeNode cur = new TreeNode(-1);
            this.list = new LinkedList<>();
            bfs();
        }

        public int next() {
            Integer first = list.getFirst();
            list.removeFirst();
            return first;
        }

        public boolean hasNext() {
            return list.isEmpty();
        }

        private void bfs() {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                list.addLast(cur.val);
                cur = cur.right;
            }
        }


    }


}
