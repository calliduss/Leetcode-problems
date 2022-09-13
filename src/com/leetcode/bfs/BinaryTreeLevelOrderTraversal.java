package com.leetcode.bfs;

import com.leetcode.definitions.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * Level: Medium
 * topics: bfs, binary tree, bst
 *            3
 *         /     \
 *        9       20
 *              /   \
 *             15    7
 * 1) output = [[3], [9,20], [15, 7]]
 *            3
 *         /     \
 *        9       20
 *      /   \   /   \
 *     8    6  15    7
 * 2) output = [[3], [9,20], [8,6,15,7]]
 **/
public class BinaryTreeLevelOrderTraversal {

    private List<List<Integer>> treeLevelOrder = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return treeLevelOrder;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            // to fix the current queue size
            int currentQueueSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i = 0; i < currentQueueSize; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }

            treeLevelOrder.add(currentLevel);
        }
        return treeLevelOrder;
    }

}
