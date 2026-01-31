package com.ravi.learnings.dsa.binarytree.traversal;

// Binary Tree representation for: [3, 9, 20, null, null, 15, 7]
//
//         3
//        / \
//       9   20
//          /  \
//         15   7

import com.ravi.learnings.dsa.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * In level order traversal we traverse by level
 * level-0 - 3
 * level-1 - 9, 20
 * level-2 - 15, 7
 */
public class LevelTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        treeTraversal(root);
    }

    /**
     * To traverse binary tree in level we will use of queue DS
     * Intution behind it that while we get the current level elements, we add next level elements in the queue, and
     * then iterate queue basd on size, and do it for rest
     * 1. Add root element in the queue DS
     * 2. Then start iterate loop over queue element
     * 3. While we print/add current node value in list, all left and right node in queue if exist
     * 4. Follow the same till elements is not null
     */
    static List<List<Integer>> treeTraversal(TreeNode root) {
        // create a queue in which we will add node or current level
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final var size = queue.size();
            var li = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                final var pop = queue.poll();
                li.add(pop.val);

                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
            res.add(li);
        }
        return res;
    }

    private static void getLevelElements(final TreeNode root, final LinkedList<TreeNode> queue) {

    }
}
