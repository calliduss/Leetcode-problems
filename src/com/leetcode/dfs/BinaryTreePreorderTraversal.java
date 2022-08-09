package com.leetcode.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 144. Binary Tree Preorder Traversal
 * Level: Easy
 * topics: dfs, recursion, tree, iterative dfs
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