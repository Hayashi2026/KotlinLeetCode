package com.hayashi2026.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumIsland2 {

    public static void main(String[] args) {
        Point[] arr = new Point[4];
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(1, 0);
        Point point4 = new Point(0, 1);
        arr[0] = point1;
        arr[1] = point2;
        arr[2] = point3;
        arr[3] = point4;
        NumIsland2 numIsland2 = new NumIsland2();
        numIsland2.numIslands2(2, 2, arr);
    }

    private int[] dx = new int[]{-1, 0, 1, 0};

    private int[] dy = new int[]{0, -1, 0, 1};

    private boolean isValid(int[][] islands, int x, int y) {
        if (x < 0 || x >= islands.length || y < 0 || y >= islands[0].length) {
            return false;
        }
        return islands[x][y] != 0;
    }

    /**
     * @param n:         An integer
     * @param m:         An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (n == 0 || m == 0 || operators == null || operators.length == 0) {
            return result;
        }
        UnionFind unionFind = new UnionFind(n * m);
        int[][] islands = new int[n][m];
        int count = 0;
        for (Point point : operators) {
            if (islands[point.x][point.y] != 1) {
                count++;
                islands[point.x][point.y] = 1;
                for (int i = 0; i < 4; i++) {
                    int nextX = point.x + dx[i];
                    int nextY = point.y + dy[i];
                    if (isValid(islands, nextX, nextY)) {
                        boolean isConnected = unionFind.connect(convertPoint(point.x, point.y, m), convertPoint(nextX, nextY, m));
                        if (isConnected) count--;
                    }
                }
            }
            result.add(count);
        }

        return result;
    }

    private int convertPoint(int x, int y, int m) {
        return x * m + y;
    }

    public class UnionFind {

        public int[] set;

        public UnionFind(int n) {
            set = new int[n];
            for (int i = 0; i < n; i++) {
                set[i] = i;
            }
        }

        public int find(int n) {
            if (set[n] == n) {
                return n;
            }
            return set[n] = find(set[n]);
        }

        public boolean connect(int x, int y) {
            int fatherX = find(x);
            int fatherY = find(y);
            if (fatherX != fatherY) {
                set[fatherY] = fatherX;
                return true;
            }
            return false;
        }
    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
