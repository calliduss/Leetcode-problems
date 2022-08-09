package com.leetcode.dfs;

/**
 * 104. Maximum depth of binary tree
 * Level: Easy
 * topics: dfs, recursion, tree
 **/
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if(leftDepth > rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }
}