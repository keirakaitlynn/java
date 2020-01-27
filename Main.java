// Keira Wong
// Prog 3 - Linked Lists
// CECS 274
// October 15 2018

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
//        // TEST: Node class
//        Node first = new Node("cat"); // creates Node, 1
//        Node second = new Node("cat"); // creates Node, 2
//        Node front = first;
//        //
//        first.setValue("apple"); // sets int value of first
//        first.setNext(second); // sets next Node of first Node to second Node
//        //
//        first.getValue(); // gets int value of first node
//        first.getNext(); // gets next Node of first node
//        //
//        first.display(); // displays Node
//        first.getNext().display(); // displays value of next Node of node
//
//        // TEST: LinkedList class
//        LinkedList myList = new LinkedList();
//        myList.add("bats"); // CASE 1: add to empty list
//        myList.display(); // = 20
//        System.out.println("size: " + myList.size()); // = 1
//        myList.add("apps"); // CASE 2: add to front of existing list
//        myList.display(); // = 15 20
//        System.out.println("size: " + myList.size()); // = 2
//        myList.add("cats"); // CASE 3: add to back of existing list
//        myList.display();
//        System.out.println("size: " + myList.size()); // = 3
//        myList.add("asks"); // CASE 4: add to inside of existing list
//        myList.display();
//        System.out.println("size: " + myList.size()); // = 4

        // create new list called myList
        LinkedList myList = new LinkedList();
        // initialize scanner
        Scanner scan = new Scanner(System.in);

        // create 100 words
        for(int count = 0; count < 100; count++)
        {
            String word = createWord();
            myList.add(word);
        }

        //display LinkedList
        myList.display();
        //initialize
        String option = "";
        boolean ans = false;

        // prompt user, take in menu option
        while (ans == false)
        {
            System.out.println();
            System.out.println("(A)dd,(D)elete,(F)ind,(Q)uit List Size: " + (myList.size()));
            option = scan.next();

            if (option.equals("A"))
            {
                String word = createWord();
                myList.add(word);
                myList.display();
                System.out.println("\n" + word + " has been added at "+ myList.find(word));
            }
            else if (option.equals("D"))
            {
                Random rand = new Random();
                int location = rand.nextInt(myList.size());
                String word = myList.remove(location);
                myList.display();
                System.out.println("\n" + word + " has been removed from " + location);
            }
            else if (option.equals("F"))
            {
                String value = scan.next();
                int location = myList.find(value);

                if (location != 0)
                {
                    System.out.println("\n" + value + " is at " + location);
                }
                else
                {
                    System.out.println("\n" + value +" cannot be found!");
                }
            }
            else {
                ans = true;
            }
        }
    }

    public static String createWord()
    {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        Random rand = new Random();
        char a1 = letters[rand.nextInt(letters.length)];
        char a2 = vowels[rand.nextInt(vowels.length)];
        char a3 = letters[rand.nextInt(letters.length)];
        char a4 = letters[rand.nextInt(letters.length)];

        String result = "" + a1 + a2 + a3 + a4;
        return result;
    }
}

