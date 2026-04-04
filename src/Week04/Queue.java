package Week04;

import Week02.LinkedList;

public class Queue {

    private final LinkedList llist;
    public Queue()
    {
        llist=  new LinkedList();
    }

    /* Logically, using insertAtLast function in enqueue function, and using deleteLast function in dequeue function is correct.
    However, since deleteLast function must search from beginning to last node, it is more efficient to use this way(below) */
    public void enqueue(int data)
    {
        llist.insertAtLast(data);
    }

    public int dequeue()
    {
        return llist.deleteFirst();
    }

    public boolean isEmpty()
    {
        return llist.isEmpty();
    }

}
