public class intToArray {
    public int[] intToArray(int number)
    {
        int i = 0;
        int numLength = (int) Math.log10(number);
        int divisor = (int) Math.pow(10, numLength);
        int numbers[] = new int[numLength +1];
        while (number != 0)
        {
            numbers[i] = number / divisor;
            if (i < numLength)
            {
                i++;
            }
            number = number % divisor;
            if (i != 0)
            {
                divisor = divisor / 10;
            }
        }
        return numbers;
    }
}

/*        // takes log of int, "number," and adds one to it to find its length, "numLength"
        int numLength = (int) (Math.log10(number) + 1);
        System.out.println(numLength);
        // creates an array "numbers" w/ a length (equal to the length of the given int, "numLength")
        int[] numbers = new int[numLength];

        // runs the following code a # of times, according to numLength
        for (int i = 0; i < numLength; i++)
        {
            // first digit of int "number"
            if (number > 9)
            {
                numbers[i] = number / 10;
                System.out.println(numbers[i]);
            }
        }


        /*
        // creates new Scanner object, "scan"
        Scanner scan = new Scanner(System.in);
        // runs the following code a # of times, according to numLength
        for (int i = 0; i < numLength; i++)
        {
            // saves user input as integer, "currNum"
            int currNum = scan.nextInt();
            // sets each of 5 elements in array, "numbers," to currNum
            numbers[i] = currNum;
        }
*/

