
// (a) # of Cars in Train A
// (b) # of Cars in Tran B

// add to BACK

public class Queue
{
    private Node first;
    private Node last;
    private int numOfCars;

    public Queue ()
    {
        first = null;
        last = null;
        numOfCars = 0;
    }

    // return value of first element
    public int first()
    {
        return first.getValue();
    }

    // remove first element
    public void removeFirst()
    {
        Node curr = first;
        Node prev = null;

        if (curr != null)
        {
            prev = curr;
            curr = curr.getNext();
            prev.setNext(curr.getNext());
            //int temp = first.getValue();
            //first = first.getNext();
        }
    }

    // add to the end of a queue
    public void add (int n)
    {
        Node given = new Node(n);
        Node curr = first;
        Node prev = null;

        // CASE 1: add to empty list
        if (curr == null)
        {
            curr = given;
        }
        else {
            while (curr != null)
            {
                prev = curr;
                curr = curr.getNext();
                if (curr == null)
                {
                    System.out.println("NULL");
                    prev.setNext(given);
                }
            }
        }
    }

    public void display()
    {
        Node curr = first;
        while (curr != null)
        {
            // display node
            curr.display();
            curr = curr.getNext();
        }
    }

}
