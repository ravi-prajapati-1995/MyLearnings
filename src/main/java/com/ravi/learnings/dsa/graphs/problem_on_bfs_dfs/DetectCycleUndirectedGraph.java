package com.ravi.learnings.dsa.graphs.problem_on_bfs_dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class DetectCycleUndirectedGraph {
    public static void main(String[] args) {

        List<Integer>[] adj = new List[]{
                List.of(),                 // 0
                List.of(),                 // 1
                List.of(20, 18, 10, 23),   // 2
                List.of(14),               // 3
                List.of(10),               // 4
                List.of(),                 // 5
                List.of(22, 7, 20, 11),    // 6
                List.of(12, 6, 22),        // 7
                List.of(16, 15, 12, 13),   // 8
                List.of(20),               // 9
                List.of(17, 4, 2),         // 10
                List.of(6),                // 11
                List.of(7, 8),             // 12
                List.of(23, 8),            // 13
                List.of(22, 3),            // 14
                List.of(22, 8),            // 15
                List.of(8),                // 16
                List.of(10),               // 17
                List.of(2),                // 18
                List.of(23),               // 19
                List.of(2, 21, 6, 9),      // 20
                List.of(20),               // 21
                List.of(6, 14, 15, 7),     // 22
                List.of(13, 19, 2)         // 23
        };

        System.out.println(isCycle(24, adj));
    }

    public static boolean isCycle(int V, List<Integer>[] adj) {
        //Creating a array that will track if we visited this element or not
        int[] visited = new int[V];
        Queue<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] != 1) {
                queue.add(new Pair(i, -1));
                final var hasCycle = traverseFor(queue, visited, adj);
                if(hasCycle) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean traverseFor(
            final Queue<Pair> queue,
            final int[] visited,
            final List<Integer>[] adj
    ) {
        while (!queue.isEmpty()) {
            final var poll = queue.poll();
            if (visited[poll.val] == 1) {
                return true;
            }
            visited[poll.val] = 1;

            final var neighbours = adj[poll.val];
            for (int linked : neighbours) { // Here Getting all the linked node with the current node
                if (linked != poll.parent) { // we are putting all the element in the queue except parent
                    queue.add(new Pair(linked, poll.val));
                }
            }

            System.out.println(queue);
            System.out.println(Arrays.toString(visited));
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
