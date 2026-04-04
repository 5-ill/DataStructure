package Week04;

import Week02.LinkedList;

public class Queue {

    private final LinkedList llist;
    public Queue()
    {
        llist=  new LinkedList();
    }

    public void enqueue(int x)
    {
        llist.insertAtLast(x);
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
