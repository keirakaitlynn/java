import java.util.Scanner;

public class homeworkFour {

    // METHODS ----------------------------------------------------------- //

    public static boolean isIncreasing(int[] numbers)
    {
        // INITIALIZATION
        int prevNum = 0;
        boolean isReallyIncreasing = true;

        // runs through each element in array "numbers"
        for (int i = 0; i < numbers.length; i++)
        {
            // determines if current # is greater than the previous #
            if (!(numbers[i] > prevNum))
            {
                isReallyIncreasing = false;
            }
            // sets previous # to the current #
            prevNum = numbers[i];
        }
        return isReallyIncreasing;
    }

    public static int getNumber()
    {
        // INITIALIZATION:
        int number = -1;

        // creates new Scanner object, "scan"
        Scanner scan = new Scanner(System.in);

        // ASKS FOR USER INPUT:
        while (number <= 0)
        {
            // prompts user
            System.out.print("Enter a positive number: ");
            // saves user input as integer, "number"
            number = scan.nextInt();
        }
        return number;
    }

    public static int[] getDigits(int number)
    {
        // creates an array "numbers"
        int[] numbers = new int[3];
        // runs the following code a # of times, according to user input
        for (int i = 0; i < numInt; i++)
        {
            // saves user input as integer, "currNum"
            int currNum = scan.nextInt();
            // sets each of 5 elements in array, "numbers," to currNum
            numbers[i] = currNum;
        }
        return numbers
    }

    // ------------------------------------------------------------------- //

    // MAIN -------------------------------------------------------------- //

    public static void main(String[] args)
    {
        // TEST: getNumber()
        System.out.println(getNumber());
    }
}
