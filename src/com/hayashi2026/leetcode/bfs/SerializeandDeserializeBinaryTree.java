package com.hayashi2026.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {

    private static final String EMPTY = "null";

    private static final String SPLIT = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        buildString(root, result);
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private void buildString(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append(EMPTY).append(SPLIT);
            return;
        }
        builder.append(node.val).append(SPLIT);
        buildString(node.left, builder);
        buildString(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(SPLIT)));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String node = queue.poll();
        TreeNode root;
        if (EMPTY.equals(node)) {
            return null;
        } else {
            root = new TreeNode(Integer.parseInt(node));
        }
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
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
