package com.ravi.learnings.dsa.graphs.easy;

import java.util.*;

public class GraphRepresentation {
    public static void main(String[] args) {
        //        usingMatrix();
        //        createGraphUsingList();
        graph();
    }

    private static void graph() {
        // I am having 4 nodes and 5 edges
        int nodes = 4;

        final var initialCapacity = nodes + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < initialCapacity; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(2).add(4);

        graph.get(3).add(1);
        graph.get(3).add(2);
        graph.get(3).add(4);

        graph.get(4).add(3);
        graph.get(4).add(2);

        printGraph(graph);
    }

    /**
     * In graph if it is undirection
     * SC: O(2E) where E is the edges as we are using space twice of edges
     * <p>
     * In directional graph SC will be O(E) as there will be only one side relationship 1 2
     */
    private static void createGraphUsingList() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Nodes: ");
        int nodes = sc.nextInt();
        System.out.print("Enter Edges: ");
        int edges = sc.nextInt();

        final var initialCapacity = nodes + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < initialCapacity; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // Here we require two input like 1 2 (meaning 1 is connected with 2) and here we also adding 2 1 meaning
            // 2 is connected with 1 as this is undirectional graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        printGraph(graph);
    }

    public static void printGraph(final List<List<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(i + " ----> " + graph.get(i));
        }
    }

    private static void usingMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Nodes: ");
        int nodes = sc.nextInt();
        System.out.print("Enter Edges: ");
        int edges = sc.nextInt();

        int[][] matrix = new int[nodes + 1][edges + 1];

        // we loop over edges because number of edges we have number of elements we will add in matrix
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        printMatrix(matrix);
    }

    private static void printMatrix(final int[][] matrix) {
        final var rows = matrix.length;
        final var length = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
