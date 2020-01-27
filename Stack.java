
// # of Cars in Station
// add to TOP

public class Stack
{
    private Node front;

    public Stack()
    {
        front = null;
    }

    // push object to top of the stack (adds object to top)
    public void push(int n)
    {
        // temp
        Node temp = new Node(n);
        // temp -> top
        temp.setNext(front);
        front = temp;
    }

    // returns value of top object
    public int top()
    {
        int temp = front.getValue();
        return temp;
    }

    // removes top object from Queue
    public int pop()
    {
        int temp = front.getValue();
        front = front.getNext();
        return temp;
    }

    // returns size of Stack
    public int size()
    {
        // initialize
        int count = 0;
        Node curr = front;

        // loop thru all nodes in LinkedList
        while (curr != null)
        {
            // for each node, add 1 to size (int called "count")
            count++;
            // set node to next node / increment node
            curr = curr.getNext();
        }
        // if empty, returns 0
        return count;

    }

    // If Queue is empty, returns true
    public boolean isEmpty()
    {
        boolean isEmpty = false;

        if (top() == 0)
        {
            isEmpty = true;
        }

        return isEmpty;
    }

    public void display()
    {
        Node curr = front;
        while (curr != null)
        {
            // display node
            System.out.print(curr.getValue() + "-");
            curr = curr.getNext();
        }
    }
}
