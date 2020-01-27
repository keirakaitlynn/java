public class LinkedList
{
    private Node front;

    public LinkedList()
    {
        // initialize, create empty list
        front = null;
    }

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

    public void display()
    {
        // initialize
        int count = 0;
        Node curr = front;

        // loop thru all nodes in LinkedList
        while (curr != null)
        {
            // increment count
            count++;
            // display node
            curr.display();

            // if 12 nodes have been displayed, or you have reached the end of LinkedList
            if ( count % 12 == 0 || curr == null)
            {
                // create new row
                System.out.print("\n");
            }

            // set node to next node / increment node
            curr = curr.getNext();
        }
    }

    public int find (String word)
    {
        // initialize
        int count = 0;
        Node curr = front;
        boolean found = false;

        // loop thru all nodes in LinkedList
        while (curr != null)
        {
            //increment count
            count++;

            //compare word to each node
            if (word.equals(curr.getValue()))
            {
                found = true;
                break;
            }
            // set node to next node / increment node
            curr = curr.getNext();
        }
        // IF NOT FOUND: count = 0
        // IF FOUND: count = # of nodes looped thru till found word (aka location of word)
        return count;
    }

    public void add (String word)
    {
        Node given = new Node(word);

        // CASE 1: add to empty list
        if (front == null) // if empty
        {
            front = given; // set front Node to given Node
        }
        // CASE 2: add to front of existing list
        else if (front.getValue().compareTo(given.getValue()) > 0)
        // front.getValue().compareTo(given.getValue()) = 1 when given Node is to be placed before front Node
        // ie. given = "apps" & front = "bats"
        {
            // place given Node at front of existing list
            given.setNext(front);
            front = given;
        }
        // CASE 3 and CASE 4: add to back of existing list OR add to correct location of existing list
        else
        {
            // initialize
            Node curr = front;
            Node prev = null;

            // CASE 4
            // loop thru all nodes in LinkedList
            while (curr != null) //
            {
                // for each node,
                // if both given & curr Nodes are alphabetically ordered,
                // and the given Node comes before curr Node (-1)
                if (given.getValue().compareTo(curr.getValue()) < 0)
                {
                    given.setNext(curr);
                    prev.setNext(given);
                    break;
                }
                else
                {
                    prev = curr;
                    curr = curr.getNext();
                }
            }

            // CASE 3: add to back of existing list
            // if given Node is alphabetically after prev Node
            if (given.getValue().compareTo(prev.getValue()) > 0)
            {
                // set the next Node of prev Node to given Node
                prev.setNext(given);
            }
        }
    }

    public String remove (int value)
    {
        // initialize
        Node curr = front;
        Node prev = null;
        String remove = null;

        // loops until reached node located @ given value
        for (int count = 0; count < value - 1; count++)
        {
            // sets prev Node to curr Node
            prev = curr;
            // sets curr Node to the next node over
            curr = curr.getNext();
        }
        // sets "remove" String to the word located @ given value
        remove = curr.getValue();
        // removes word from LinkedList
        prev.setNext(curr.getNext());

        // returns String/word that was removed
        return remove;
    }

}
