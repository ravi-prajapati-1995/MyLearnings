package com.ravi.learnings.dsa.graphs.problem_on_bfs_dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * <a href=
 * "https://leetcode.com/problems/number-of-provinces/description/">Problem
 * Link</a><br/>
 *
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly
 * with city c,
 * then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 * Return the total number of provinces.
 *
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] edges = { {1,1,0} ,{1,1,0},{0,0,1} };
        System.out.println(numProvinces(edges));

    }

    public static int numProvinces(int[][] adj) {
        final var adjacencyList = getAdjacencyList(adj.length, adj);
        int count = 0;
        final var size = adjacencyList.size();
        int[] visited = new int[size];
        for (int i = 0; i < size; i++) {
            if (visited[i] == 1 ) {
                continue;
            }
            count++;
            dfs(i, adjacencyList, visited);
        }

        return count;
    }

    private static void dfs(int num, final ArrayList<ArrayList<Integer>> adjacencyList, final int[] visited) {
        if(visited[num] == 1) return;

        visited[num] = 1;
        for(int i: adjacencyList.get(num)) {
            if(visited[i] != 1) {
                dfs(i, adjacencyList, visited);
            }
        }

    }

    private static void BFS(
            final Queue<Integer> queue, final ArrayList<ArrayList<Integer>> adjacencyList, final int[] visited) {
        final var bfs = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            final var poll = queue.poll();
            bfs.add(poll);

            for (int a : adjacencyList.get(poll)) {
                if (visited[a] == 0) { // Meaning this element is not visited
                    visited[a] = 1;
                    queue.add(a);
                }
            }
        }
    }

    /**
     * This will return the connected element i.e if with 1 two nodes are connected
     * 2 and 3
     * it will give for get(1) -- 2, 3
     * 
     * While we are creating adjacency matrix we need to care about the condition where for 1 1 we have 1 value or for
     * 2 2 we have 1, we need to skip it
     */
    private static ArrayList<ArrayList<Integer>> getAdjacencyList(final int size, final int[][] edges) {
        final var initialCapacity = size;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < initialCapacity; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j && edges[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        return graph;
    }
}
