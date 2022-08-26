package com.leetcode.dfs;

import com.leetcode.definitions.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum depth of binary tree
 * Level: Easy
 * topics: dfs, recursion, binary tree
 *            3                             3
 *         /    \                        /    \
 *        9      20                    9        20
 *             /   \                 /   \    /   \
 *            15    7               8    6   15    7
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

    // BFS, i.e. loop level by level
    public int maxDepthIterative(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            depth++;
            int currentQueueSize = queue.size();

            // loop throughout each level
            for(int i = 0; i < currentQueueSize; i++) {
                TreeNode current = queue.poll();

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return depth;
    }
}