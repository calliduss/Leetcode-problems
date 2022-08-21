package com.leetcode.dfs;

import com.leetcode.definitions.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 144. Binary Tree Preorder Traversal
 * Level: Easy
 * topics: dfs, recursion, binary tree, iterative dfs
 *            1
 *             \
 *              2
 *             /
 *           3
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 **/
public class BinaryTreePreorderTraversal {

    private List<Integer> preorderList = new ArrayList<>();


    private List<Integer> recursivePreorderTraversal(TreeNode root) {
        if(root == null) {
            return preorderList;
        }

        preorderList.add(root.val);

        recursivePreorderTraversal(root.left);
        recursivePreorderTraversal(root.right);

        return preorderList;
    }

    private List<Integer> iterativePreorderTraversal(TreeNode root) {
        if(root == null) {
            return preorderList;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.peek(); //peek retrieves the head, but doesn't remove
            preorderList.add(temp.val);
            stack.pop(); //removes the head element of this deq

            // in iterative approach push right first, then left
            // in recursion start with the left node
            if(temp.right != null) {
                stack.push(temp.right);
            }

            if(temp.left != null) {
                stack.push(temp.left);
            }
        }

        return preorderList;
    }

}