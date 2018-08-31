package com.hayashi2026.leetcode.bfs;

import java.util.*;

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        List<UndirectedGraphNode> allNodes = getAllNodes(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> nodesMap = new HashMap<>();
        for (UndirectedGraphNode i : allNodes) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(i.label);
            nodesMap.put(i, newNode);
        }
        for (UndirectedGraphNode i : allNodes) {
            UndirectedGraphNode newNode = nodesMap.get(i);
            for (UndirectedGraphNode neighbor : i.neighbors) {
                UndirectedGraphNode newNeighbor = nodesMap.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return nodesMap.get(node);
    }

    private List<UndirectedGraphNode> getAllNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            if (set.contains(head)) {
                continue;
            }
            set.add(head);
            for (UndirectedGraphNode i : head.neighbors) {
                queue.offer(i);
            }
        }
        return new ArrayList<>(set);
    }

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public static void main(String args[]) {
        UndirectedGraphNode testData = new UndirectedGraphNode(-1);
        CloneGraph cloneGraph = new CloneGraph();
        System.out.println(cloneGraph.cloneGraph(testData));
    }

}