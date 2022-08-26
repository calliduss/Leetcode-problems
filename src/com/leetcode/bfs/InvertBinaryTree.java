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
 * article: swap left and right nodes
 **/
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        root.right = queue.poll();
        root.left = queue.poll();

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}