package Week04;

import Week02.LinkedList;


public class Stack {

    private final LinkedList llist;
    public Stack()
    {
        llist = new LinkedList();
    }

    public void push(int data)
    {
        llist.insertAtFirst(data);
    }
    public int pop()
    {
        return llist.deleteFirst();
    }

    public boolean isEmpty()
    {
        return llist.isEmpty();
    }
    
}
