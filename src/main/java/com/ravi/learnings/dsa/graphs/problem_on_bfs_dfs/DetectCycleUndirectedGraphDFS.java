package com.ravi.learnings.dsa.graphs.problem_on_bfs_dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class DetectCycleUndirectedGraphDFS {
    public static void main(String[] args) {

        List<Integer>[] adj = new List[] {
                List.of(1, 2), // 0
                List.of(0), // 1
                List.of(0, 3), // 2
                List.of(2) // 3
        };

        System.out.println(isCycle(4, adj));
    }

    public static boolean isCycle(int V, List<Integer>[] adj) {
        // Creating a array that will track if we visited this element or not
        int[] visited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] != 1) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(
            final int node,
            final int parent,
            final int[] visited,
            final List<Integer>[] adj) {

        System.out.println(node + "\t" + parent);
        visited[node] = 1;
        System.out.println(Arrays.toString(visited));

        for (int neighbour : adj[node]) {
            if (visited[neighbour] != 1) {
                if (dfs(neighbour, node, visited, adj)) {
                    return true;
                } else if (parent != -1 && neighbour != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class Pair {
        int val;
        int parent;

        private Pair(final int val, final int parent) {
            this.val = val;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return val + " " + parent;
        }
    }
}
