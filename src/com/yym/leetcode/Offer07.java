package com.yym.leetcode;

import com.yym.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Offer07 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public TreeNode run(int[] preorder, int[] inorder) {
        return new Solution().buildTree(preorder, inorder);
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            if (inorder.length != n || n <= 0) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]);
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            int inorderIndex = 0;
            for (int i = 1; i < n; i++) {
                int inorderVal = preorder[i];
                TreeNode node = stack.peek();
                if (node.val != inorder[inorderIndex]) {
                    node.left = new TreeNode(inorderVal);
                    stack.push(node.left);
                } else {
                    while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                        node = stack.pop();
                        inorderIndex++;
                    }
                    node.right = new TreeNode(inorderVal);
                    stack.push(node.right);
                }
            }
            return root;
        }
    }

}
