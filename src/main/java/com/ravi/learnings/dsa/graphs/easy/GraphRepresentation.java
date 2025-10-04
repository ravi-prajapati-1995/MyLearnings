package com.ravi.learnings.dsa.graphs.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphRepresentation {
    public static void main(String[] args) {
        //        usingMatrix();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Nodes: ");
        int nodes = sc.nextInt();
        System.out.print("Enter Edges: ");
        int edges = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>(nodes + 1);
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        printGraph(graph);
    }

    private static void printGraph(final List<List<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(i + " ----> " + graph.get(0));
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
