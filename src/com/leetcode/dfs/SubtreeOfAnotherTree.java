package com.leetcode.dfs;

import com.leetcode.definitions.TreeNode;

/**
 * 572. Subtree of Another Tree
 * Level: Easy
 * topics: dfs, binary tree, recursion, iterative
 *           root
 *            3
 *         /     \       subRoot
 *        4       5         4
 *      /   \             /   \
 *     1    2            1     2
 * 1) Output: true
 *
 *           root
 *            3
 *         /     \       subRoot
 *        4       5         4
 *      /   \             /   \
 *     1    2            1     2
 *         /
 *        0
 * 2) Output: false
 *
 *         root
 *          1
 *         /        subRoot
 *        1            1
 * 3) Output: true
 *
 *         root     subRoot
 *          1          1
 * 4) Output: true
 *
 *          root            subRoot
 *           4                 4
 *         /   \             /   \
 *        1     2           1     2
 * 5) Output: true
 **/
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }

        if(subRoot == null) {
            return true;
        }

        if(areTreesEqual(root, subRoot)) {
            return true;
        }

        // dive in the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean areTreesEqual(TreeNode first, TreeNode second) {
        if(first == null && second == null) {
            return true;
        }

        if(first == null || second == null) {
            return false;
        }

        return first.val == second.val &&
                areTreesEqual(first.left, second.left) &&
                areTreesEqual(first.right, second.right);
    }
}