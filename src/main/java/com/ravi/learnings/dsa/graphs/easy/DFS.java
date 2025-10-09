package com.ravi.learnings.dsa.graphs.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * <a href="https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1">Problem</a>
 * <p>
 * Given a connected undirected graph containing V vertices represented by a 2-d adjacency list adj[][],
 * where each adj[i] represents the list of vertices connected to vertex i. Perform a Depth First Search (DFS)
 * traversal starting from vertex 0, visiting vertices from left to right as per the given adjacency list, and
 * return a list containing the DFS traversal of the graph.
 * <p>
 * Note: Do traverse in the same order as they are in the given adjacency list.
 * (0)
 * /  |  \
 * /    |    \
 * (1)   (2)   (3)
 * |
 * (4)
 * <p>
 * <p>
 * So  DFS of above graph is: 01423
 */
public class DFS {
    public static void main(String[] args) {
        final var arrayLists = new ArrayList<ArrayList<Integer>>();
        arrayLists.add(addElements(1, 2));
        arrayLists.add(addElements(0, 2));
        arrayLists.add(addElements(0, 1, 3, 4));
        arrayLists.add(addElements(2));
        arrayLists.add(addElements(2));

        System.out.println(dfs(arrayLists));
    }

    private static ArrayList<Integer> addElements(final int... ele) {
        final var list = new ArrayList<Integer>();
        for (int a : ele) {
            list.add(a);
        }
        return list;
    }

    /**
     *  1. For DFS we will use recursion, we will start from 0
     *  2. Check if the node is already visited of not, if not process further
     *  3. mark current element as visited and add to result
     *  4. Start for loop and get the neighbours from adj list
     *  5. Check if it is visited or not if not then recursively call dfs function with that number
     *  */
    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        final var size = adj.size();
        int[] visited = new int[size];
        ArrayList<Integer> list = new ArrayList<>();
        dfs(0, adj, visited, list);
        return list;
    }

    private static void dfs(int number, ArrayList<ArrayList<Integer>> adj, int[] visited, ArrayList<Integer> res) {
        if (visited[number] == 1) { // Base case when the incoming number is already visited we don't need to process
            // it again
            return;
        }

        // mark current element is visited and add that in result
        visited[number] = 1;
        res.add(number);

        // If number is not visited then get all its neighbour from adj list
        final var neighbours = adj.get(number);
        for (int num : neighbours) {
            if (visited[num] == 0) {
                dfs(num, adj, visited, res);
            }
        }
    }
}
