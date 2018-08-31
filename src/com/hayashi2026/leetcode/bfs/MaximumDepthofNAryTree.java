package com.hayashi2026.leetcode.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthofNAryTree {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node head = queue.poll();
                for (Node node : head.children) {
                    queue.offer(node);
                }
            }
        }
        return depth;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
