package algorithms;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * _______6______
 * /              \
 * ___2__          ___8__
 * /      \        /      \
 * 0      _4       7       9
 * /  \
 * 3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Created by fjun on 4/6/16.
 */
public class P235LowestCommonAncestorOfABinarySearchTree {

    private static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        final int min = Math.min(p.val, q.val);
        final int max = Math.max(p.val, q.val);
        while (root != null) {
            int v = root.val;
            if (v >= min && v <= max) {
                return root;
            }
            if (v < min) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }
}
