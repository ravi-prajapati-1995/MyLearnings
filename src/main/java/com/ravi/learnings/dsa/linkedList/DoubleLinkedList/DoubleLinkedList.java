package com.ravi.learnings.dsa.linkedList.DoubleLinkedList;

/*
 * https://www.youtube.com/watch?v=0eKMU10uEDI
 * */
public class DoubleLinkedList {
    public static void main(String[] args) {
        final var ints = new int[]{1, 2, 3, 4, 5};
        final var integerNode = Node.fromArray(ints);

//        final var integerNode1 = Node.insertHead(integerNode, 22);
//        final var integerNode1 = Node.insertTail(integerNode, 232);
//        final var integerNode1 = Node.insertAtPosition(integerNode, 232, 6);
//        final var integerNode1 = Node.insertAtValue(integerNode, 232, 36);
//        final var integerNode1 = Node.insertBeforeTail(integerNode, 232);
//        final var integerNode1 = Node.deleteTail(integerNode);
//        final var integerNode1 = Node.deleteHead(integerNode);
//        final var integerNode1 = Node.deleteKthElement(integerNode, 5);
//        Node.deleteNode(integerNode.getNext().getNext());

//        final var reverse = Node.reverse(integerNode);
        final var reverse = Node.reverseOptimized(integerNode);

        Node.print(reverse);
    }
}