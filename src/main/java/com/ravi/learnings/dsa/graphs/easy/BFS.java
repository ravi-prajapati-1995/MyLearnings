package com.ravi.learnings.dsa.graphs.easy;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * <a href="https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1">Problem</a>
 * <p>
 * Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list adj[][],
 * where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search (BFS)
 * traversal starting from vertex 0, visiting vertices from left to right according to the given adjacency list,
 * and return a list containing the BFS traversal of the graph.
 * <p>
 * Note: Do traverse in the same order as they are in the given adjacency list.
 * <p>
 * Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
 * Output: [0, 2, 3, 1, 4]
 * (0)
 * /  |  \
 * /    |    \
 * (1)   (2)   (3)
 * |
 * (4)
 * <p>
 * <p>
 * [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]
 */
public class BFS {
    public static void main(String[] args) {
        final var arrayLists = new ArrayList<ArrayList<Integer>>();
        arrayLists.add(addElements(1, 2));
        arrayLists.add(addElements(0, 2));
        arrayLists.add(addElements(0, 1, 3, 4));
        arrayLists.add(addElements(2));
        arrayLists.add(addElements(2));

        System.out.println(bfsStriverWay(arrayLists));
    }

    private static ArrayList<Integer> addElements(final int... ele) {
        final var list = new ArrayList<Integer>();
        for (int a : ele) {
            list.add(a);
        }
        return list;
    }

    /**
     * Below is the bfs search by striver
     * 1. Start from 0 and mark it as visited and that in queue
     * 2. Run while loop till we it is not empty
     * 3. for each get connected nodes from adjacency list
     * 4. Mark all member of adj list as visited and add them to queue
     * 5. Repeat this till queue is not empty
     */
    public static ArrayList<Integer> bfsStriverWay(ArrayList<ArrayList<Integer>> adj) {
        final var size = adj.size();
        int[] visited = new int[size];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = 1;
        final var bfs = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            final var poll = queue.poll();
            bfs.add(poll);

            for (int a : adj.get(poll)) {
                if (visited[a] == 0) { //Meaning this element is not visited
                    visited[a] = 1;
                    queue.add(a);
                }
            }
        }
        return bfs;
    }

    /***
     * 1. For BFS create a queue that will always contain the starting node
     * 2. Create a visitedArray that will track which node is visited of size N+1
     * 3. Mark the starting node value in visited array 1
     *      a. Get element from the queue till it is not empty
     *      b. Element that we just get from queue get all the neighbour of that node, it will get from the adjacency list
     *          that we have created
     *      c. Get each element and put that in queue after that mark in visited array as 1
     * 4. Reapeat above three steps for all the elements
     *
     * */
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        final var size = adj.size();
        int[] visited = new int[size];
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                list.addAll(traverse(queue, visited, adj));
            }
        }

        return list;
    }

    private static ArrayList<Integer> traverse(
            final Queue<Integer> queue,
            final int[] visited,
            final ArrayList<ArrayList<Integer>> adjacencyList
    ) {
        ArrayList<Integer> traversal = new ArrayList<>();
        // traverse till queue is not empty
        while (!queue.isEmpty()) {
            final var node = queue.poll();
            if (visited[node] == 1) { // if current node is already visited not process further
                continue;
            }
            traversal.add(node);
            //Mark node as visited
            visited[node] = 1;

            final var neighbours = adjacencyList.get(node);
            for (int a : neighbours) { // get neighbours and filter that are not visited and push to queue
                if (visited[a] == 0) {
                    queue.add(a);
                }
            }
        }
        System.out.println(traversal);
        return traversal;
    }
}
