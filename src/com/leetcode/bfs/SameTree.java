package com.leetcode.bfs;

import com.leetcode.definitions.TreeNode;

/**
 * 100. Same Tree
 * Level: Easy
 * topics: bfs, recursion, binary tree
 *            1          1
 *         /    \     /    \
 *        2      3   2      3
 * 1) Output: true
 *            1          1
 *         /    \     /    \
 *        2      1   1      2
 * 2) Output: false
 *          1          1
 *         /            \
 *        2              2
 * 3) Output: false
 **/
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) { return true; }
        if(p == null || q == null) { return false; }
        if(p.val != q.val) { return false; }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}