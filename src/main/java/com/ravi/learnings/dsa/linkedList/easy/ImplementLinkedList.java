package com.ravi.learnings.dsa.linkedList.easy;

/**
 * Examples of liked list:
 * Music Application:
 * Allows easy next/previous song navigation, and you can insert or remove tracks dynamically.
 * <p>
 * Browser History Navigation:
 * Each webpage visit is a node. Going "Back" or "Forward" is like moving to the previous or next node in a
 * <p>
 * Text Editor like Notepad
 * Each state of the document can be a node. You can traverse back and forth easily to support undo/redo operations.
 * <p>
 * Types of Linked List:
 * Singly Linked Lists: In a singly linked list, each node points to the next node in the sequence.
 * Traversal is straightforward but limited to moving in one direction, from the head to the tail.
 * <p>
 * Doubly Linked Lists: In this each node points to both the next node and the previous node,
 * thus allowing it for bidirectional connectivity.
 * <p>
 * Circular Linked Lists: In a circular linked list, the last node points back to the head node, forming a closed loop.
 * DS Implemented using Linked list: Stack and Queue
 */
public class ImplementLinkedList {

    public static void main(String[] args) {
        MyNode myNode = new MyNode(2);
        MyNode firstNode = new MyNode(1, myNode);

        MyNode head = convertArrayToLL(new int[]{1, 2, 44, 4, 5, 6});
        printNodes(head);

        System.out.println("================");
        //        final var node = add(head, 22, 7);
        //        printNodes(node);

        //        final var node = MyNode.addBeforeValue(head, 22, 1);
        //        printNodes(node);

        //        final var myNode1 = MyNode.deleteHead(head);
        //        final var myNode1 = MyNode.deleteTail(head);
        //        final var myNode1 = MyNode.deleteKthElement(head, 1);
        //        final var myNode1 = MyNode.deleteDataNode(head, 6);
        final var idx = MyNode.getPosition(head, 6);
        System.out.println(idx);
    }

    private static void printNodes(final MyNode head) {
        var temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static MyNode convertArrayToLL(int[] arr) {
        final var myNode = new MyNode(arr[0]);
        var mover = myNode;

        for (int i = 1; i < arr.length; i++) {
            final var temp = new MyNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return myNode;
    }

    static class MyNode {
        int data;
        MyNode next;

        private MyNode(final int data, final MyNode next) {
            this.data = data;
            this.next = next;
        }

        private MyNode(final int data) {
            this.data = data;
        }

        public int size() {
            int count = 0;
            MyNode temp = this;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }

        public static int getPosition(MyNode head, int number) {
            MyNode temp = head;
            int idx = -1;
            int count = 1;
            while (temp != null) {
                if (temp.data == number) {
                    idx = count;
                }
                count++;
                temp = temp.next;
            }
            return idx;
        }

        private void add(final int i) {
            MyNode temp = this;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new MyNode(i);
        }

        public static MyNode add(final MyNode head, final int data, final int position) {

            //If we are adding element in LL where it is null
            if (head == null) {

                if (position == 1) {
                    return new MyNode(data);
                } else {
                    return head;
                }
            }

            // If we are adding element at first position then we need to just add head as next element
            if (position == 1) {
                return new MyNode(data, head);
            }

            int count = 1;
            var temp = head;

            while (temp != null) {

                if (count == position - 1) {
                    var next = temp.next;
                    temp.next = new MyNode(data, next);
                    break;
                }
                count++;
                temp = temp.next;
            }

            return head;
        }

        public static MyNode addBeforeValue(final MyNode head, final int data, final int beforeData) {

            //If we are adding element in LL where it is null
            if (head == null) {
                return new MyNode(data);
            }

            if (head.data == beforeData) {
                return new MyNode(data, head);
            }

            var temp = head;
            while (temp.next != null) {

                if (temp.next.data == beforeData) {
                    final var nextNode = temp.next;
                    final var myNode = new MyNode(data, nextNode);
                    temp.next = myNode;
                    return head;
                }

                temp = temp.next;
            }
            return head;
        }

        public static MyNode deleteHead(MyNode head) {
            if (head != null) {
                return head.next;
            }
            return null;
        }

        public static MyNode deleteTail(MyNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            var temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            return head;
        }

        /**
         * if  we have [9 4 5 3 8 10] and given 3 we need to delete element that is on 3rd place so this
         * should return [9 4 3 8 10]
         */
        public static MyNode deleteKthElement(MyNode head, int k) {
            if (head == null) {
                return null;
            }

            if (k == 1) {
                return head.next;
            }
            int count = 1;

            var temp = head;
            MyNode prev = null;
            while (temp != null) {

                if (count == k) {
                    prev.next = temp.next;
                    return head;
                }
                prev = temp;
                temp = temp.next;
                count++;
            }

            return head;
        }

        /**
         * if  we have [9 4 5 3 8 10] and given 3 we need to delete element that is on 3rd place so this
         * should return [9 4 3 8 10]
         */
        public static MyNode deleteDataNode(MyNode head, int data) {
            if (head == null) {
                return null;
            }

            if (head.data == data) {
                return head.next;
            }

            var temp = head;
            MyNode prev = null;
            while (temp != null) {

                if (temp.data == data) {
                    prev.next = temp.next;
                    return head;
                }
                prev = temp;
                temp = temp.next;
            }

            return head;
        }
    }
}


