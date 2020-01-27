import java.util.ArrayList;

public class BST
{
    // embedded class ("Node")
    private class Node
    {
        private int value;
        private Node left;
        private Node right;

        public Node (int x)
        {
            value = x;
            left = null;
            right = null;
        }

        public int getValue()
        {
            return value;
        }

        public Node getLeft()
        {
            return left;
        }

        public Node getRight()
        {
            return right;
        }
    }
    // end of class ("Node")

    private Node root; // root of the tree

    // Initialize Object
    public BST()
    {
        root = null;
    }

    // Return value of the root (of entire tree)
    public Node getRoot() // int
    {
        return root;
        //.getValue();
    }

    // Return value of the root (of entire tree)
    public int getRootValue()
    {
        return root.getValue();
    }

    // Return # of items in tree
    public int getCount()
    {
        return getCount(root);
    }
    // # of items in subtree
    private int getCount(Node N)
    {
        // if tree is empty, returns 0
        // else..
        if (N == null)
        {
            return 0;
        }
        else
        {
            return 1 + getCount(N.right) + getCount(N.left);
        }
    }

    /*// Return level of given number (x) in tree
    public int findLevel(int x)
    {
        return findLevel(root, x, 1);
    }
    // level of given number (x) in subtree (N)
    private int findLevel(Node N, int x, int level)
    {
        Node N = this;
        while (N != null && N.parent != null)
        {
            level++;
            N = N.parent;
        }
        return level;
    }*/

    // add integer (x) to tree
    public void add(int x)
    {
        if (root == null)
        {
            root = new Node(x);
        }nm
        else {
            add(root, x);
        }
    }
    // add node (N) to subtree (P)
    private boolean add(Node N, int x)
    {
        boolean result = false;

        if (x == N.value)
        {
            return false;
        }
        else {
            if (x < N.value)
            {
                if (N.left == null)
                {
                    N.left = new Node(x);
                    //result = true;
                }
                else {
                    add(N.left, x);
                }
            }
            else {
                if (N.right == null)
                {
                    N.right = new Node(x);
                }
                else {
                    add(N.right, x);
                }
            }
            return true;
        }
    }

    // print contents of tree (in order)
    public void print()
    {
        print(root);
    }
    // print contents of subtree (N) (in order)
    private void print(Node N)
    {
        if (N == null)
        {
            return;
        }
        else {
            print(N.left);
            System.out.print(N.value + ", ");
            print(N.right);
        }
    }

    // Return the # of levels of tree
    public int getHeight()
    {
        return getHeight(root);
    }
    // Return the # of levels of subtree (N)
    private int getHeight(Node N)
    {
        if (N == null)
        {
            return 0;
        }
        else {
            return ( 1  + Math.max( getHeight(N.left), getHeight(N.right)) );
        }
    }

    // remove given number from tree
    public boolean remove(int x)
    {
        return remove(root, x);
    }

    // ** Helper function to find min. value Node in subtree (rooted at given Node (curr))
    private Node minimumKey(Node curr)
    {
        while (curr.left != null)
        {
            curr = curr.left;
        }
        return curr;
    }

    // remove given number from subtree (N)
    private boolean remove(Node root, int key)
    {
        // pointer to store parent node of current node
        Node parent = null;

        // start w/ root node
        Node curr = root;

        // search key in BST and set its parent pointer
        while (curr != null && curr.value != key)
        {
            // update parent node as current node
            parent = curr;

            // if given key is less than curr node, go to left subtree
            // else go to right subtree
            if (key < curr.value)
            {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }

        // return if key is not found in the tree
        if (curr == null)
        {
            return false;
        }

        // CASE 1: node to be deleted has no children (ie. it is a leaf node)
        if (curr.left == null && curr.right == null)
        {
            // if node to be deleted is not a root node,
            // then set its parent left/right child to null
            if (curr != root)
            {
                if (parent.left == curr)
                {
                    parent.left = null;
                }
                else {
                    parent.right = null;
                }
            }
            // if tree has only root node, delete it and set root to null
            else {
                root = null;
            }
        }

        // CASE 2: node to be deleted has 2 children
        else if (curr.left != null && curr.right != null) {

            // find its in-order successor node
            Node successor = minimumKey(curr.right);

            // store successor value
            int val = successor.value;

            // recursively delete the successor
            // NOTE: the successor wil have at most 1 child (right child)
            remove(root, successor.value);

            // Copy the value of successor to curr node
            curr.value = val;
        }

        // CASE 3: node to be deleted has only 1 child
        else {

            // find child node
            Node child = (curr.left != null)? curr.left: curr.right;

            // if node to be deleted is not a root node,
            // then set its parent to its child
            if (curr != root)
            {
                if (curr == parent.left)
                {
                    parent.left = child;
                }
                else {
                    parent.right = child;
                }
            }
            // if node to be deleted is root node, then set the root to child
            else {
                root = child;
            }
        }

        return true;
    }

    // display top 5 levels of tree
    public void display()
    {
        String [] A = new String[32];
        for (int i = 0; i < 32; i++)
        {
            A[i] = " . ";
        }
        String temp;
        if (root == null)
        {
            temp = " . ";
        }
        else {
            temp = Integer.toString(root.value);
        }
        A[1] = temp;

        buildArray(root, A, 1);

        System.out.println("                                                                                    ");
        System.out.println("                                                   "+A[1]+"                             ");
        System.out.println("                                                    |                                   ");
        System.out.println("                       "+A[2]+"--------------------------^--------------------------"+A[3]);
        System.out.println("                        |                                                       |    ");
        System.out.println("         "+A[4]+"------------^------------"+A[5]+"                         "+A[6]+"------------^------------"+A[7]);
        System.out.println("          |                           |                           |                           |");
        System.out.println("   "+A[8]+"----^----"+A[9]+"             "+A[10]+"----^----"+A[11]+"             "+A[12]+"----^----"+A[13]+"             "+A[14]+"----^----"+A[15]);
        System.out.println("    |           |               |           |               |           |               |           |");
        System.out.println(A[16]+"-^-"+A[17]+"   "+A[18]+"-^-"+A[19]+"       "+A[20]+"-^-"+A[21]+"   "+A[22]+"-^-"+A[23]+"       "+A[24]+"-^-"+A[25]+"   "+A[26]+"-^-"+A[27]+"       "+A[28]+"-^-"+A[29]+"   "+A[30]+"-^-"+A[31]);
        System.out.println("                                                                                         ");
    }

    private void buildArray(Node n, String [] strArray, int parentIndex)
    {
        if (parentIndex * 2 + 1 > strArray.length)
        {
            return;
        }
        if (n == null)
        {
            return;
        }
        else {
            String temp;
            if (n.left == null)
            {
                temp = " . ";
            }
            else {
                temp = Integer.toString(n.left.value);
            }

            strArray[parentIndex*2] = String.format("%3s", temp);
            buildArray(n.left, strArray, parentIndex*2);

            if (n.right == null)
            {
                temp = " . ";
            }
            else {
                temp = Integer.toString(n.right.value);
            }

            strArray[parentIndex*2+1] = String.format("%3s", temp);
            buildArray(n.right, strArray, parentIndex*2+1);
        }
    }
}
