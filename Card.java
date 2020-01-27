public class Card
{
    private char suit;
    private char rank;

    // takes in rank (r) & suit (s) of Card
    public Card(char r, char s)
    {
        // FILL IN
        rank = r;
        suit = s;
    }

    public void display()
    {
        // FILL IN
        String suitString = "";
        String rankString = "";
        char suit = getSuit();
        char rank = getRank();

        if (suit == 'S')
        {
            suitString = "S";
        }
        else if (suit == 'H')
        {
            suitString = "H";
        }
        else if (suit == 'C')
        {
            suitString = "C";
        }
        else if (suit == 'D')
        {
            suitString = "D";
        }
        if (rank == 'A')
        {
            rankString = "A";
        }
        else if (rank == '2')
        {
            rankString = "2";
        }
        else if (rank == '3')
        {
            rankString = "3";
        }
        else if (rank == '4')
        {
            rankString = "4";
        }
        else if (rank == '5')
        {
            rankString = "5";
        }
        else if (rank == '6')
        {
            rankString = "6";
        }
        else if (rank == '7')
        {
            rankString = "7";
        }
        else if (rank == '8')
        {
            rankString = "8";
        }
        else if (rank == '9')
        {
            rankString = "9";
        }
        else if (rank == 'T')
        {
            rankString = "10";
        }
        else if (rank == 'J')
        {
            rankString = "J";
        }
        else if (rank == 'Q')
        {
            rankString = "Q";
        }
        else if (rank == 'K')
        {
            rankString = "K";
        }

        System.out.print(rankString + suitString);

    }

    public int getValue()
    {
        int value = 0;
        char suit = getSuit();
        char rank = getRank();

        if (rank == 'A')
        {
            value = 1;
        }

        else if (rank == '2')
        {
            value = 2;
        }

        else if (rank == '3')
        {
            value = 3;
        }

        else if (rank == '4')
        {
            value = 4;
        }

        else if (rank == '5')
        {
            value = 5;
        }

        else if (rank == '6')
        {
            value = 6;
        }

        else if (rank == '7')
        {
            value = 7;
        }

        else if (rank == '8')
        {
            value = 8;
        }

        else if (rank == '9')
        {
            value = 9;
        }

        else if (rank == 'T')
        {
            value = 10;
        }

        else if (rank == 'J')
        {
            value = 10;
        }

        else if (rank == 'Q')
        {
            value = 10;
        }

        else if (rank == 'K')
        {
            value = 10;
        }

        return value;
    }

    public char getRank()
    {
        // FILL IN
        return rank;
    }

    public char getSuit()
    {
        // FILL IN
        return suit;
    }
}
