package com.ravi.learnings.dsa.graphs.problem_on_bfs_dfs;

import java.util.*;

/**
 * Given a undirected Graph consisting of V vertices numbered from 0 to V-1 and
 * E edges.
 * The ith edge is represented by [ai,bi], denoting a edge between vertex ai and
 * bi.
 * We say two vertices u and v belong to a same component if there is a path
 * from u to v or v to u.
 * Find the number of connected components in the graph.
 * <p>
 * <p>
 * <p>
 * A connected component is a subgraph of a graph in which there exists a path
 * between any two vertices,
 * and no vertex of the subgraph shares an edge with a vertex outside of the
 * subgraph.
 */
public class ConnectedComponents {
    public static void main(String[] args) {
        final var arrayLists = new ArrayList<List<Integer>>();
        arrayLists.add(addElements(0, 1));
        arrayLists.add(addElements(1, 2));
        arrayLists.add(addElements(2, 3));
        arrayLists.add(addElements(4, 5));
        findNumberOfComponent(7, arrayLists);
    }

    private static List<Integer> addElements(final int... ele) {
        final var list = new ArrayList<Integer>();
        for (int a : ele) {
            list.add(a);
        }
        return list;
    }

    /**Input: V = 7, edges = [[0, 1], [1, 2], [2, 3], [4, 5]]
     * So we are given components which are connected with each other
     * 1. We need to convert this adjacency list, so that for each position we can get with element is connected
     * i.e  for above we can get: [[1], [0, 2], [1, 3], [2], [5], [4], []]
     * Here for 0th we have 1 connected, then for 1  we have 0 and 2 connect 
     * index shows current element the given array shows connected element with this
     * TO get the connected components we will take the visited array if any element
     * is visited then we will mark it as
     * 1 and when we process element if it is already processed we will skip that
     * element
     * 1.
     *
     * @param V
     * @param edges
     * @return
     */
    public static int findNumberOfComponent(int V, List<List<Integer>> edges) {
        System.out.println(edges);
        int E = edges.size();

        // To store adjacency list
        List<Integer>[] adjLs = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjLs[i] = new ArrayList<>();
        }

        // Add edges to adjacency list
        for (int i = 0; i < E; i++) {
            adjLs[edges.get(i).get(0)].add(edges.get(i).get(1));
            adjLs[edges.get(i).get(1)].add(edges.get(i).get(0));
        }
        System.out.println(Arrays.toString(adjLs));
        int visited[] = new int[V];
        int components = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                traverse(visited, i, adjLs);
                components++;
            }
        }
        return components;
    }

    private static void traverse(int[] visited, int i, List<Integer>[] edges) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> components = new ArrayList<>();
        queue.add(i);
        while(!queue.isEmpty()) {
            Integer pop = queue.poll();
            if(visited[pop] == 1) {
                continue;
            }
            visited[pop] = 1;
            components.add(pop);
            if(pop >= edges.length) {
                continue;
            }
            List<Integer> list = edges[pop];
            for(int element: list) {
                if(visited[element] == 0) { // adding to queue if edge is not visited
                    queue.add(element);
                }
            }

         }
        System.out.println("Component for " + i +" is "+ components);
    }

}
