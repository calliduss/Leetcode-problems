package com.leetcode.bfs;

import com.leetcode.definitions.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree
 * Level: Easy
 * topics: bfs, recursion, binary tree
 *            4                              4
 *         /     \                        /     \
 *        2       7                     7        2
 *      /   \   /   \                 /   \    /   \
 *     1    3  6     9               9     6  3     1
 * description: swap left and right nodes
 **/
public class InvertBinaryTree {

    public TreeNode invertBinaryTreeRecursively(TreeNode root) {
        if(root == null) {
            return root;
        }

        // swap, i.e. change pointers
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBinaryTreeRecursively(root.left);
        invertBinaryTreeRecursively(root.right);

        return root;
    }

    public TreeNode invertBinaryTreeIteratively(TreeNode root) {
        if(root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            swapNodes(current);

            if(current.left != null) {
                queue.add(current.left);
            }

            if(current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }

    private void swapNodes(TreeNode root) {
        if(root == null) {
            return;
        }

        // swap, i.e. change pointers
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}