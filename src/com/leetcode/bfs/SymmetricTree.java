package com.leetcode.bfs;

import com.leetcode.definitions.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 * Level: Easy
 * topics: bfs, recursion, binary tree, iterative bfs
 * description:
 * - if root null => symmetric tree
 * - if left and right nodes are null => symmetric tree
 * - the two root nodes have the same value
 * - the left subtree of one root node is a mirror reflection of the right subtree of the other root node
 *            1                 1
 *         /  |  \            / | \
 *        2   |   2         2   |  2
 *      /  \  |  /  \       \   |   \
 *     3    4 | 3    4       3  |    3
 *  1) Output: true
 *  2) Output: false
 * article: https://www.baeldung.com/cs/binary-tree-is-symmetric
 **/
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        // iterative approach
        // return isMirrorIterative(root);

        //recursive approach
        return isMirrorRecursive(root.left, root.right);
    }

    private boolean isMirrorRecursive(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left ==null || right == null) {
            return false;
        } else {
            return left.val == right.val &&
                    isMirrorRecursive(left.left, right.right) &&
                    isMirrorRecursive(left.right, right.left);
        }
    }

    private boolean isMirrorIterative(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null) {
                continue;
            }

            if(left == null || right == null) {
                return false;
            }

            if(left.val != right.val) {
                return false;
            }

            // note the order
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
