package com.leetcode.dfs;

import com.leetcode.definitions.TreeNode;

/**
 * 572. Subtree of Another Tree
 * Level: Easy
 * topics: dfs, binary tree, bst, binary search tree, recursion
 *              6
 *         /        \
 *        2          8
 *      /   \      /   \
 *     0     4    7     9
 *         /   \
 *        3     5
 * 1) input p = 2, q = 8; output = 6
 * 2) input p = 2, q = 4; output = 2
 * 3) input p = 3, q = 9; output = 6
**/
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftSubtree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubtree = lowestCommonAncestor(root.right, p, q);

        // If both of the above calls != NULL, then p is present in once subtree and q is present in other,
        // So this node is the LCA
        if(leftSubtree != null && rightSubtree != null) {
            return root;
        }

        // Otherwise, check if left subtree or right subtree is LCA
        return (leftSubtree != null) ? leftSubtree : rightSubtree;
    }
}
