package algorithms;

/**
 *  Invert a binary tree.

 4
 /   \
 2     7
 / \   / \
 1   3 6   9

 to

 4
 /   \
 7     2
 / \   / \
 9   6 3   1

 *
 * Created by fjun on 4/4/16.
 */
public class P226InvertBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode right = null;
        if (root.right != null) {
            right = invertTree(root.right);
        }
        TreeNode left = null;
        if (root.left != null) {
            left = invertTree(root.left);
        }
        root.right = left;
        root.left = right;
        return root;
    }
}
