public class Node
{
    private String word;
    private Node next;
    private Node prev;

    public Node (String w)
    {
        word = w;
        next = null;
    }

    void setValue (String w)
    {
        word = w;
    }

    public void setNext (Node node)
    {
        next = node;
    }

    public void setPrev (Node node)
    {
        prev = node;
    }

    public String getValue()
    {
        return word;
    }

    public Node getNext()
    {
        return next;
    }

    public Node getPrev()
    {
        return prev;
    }

    public void display ()
    {
        System.out.print(word + "\t");
    }
}
