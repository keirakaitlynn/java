import java.util.Random;

public class Deck
{
    private Card [] storage; // make an array of cards
    private int top; // the next card to deal
    private int cardsUsed;

    public Deck()
    {
        // initializes an array of characters for each attribute of a card (suits & ranks)
        char[] suits = {'H', 'D', 'S', 'C'};
        char[] ranks = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
        // sets storage size to 52
        storage = new Card[52];
        top = 0; // the top card in the deck
        int count = 0;

        for (int s = 0; s < suits.length; s++)
        {
            for (int r = 0; r < ranks.length; r++)
            {
                // each element in "storage" = a Card (in the form {'A', 'S'}
                storage[count++] = new Card(ranks[r], suits[s]);
            }
        }
        cardsUsed = 0;
    }

    public void display()
    {
        // FILL IN
        // AH 2H 3H ... KH
        // AS 2H 3S ... KS
        // AD 2D 3D ... KD
        // AC 2C 3C ... KC

        //char[]suits = {'H', 'D', 'S', 'C'};
        //char[]ranks = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
        int i = 0;

        // four rows
        for(int row = 0; row < 4; row++)
        {
            // 13 columns
            for(int col = 0; col < 13; col++)
            {
                // in each column, prints out the card & its attributes (ie. "AS ")
                // finds the rank and suit of each card in the deck / storage
                storage[i].display(); //1storage[i].display() + " ");
                System.out.print(" ");
                i++;
            }
            System.out.println();
        }

    }

    public void shuffle()
    {
        // FILL IN - use Random()
        Random rand = new Random();

        // switches 2 cards x & y 1000 times
        for (int i = 0; i <= 1000; i++)
        {
            // (the indexes of card 1 (x) & card 2 (y) in a deck are set to a random integer <= 52)
            // card 1
            int x = rand.nextInt(52);
            // card 2
            int y = rand.nextInt(52);
            // temp to switch:
            // emptied...
            Card temp = storage[x];
            // cards switched...
            storage[x] = storage[y];
            storage[y] = temp;
        }

    }

    public Card deal()
    {
        // FILL IN
        // Card temp = storage[top++];

        // current length of deck - 1
        cardsUsed++;
        // returns storage[top] & then top increments,
        // returns the card @ the top of deck
        return storage[top++];
    }

    public int cardsLeft() // how any cards are left in the deck
    {
        // FILL IN
        // keeps track of how many cards left in the deck by subtracting cardsUsed (cards dealt), from the length of a deck (52)
        return storage.length - cardsUsed;
    }

}
