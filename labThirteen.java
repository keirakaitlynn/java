import java.util.Scanner;

public class labThirteen {

    public static void main(String[] args) {

        // ASKS FOR USER INPUT:
        // creates new Scanner object, "scan"
        Scanner scan = new Scanner(System.in);
        // prompts user
        System.out.print("Please enter in the # of integers you'd like to enter: ");
        // saves user input as integer, "numInt"
        int numInt = scan.nextInt();
        // creates empty array, "numbers" (w/ its length determined by user input, "numInt")
        int[] numbers = new int[numInt];
        // prompts user
        System.out.println("Please enter " + numInt + " integers: ");

        // runs the following code a # of times, according to user input
        for (int i = 0; i < numInt; i++) {

            // saves user input as integer, "currNum"
            int currNum = scan.nextInt();
            // sets each of 5 elements in array, "numbers," to currNum
            numbers[i] = currNum;

        }

        // Calls method "isIncreasing," given array "numbers," & returns "true"/"false"
        if (isIncreasing(numbers)) {
            System.out.println("Those numbers" +
                    " are in increasing order");
        }
        else {
            System.out.println("Those numbers are not in increasing order");
        }

    }

    // Given an array ("numbers") of integers,
    // determines if each element in an array is ever not greater than prevNum
    // Returns false if numbers are not always increasing
    public static boolean isIncreasing(int[] numbers) {

        // INITIALIZATION
        int prevNum = 0;
        boolean isReallyIncreasing = true;

        // runs through each element in array "numbers"
        for (int i = 0; i < numbers.length; i++) {

            // determines if current # is greater than the previous #
            if (!(numbers[i] > prevNum)) {
                isReallyIncreasing = false;
            }

            // sets previous # to the current #
            prevNum = numbers[i];

        }

        return isReallyIncreasing;

    }

}
