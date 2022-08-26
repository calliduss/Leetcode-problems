package com.leetcode.dfs;

import com.leetcode.definitions.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 * Level: Easy
 * topics: dfs, recursion, binary tree
 *            3                    3                1
 *         /    \                /   \               \
 *        9      20             20    9               2
 *             /   \          /   \                    \
 *            15    7        15    7                    3
 *                                                       \
 *                                                        4
 *                                                         \
 *                                                          5
 *                                                           \
 *                                                            6
 * 1) Output: 2
 * 2) Output: 6
 * article: https://www.educative.io/answers/how-to-find-the-minimum-depth-of-a-binary-tree
 **/
public class MinDepth {

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if(leftDepth == 0 && rightDepth != 0) {
            return rightDepth + 1;
        } else if(leftDepth != 0 && rightDepth == 0) {
            return leftDepth + 1;
        } else if(leftDepth > rightDepth) {
            return rightDepth + 1;
        } else {
            return leftDepth + 1;
        }
    }
}