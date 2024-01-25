import utils.TreeNode;

/**
 * @author jzy
 * @since 2024-01-25 9:46:57
 */
public class _114_Flatten {
    public static void main(String[] args) {
        Integer[] nodes = {1, 2, 5, 3, 4, null, 6};
        TreeNode root = TreeNode.genTree(nodes);
        TreeNode.printTree(root);
        new _114_Flatten().flatten(root);
        TreeNode.printTree(root);

        nodes = new Integer[]{1, 2, 5, 3, 4, null, 6};
        TreeNode root2 = TreeNode.genTree(nodes);
        TreeNode.printTree(root2);
        new _114_Flatten().flatten2(root2);
        TreeNode.printTree(root2);


        nodes = new Integer[]{1, 2, 5, 3, 4, null, 6};
        TreeNode root3 = TreeNode.genTree(nodes);
        TreeNode.printTree(root3);
        new _114_Flatten().flatten2(root3);
        TreeNode.printTree(root3);

    }

    /**
     * 迭代 右边移动到左边 最后左边再整体移动到右边
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {
                TreeNode left = cur.left;  // 左子树
                while (left.right != null) {  // 找左子树最右边的节点
                    left = left.right;
                }
                // 左子树的最右节点的右边 拼接上原来树节点的右边  即把原来树的右子树拼接到左子树上
                left.right = cur.right;

                // 整体平移左子树到右子树上
                cur.right = cur.left;
                cur.left = null;

                // 继续下一节点
            }
            cur = cur.right;
        }
    }

    /**
     * 迭代 右边直接移动到左边 但是要注意保存当前节点的右子树
     */
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {  // 左子树不为null才进行处理 反之直接移动到下一节点
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                // 左子树拼接到当前节点的右边
                cur.right = left;
                cur.left = null;  // 把当前节点的左子树置为null

                TreeNode rightMost = left;  // 最右节点
                while (rightMost.right != null) {  // 找最右节点 注意不要直接用left寻找 要不然会改变原来树的结构，因为left是引用类型
                    rightMost = rightMost.right;
                }

                rightMost.right = right;

                // 继续下一节点
            }
            cur = cur.right;
        }
    }


    private TreeNode pre = null;

    /**
     * 递归
     * <p>
     * 采用后序遍历的方式，因为前序遍历的话，右子树就丢了，采用后序遍历，确保遍历到当前节点时其右子树已经处理过了
     */
    public void flatten3(TreeNode root) {
        // 如果根节点为空，则无需进行扁平化操作，直接返回
        if (root == null) {
            return;
        }

        // 递归处理右子树，并将其扁平化
        flatten3(root.right);

        // 递归处理左子树，并将其扁平化
        flatten3(root.left);

        // 将当前节点的右子节点指向已经扁平化处理过的前一个节点（即原先的左子树最右侧节点或右子树最右侧节点）
        root.right = pre;

        // 将当前节点的左子节点设为null，因为在扁平化后，原左子树的所有节点都通过right指针连接到了当前节点之后
        root.left = null;

        // 更新全局变量pre，使其始终指向当前处理到的节点，以便后续节点的right指针能正确连接
        pre = root;
    }

}
