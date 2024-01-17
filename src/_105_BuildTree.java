import utils.TreeNode;

import java.util.Arrays;

/**
 * @author jzy
 * @since 2024-01-17 9:51:28
 */
public class _105_BuildTree {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
//        TreeNode node = new _105_BuildTree().buildTree(preorder, inorder);
        TreeNode node = new _105_BuildTree().buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
        TreeNode.printTree(node);

    }

    /**
     * 以下都是建立在所有节点的值互不相等的前提
     * 前序遍历结果找根节点
     * 根据找到的根节点和中序遍历找左右子树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        // 从中序遍历中找根节点 并分割左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) { // 找到了根节点 分割
                int[] leftPreorder = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] rightPreorder = Arrays.copyOfRange(preorder, i + 1, preorder.length);

                int[] leftInorder = Arrays.copyOfRange(inorder, 0, i);
                int[] rightInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                root.left = buildTree(leftPreorder, leftInorder);
                root.right = buildTree(rightPreorder, rightInorder);
            }
        }

        return root;
    }

    /**
     * 使用 left 和right来界定范围
     * 起初preLeft = 0  preRight = preorder.length 左闭右开
     * 起初inLeft = 0  inRight = inorder.length 左闭右开
     */
    public TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);

        for (int i = inLeft; i < inRight; i++) {

            if (inorder[i] == rootVal) {
                // 递归建树
                // 计算左子树的节点数目
                int leftTreeSize = i - inLeft;
                if (leftTreeSize == 0) {
                    return root;
                }
                root.left = buildTree(preorder, preLeft + 1, preLeft + leftTreeSize, inorder, inLeft, i - 1);
                root.right = buildTree(preorder, preLeft + leftTreeSize + 1, preRight, inorder, i + 1, inRight);
            }
        }
        return root;
    }
}
