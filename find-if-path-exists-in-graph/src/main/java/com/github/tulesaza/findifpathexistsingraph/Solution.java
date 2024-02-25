package com.github.tulesaza.findifpathexistsingraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private final Approach approach;

    public Solution(Approach approach) {
        this.approach = approach;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        return switch (approach) {
            case BFS -> bfs(n, edges, source, destination);
            case UNION_FIND -> unionFind(n, edges, source, destination);
        };
    }

    private boolean bfs(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (var edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            var current = queue.poll();
            if (current == destination) {
                return true;
            }
            if (visited[current]) {
                continue;
            }
            for (int neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                queue.offer(neighbor);
            }
            visited[current] = true;
        }

        return visited[destination];
    }

    private boolean unionFind(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind(n);
        for (var edge : edges) {
            int x = edge[0], y = edge[1];
            unionFind.union(x, y);
        }
        return unionFind.find(source) == unionFind.find(destination);
    }

    // naive without compression
    static class UnionFind {
        private final int[] parent;
        private final int[] size;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int a) {
            if (a == parent[a]) {
                return a;
            }
            return find(parent[a]);
        }

        public boolean union(int a, int b) {
            int fa = find(a), fb = find(b);
            if (fa == fb) {
                return false;
            }
            if (size[fa] > size[fb]) {
                parent[fb] = fa;
                size[fa] += size[fb];
            } else {
                parent[fa] = fb;
                size[fb] += size[fa];
            }
            return true;
        }
    }


    enum Approach {
        BFS, UNION_FIND
    }
}