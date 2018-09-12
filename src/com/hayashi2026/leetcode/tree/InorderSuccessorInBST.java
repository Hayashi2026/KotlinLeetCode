package com.hayashi2026.leetcode.tree;

import java.util.Stack;

public class InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode res = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


