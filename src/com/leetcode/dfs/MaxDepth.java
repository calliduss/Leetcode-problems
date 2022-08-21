package com.leetcode.dfs;

import com.leetcode.definitions.TreeNode;

/**
 * 104. Maximum depth of binary tree
 * Level: Easy
 * topics: dfs, recursion, binary tree
 *            3
 *         /    \
 *        9      20
 *             /   \
 *            15    7
 * article: https://www.educative.io/answers/finding-the-maximum-depth-of-a-binary-tree
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