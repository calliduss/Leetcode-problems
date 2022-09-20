package com.leetcode.dfs;

import com.leetcode.definitions.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * Level: Medium
 * topics: dfs, binary tree, bst
 *            2
 *          /   \
 *         1     3
 * 1) output: true
 *           5
 *         /   \
 *        4     6
 *            /   \
 *           3    7
 * 2) output: false
 * article: https://www.educative.io/answers/how-to-check-if-a-binary-tree-is-a-binary-search-tree
 **/
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode current, int min, int max) {
        if(current == null) {
            return true;
        }

        if(current.val <= min) {
            return false;
        }

        if(current.val >= max) {
            return false;
        }

        return isBST(current.left, min, current.val) && isBST(current.right, current.val, max);
    }
}
