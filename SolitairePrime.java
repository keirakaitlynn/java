// Keira Wong
// 017675552
// CECS 274-05
// Prog 2 - Solitaire Prime
// 9/26/2019

import java.util.Scanner;

public class SolitairePrime
{
    public static void main(String[] args)
    {

        //Card C1 = new Card('T', 'S');
        //C1.display(); // Ten of Spades
        //System.out.println(C1.getValue()); // 10
        //System.out.println(C1.getRank()); // T
        //System.out.println(C1.getSuit()); // S

        // INITIALIZATION
        Scanner scan = new Scanner(System.in);
        Deck myDeck = new Deck();
        Card myCard;
        //Card myCard = new Card('T', 'H');
        boolean ans = true;

        while (ans)
        {
            // prompts user w/ menu every time
            int option = menu();

            if (option == 1) {
                myDeck = new Deck();
                System.out.println("New Deck!");
            } else if (option == 2) {
                // displays deck
                myDeck.display();
            } else if (option == 3) {
                myDeck.shuffle();
                System.out.println("Shuffled Deck!");
            } else if (option == 4) {
                // Solitaire Prime
                System.out.println("Play Solitaire Prime!");
                int sum = 0;
                int piles = 0;

                while (myDeck.cardsLeft() > 0)
                {
                    // DEALS 1st CARD in current DECK:
                    myCard = myDeck.deal();
                    // System.out.print("Cards Left: " + myDeck.cardsLeft() + " ");
                    myCard.display();
                    System.out.print(", ");

                    // sum = the curr sum + the value of card dealt
                    sum = sum + myCard.getValue();

                    if (isPrime(sum))
                    {
                        System.out.println("Prime: " + sum);
                        sum = 0;
                        piles++;
                    }
                }

                if (sum == 0)
                {
                    System.out.println();
                    System.out.println("Winner in " + piles + " piles!");
                }
                else{
                    System.out.println("Loser");
                }
            } else {
                // EXITS
                System.out.println("Goodbye!");
                ans = false;
            }
        }
        // TEST: isPrime()
        /*
        System.out.println("Enter in a number");
        int x = scan.nextInt();
        System.out.println(isPrime(x));
        */

    }

    // Returns the menu option selected
    public static int menu()
    {
        int option = 0;
        Scanner scan = new Scanner(System.in);

        while (option == 0)
        {
            System.out.println();
            // Prints Menu
            System.out.println("Welcome to Solitaire Prime!");
            System.out.println("1) New Deck");
            System.out.println("2) Display Deck");
            System.out.println("3) Shuffle Deck");
            System.out.println("4) Play Solitaire Prime!");
            System.out.println("5) Exit");
            option = scan.nextInt();

            // Validates User Input
            if (option < 1 | option > 5)
            {
                option = 0;
            }
        }
        return option;
    }

    // Determines if 'x' is prime
    public static boolean isPrime(int x)
    {
        boolean isPrime = true;
        int sqrt = (int) Math.sqrt(x) + 1;

        if (x == 1 | x == 2)
        {
            isPrime = false;
        }
        for(int i = 2; i < sqrt; i++)
        {
            if (x % i == 0)
            {
                isPrime = false;
            }
        }
        return isPrime;
    }
}