package com.hayashi2026.leetcode.tree;

import java.util.Stack;

public class BinarySearchTreeIterator {


}

class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        stack.push(node);
        dfs(node.left);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        dfs(node.right);
        return node.val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
