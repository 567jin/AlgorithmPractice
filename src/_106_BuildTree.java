import utils.TreeNode;

import java.util.Arrays;

/**
 * @author jzy
 * @since 2024-01-19 9:58:30
 */
public class _106_BuildTree {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};  // 分割左右子树
        int[] postorder = {9, 15, 7, 20, 3};  // 定位根节点
        TreeNode node = new _106_BuildTree().buildTree(inorder, postorder);
        TreeNode.printTree(node);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {  // 找到根节点 进行分割
                int[] leftInorder = Arrays.copyOfRange(inorder, 0, i);
                int[] rightInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                int[] leftPostorder = Arrays.copyOfRange(postorder, 0, i);
                int[] rightPostorder = Arrays.copyOfRange(postorder, i, postorder.length - 1);

                root.left = buildTree(leftInorder, leftPostorder);
                root.right = buildTree(rightInorder, rightPostorder);
            }
        }
        return root;
    }
}
