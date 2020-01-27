import java.util.Scanner;
import java.util.ArrayList;

public class HumanPyramid
{
    public static void main(String[] args)
    {
//        // TEST: Arrays
//        // creates array, "numbers"
//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//        // size of array, "numbers"
//        System.out.println("Size of ArrayList: " + numbers.size()); // 0
//        // add integers to array, "numbers"
//        numbers.add(1);
//        numbers.add(2);
//        // size of array, "numbers"
//        System.out.println("Size of ArrayList: " + numbers.size()); // 2
//        // display array, "numbers"
//        System.out.println("Numbers: " + numbers); // [1, 2]
//        // display 1st integer, "number"
//        System.out.println("Number: "+ numbers.get(0)); // 1

//        // TEST: weightOnBack()
//        System.out.println(weightOnBack(1, 1)); // 0
//        System.out.println(weightOnBack(2, 1)); // 75
//        System.out.println(weightOnBack(2, 2)); // 75

//        // TEST: menu
//        Scanner scan = new Scanner(System.in);
//        System.out.print("How tall is your pyramid? (Enter # of rows): ");
//        int numOfRows = scan.nextInt();
//        System.out.println();
//
//        // initializes an array list, "numbers"
//        ArrayList<Double> numbers = new ArrayList<Double>();
//        // adds weight of each person in pyramid (weightOnBack(row, col)) to array list, ("numbers")
//        for (int row = 1; row <= numOfRows; row++)
//        {
//            for (int col = 1; col <= row; col++)
//            {
////                // TEST: weightOnBack()
////                double weight = weightOnBack(row, col);
////                System.out.print(" " + weight);
//                numbers.add(weightOnBack(row, col));
//            }
//        }
////        System.out.println("Numbers: " + numbers); // ie. Numbers: [0.0, 75.0, 75.0, 112.5, 225.0, 112.5]
//
//        // TEST: printPyramid
//        printPyramid(numbers, numOfRows);
    }

    // given 2 ints ("row" & "col"), returns double ("weight")
    public static double weightOnBack (int row, int col)
    {
        // BASE CASE: first person @ top of pyramid -- unnecessary b/c already initialized
        if (row == 1) // (&& col == 1)
        {
            return 0;
        }
        // CASE 1: no one to the left of a person
        if (col == 1)
        {
            // (a person's weight + 1/2 the weight of 1 above, right)
            return (150 + weightOnBack(row - 1, col)) / 2;
        }
        // CASE 2: no one to the right of a person
        if (col == row)
        {
            // (a person's weight + 1/2 the weight of 1 above, left)
            return (150 + weightOnBack(row - 1, col - 1)) / 2;
        }
        // CASE 3: a person carries 2 people
        else {
            // (a person's weight + half the weight of 2 above, right & left)
            return 150 + (weightOnBack(row - 1, col) / 2) + (weightOnBack(row - 1, col - 1) / 2);
        }
    }

    // given array list of doubles ("numbers") & int ("numOfRows")
    public static void printPyramid (ArrayList numbers, int numOfRows)
    {
        // CONVERT ARRAY (Object -> double -> int)
        ArrayList<Integer> integers = new ArrayList<Integer>();
        int integer = 0;
        for (int index = 0; index < numbers.size(); index++)
        {
            double number = (double) numbers.get(index);
            integer = (int) number;
            integers.add(integer);
        }

        int index = 0;
        for (int row = 0; row < numOfRows; row++)
        {
            for (int a = 0; a <= numOfRows - row; a++)
            {
                System.out.print("   "); // 3 spaces
            }
            for (int col = 0; col <= row; col++)
            {
                // CALCULATE # of DIGITS of each "number"
                int number = integers.get(index);
                int numOfDigits = 0;
                if (number == 0)
                {
                    numOfDigits = 1;
                }
                while(number > 0)
                {
                    number = number / 10;
                    numOfDigits++;
                }
                //System.out.print(numOfDigits); // ie. (0 -> 1 digit, 75 -> 2 digits)

                // CALCULATE # of SPACES for each "number"
                //      * (max # of digits) = 4
                //      * if 1 digit -> add 3 spaces (4-1)
                //      * if 2 digits -> add 2 spaces (4-2)
                //      * if 3 digits -> add 1 spaces (4-3)
                //      * if 4 digits -> add 0 spaces (4-4)
                int numOfSpaces = 4 - numOfDigits;
                //System.out.print("# of Spaces: " + numOfSpaces);

                // PRINT 1 PYRAMID BLOCK for each "number
                System.out.print("(");
                for (int spaces = 0; spaces < numOfSpaces; spaces++)
                {
                    System.out.print(" ");
                }
                System.out.print(integers.get(index) + ")");

                // iterate onto next integer ("number") in array ("numbers")
                index++;
            }
            // create new row
            System.out.println();
        }
    }
}
