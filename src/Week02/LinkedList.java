package Week02;
// No importing allowed in this lecture
// E.g.) import java.util.*;
// Works with Node.java
public class LinkedList {
    public Node first;

    // Constructor
    public LinkedList()
    {
        // Empty LinkedList
        first = null;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtFirst(3);
        ll.insertAtFirst(2);
        ll.insertAtFirst(2);
        ll.insertAtFirst(2);
        ll.insertAtFirst(2);
        ll.insertAtFirst(2);
        ll.insertAtFirst(7);
        ll.deleteFirst();
        ll.insertAtLast(8);
        ll.insertAtLast(1);
        ll.displayAll();


    }
    // Checking if LinkedList is empty
    public boolean isEmpty()
    {
        return (first==null);
    }

    // Add new Node at the first
    // Works even when list is empty
    public void insertAtFirst(int data)
    {
        // Make new node in memory
        Node node = new Node(data);
        // Make new node's next points to first
        node.next = first;
        // Then make first points to new node
        first = node;
    }
    // Remove the first node and return the value
    public int deleteFirst()
    {
        int retVal;
        // If list is empty, return -1 to prevent exception
        if (isEmpty())
            return -1;
        else
        {
            retVal = first.data;
            // Make first points to next node
            first = first.next;
            return retVal;
        }
    }
    // Display all the value
    public void displayAll()
    {
        Node cur;
        for (cur=first; cur!=null; cur = cur.next)
        {
            System.out.println(cur.data);
        }

    }
    public void insertAtLast(int data)
    {
        Node cur = first;
        Node node = new Node(data);
        node.next = null;
        while (cur.next != null)
        {
            cur = cur.next;
        }
        cur.next = node;
    }





}


