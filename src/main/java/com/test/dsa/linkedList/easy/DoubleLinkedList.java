package com.test.dsa.linkedList.easy;

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
        final var integerNode1 = Node.deleteKthElement(integerNode, 5);

        Node.print(integerNode1);
    }
}

/// ading comment test 1
class Node<T> {
    private Node prev;
    private T data;
    private Node next;

    Node(final Node prev, final T data, final Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    Node(final T data) {
        this.data = data;
    }

    static Node<Integer> fromArray(int[] array) {
        Node head = new Node(null, array[0], null);
        Node prev = head;
        Node curr = null;
        for (int i = 1; i < array.length; i++) {
            curr = new Node(prev, array[i], null);
            prev.next = curr;

            prev = curr;
        }
        return head;
    }

    static <T> Node<T> insertHead(Node<T> head, T data) {
       if(head == null) {
           return new Node<>(data);
       }

        final var newNode = new Node<T>(null, data, null);
        newNode.next = head;
        return newNode;
    }

    static <T> Node<T> insertTail(Node<T> head, T data) {
        if(head == null) {
            return new Node<>(data);
        }

        var temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        final var newNode = new Node<T>(temp, data, null);
        temp.next = newNode;
        return head;
    }

    static <T> Node<T> insertBeforeTail(Node<T> head, T data) {
        if(head == null) {
            return new Node<>(data);
        }

        var temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        final var prev = temp.prev;
        final var newNode = new Node<T>(prev, data, temp);
        prev.next = newNode;
        temp.prev = newNode;
        return head;
    }

    static <T> Node<T> insertAtPosition(Node<T> head, T data, int position) {
        if(head == null) {
            return new Node<>(data);
        }

        if(position == 1) {
            return new Node<>(null, data, head);
        }

        Node<T> temp = head;
        int count = 1;
        while(temp != null) {

            if(count == position) {
                var prevNode = temp.prev;
                var newNode = new Node<T>(prevNode, data, temp);
                prevNode.next = newNode;
                temp.prev = newNode;
            }
            temp = temp.next;
            count++;
        }
        return head;
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    static <T> Node<T> insertAtValue(Node<T> head, T data, T value) {
        if(head == null) {
            return new Node<>(data);
        }

        if(head.data == value) {
            return new Node<>(null, data, head);
        }

        Node<T> temp = head;

        while(temp != null) {

            if(temp.data == value) {
                var prevNode = temp.prev;
                var newNode = new Node<T>(prevNode, data, temp);
                prevNode.next = newNode;
                temp.prev = newNode;
            }
            temp = temp.next;
        }
        return head;
    }

    static <T> Node<T> deleteTail(Node<T> head) {
        if(head == null) {
            return null;
        }
        var temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        final var prev = temp.prev;
        temp.prev = null;
        prev.next = null;

        return head;
    }

    static <T> Node<T> deleteHead(Node<T> head) {
        if(head == null) {
            return null;
        }

        var temp = head;
        head = temp.next;
        temp.next = null;
        head.prev = null;
        return head;
    }

    /**
     * Here we will delete the kth given element from the linked list
     * */
    static <T> Node<T> deleteKthElement(Node<T> head, int k) {
        if(head == null) {
            return null;
        }

        int count = 1;
        var temp = head;

        if(k == 1) {
            head = head.next;
            temp.next = null;
            return head;
        }

        while(temp != null) {

            if(count == k) {
                break;
            }
            temp = temp.next;
            count++;
        }

        if(count == k) {
            var prev = temp.prev;
            var next = temp.next;
            prev.next = next;
            if(next != null) {
                next.prev = prev;
            }

            temp.prev = null;
            temp.next = null;
        }

        return head;
    }
}