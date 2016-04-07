package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth
 *  smallest frequently? How would you optimize the kthSmallest routine?
 * <p>
 * Show Hint
 *
 * Created by fjun on 4/6/16.
 */
public class P230KthSmallestElementInABST {
    /**
     * 将左子树压入栈，并一层层pop。
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;
        while(n.left!=null) {
            stack.push(n);
            n = n.left;
        }

        while(k>0 && (n!=null || !stack.isEmpty())) {
            if(n==null) {
                n = stack.pop();
                if(--k==0) return n.val;
                n = n.right;
            } else {
                stack.push(n);
                n = n.left;
            }
        }
        return n.val;
    }

    public int kthSmallestSlow(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        inOrderTraversal(root, list);
        return list.get(k - 1);
    }

    public void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, list);
        list.add(node.val);
        inOrderTraversal(node.right, list);
    }
}
