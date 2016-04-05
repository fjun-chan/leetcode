package algorithms;

/**
 *  Given two binary trees, write a function to check if they are equal or not.
 *
 *  Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * Created by fjun on 4/5/16.
 */
public class P100SameTree {

    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}
