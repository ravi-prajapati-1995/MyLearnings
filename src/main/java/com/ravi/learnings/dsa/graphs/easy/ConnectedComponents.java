package com.ravi.learnings.dsa.graphs.easy;

import java.util.ArrayList;
import java.util.List;

import static com.ravi.learnings.dsa.graphs.easy.GraphRepresentation.printGraph;

/**
 * <a href="https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1">Link</a>
 * <p>
 * Given an undirected graph with V vertices numbered from 0 to V-1 and E edges,
 * represented as a 2D array edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v.
 * <p>
 * Your task is to return a list of all connected components. Each connected component should be represented as a
 * list of its vertices, with all components returned in a collection where each component is listed separately.
 * <p>
 * Note: You can return the components in any order, driver code will print the components in sorted order.
 * <p>
 * A graph can have multiple components which may be not connected with each other like
 * c1: A --- B --- C
 * \
 * D
 * <p>
 * c2: E --- F
 * \
 * G
 * <p>
 * c3:  H
 * |
 * I --- J --- K
 * <p>
 * In above graph we have 3 components c1, c2 and c3 are not connected with each other but still they
 */
public class ConnectedComponents {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {2, 1}, {3, 4}};
        int nodes = 5;
        final var components = getComponents(5, edges);
        printGraph(components);
    }

    public static void printGraph(final ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(i + " ----> " + graph.get(i));
        }
    }

    /**
     * To get all the components of the graph for traversal we need to keep an array that will tell if the current
     * element is visited or not
     * If we have a graph of 10 elements we need an array of 11 length that will store if element is visited of not
     * 1. Run a loop from 1-n, here n is the number of nodes in graph
     * 2. When we traverse any node then we will mark it as 1
     * 3. If we found a number that is not traversed, we will traverse all the nodes of that component
     */
    public static ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        final var initialCapacity = V + 1;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < initialCapacity; i++) {
            graph.add(new ArrayList<>());
        }
        int[] visited = new int[V];

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];


            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return graph;
    }
}
