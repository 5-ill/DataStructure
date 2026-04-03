package Week03;

import Week02.Node;
// You can just make new static node class inside the CircularLinkedList class

public class CircularLinkedList {

    private Node tail;
    private int size;

    public CircularLinkedList() {
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public int size() {
        return size;
    }

    public void insertAtFront(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            // The first node points to itself to create the circular structure.
            tail = newNode;
            newNode.next = newNode;
        } else {
            // Insert the new node between tail and the current head.
            newNode.next = tail.next;
            tail.next = newNode;
        }

        size++;
    }

    public void insertAtLast(int data) {
        // Reuse front insertion, then move tail to the newly added node.
        insertAtFront(data);
        /* Or you can just write code
        Node newNode = new Node(data);
        newNode.next = tail.next;
        tail.next = newNode; 
        size++;     
        */
        tail = tail.next;
    }

    public int deleteFirst() {
        if (isEmpty()) {
            return -1;
        }

        int deletedData = tail.next.data;
        // If list consists of only one node
        if (tail.next == tail) {
            tail = null;
        } else {
            // Skip the current head so the second node becomes the new head.
            tail.next = tail.next.next;
        }

        size--;
        return deletedData;
    }

    public int deleteLast() {
        if (isEmpty()) {
            return -1;
        }

        int deletedData = tail.data;
        // If list consists of only one node
        if (tail.next == tail) {
            tail = null;
            size--;
            return deletedData;
        }

        Node current = tail.next;
        while (current.next != tail) {
            // Move to the node just before tail.
            current = current.next;
        }

        // Link the new last node to head and update tail.
        current.next = tail.next;
        tail = current;
        size--;
        return deletedData;
    }

    public boolean search(int key) {
        if (isEmpty()) {
            return false;
        }

        Node current = tail.next;
        do {
            if (current.data == key) {
                return true;
            }
            // Continue until we return to the starting node.
            current = current.next;
        } while (current != tail.next);

        return false;
    }

    public int getFirst() {
        if (isEmpty()) {
            return -1;
        }
        return tail.next.data;
    }

    public int getLast() {
        if (isEmpty()) {
            return -1;
        }
        return tail.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node current = tail.next;
        do {
            System.out.print(current.data + " ");
            // Traverse once around the circular list.
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }
}
