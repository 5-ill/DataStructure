package Week03;

public class DoubleLinkedList {

    private static class Node {
        int data;
        Node prev;
        Node next;

        // Constructor
        Node(int data) {
            this.data = data;
        }
    }

    // Three field vars
    private Node head;
    private Node tail;
    private int size;

    // constructor of DLL
    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Checking if DLL is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Return size of DLL
    public int size() {
        return size;
    }

    public void insertAtFront(int data) 
    {
        // Make a new node of data
        Node newNode = new Node(data);

        // If DLL is empty, head is newnode and tail is also newnode
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            
        } else {
            // Link the new node before the current head.
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            // Link the new node after the current tail.
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public int deleteFirst() {
        if (isEmpty()) {
            return -1;
        }

        int deletedData = head.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            // Move head forward and detach the old first node.
            head = head.next;
            head.prev = null;
        }

        size--;
        return deletedData;
    }

    public int deleteLast() {
        if (isEmpty()) {
            return -1;
        }

        int deletedData = tail.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            // Move tail backward and detach the old last node.
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return deletedData;
    }

    public boolean search(int key) {
        Node current = head;

        while (current != null) {
            if (current.data == key) {
                return true;
            }
            // Traverse forward through each node.
            current = current.next;
        }

        return false;
    }

    public int deleteByIndex(int index)
    {
        // I assumed that there is no negative index parameter given
        if(isEmpty())
        {
            return -1;
        }
        // if size-1 is smaller than index, return -1
        if(size - 1 < index)
            return -1;

        if (index == 0) {
            return deleteFirst();
        }

        if (index == size - 1) {
            return deleteLast();
        }

        Node current = head;
        int counter = 0;
        while (counter!=index)
        {
            current = current.next;
            counter++;
        }
        int deletedData = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current = null;
        size--;
        return deletedData;
    }

    public int deleteByValue(int value)
    {
       if(isEmpty())
        {
            return -1;
        }
        Node current = head;
        while (current != null && current.data != value)
        {
            current = current.next;
        }

        if (current == null) {
            return -1;
        }

        if (current == head) {
            return deleteFirst();
        }

        if (current == tail) {
            return deleteLast();
        }

        int deletedData = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current = null;
        size--;
        return deletedData;
    }


    public int getFirst() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public int getLast() {
        if (isEmpty()) {
            return -1;
        }
        return tail.data;
    }

    public void displayForward() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            // Move from head toward tail.
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        Node current = tail;

        while (current != null) {
            System.out.print(current.data + " ");
            // Move from tail toward head.
            current = current.prev;
        }
        System.out.println();
    }
}
