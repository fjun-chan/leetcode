package algorithms;

/**
 * Maximum Depth of Binary Tree
 *
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Created by fjun on 4/4/16.
 */
public class P104MaximumDepthOfBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int right = maxDepth(root.right);
        int left = maxDepth(root.left);
        return right > left ? right + 1 : left + 1;
    }
}
