// Keira Wong
// CECS 274 - Prof. Gold
// Prog 5 - Crazy Train
// November 19th, 2019

import java.util.Scanner;
import java.util.ArrayList;

public class CrazyTrain
{
    public static void main(String[] args)
    {
        // START: Main Program

        // INITIALIZATION
        Scanner scan = new Scanner(System.in);
        boolean loop = true;

        while (loop == true)
        {
            // 3 Queues (Train A (startOrder), Train B (endOrder/target)
            // 1 Stack (Actual (result))
            ArrayList<Integer> trainA = new ArrayList<Integer>();
            ArrayList<Integer> copyOftrainA = new ArrayList<Integer>();
            ArrayList<Integer> trainB = new ArrayList<Integer>();
            ArrayList<Integer> actual = new ArrayList<Integer>();
            Stack myStack = new Stack();
            myStack.push(0); // so that comparison if statements are not out of bounds

            System.out.println("Welcome to the Crazy Train!");
            // User inputs # of Cars in Train A
            System.out.print("\t Enter the number of train cars: ");
            int numOfCars = scan.nextInt();
            if (numOfCars == 0)
            {
                System.out.println("Bye Bye");
                break;
            }
            // INPUT: starting config.
            System.out.print("\t Enter the order of the original in trainA: ");
            String startOrder = scan.next();
            // CONVERT: String -> int & Add to Queue ("trainA)
            // loop thru String ("startOrder")
            for (int i = 0; i < numOfCars; i++)
            {
                // save char at index (int i) as char (called "charNum")
                char charNum = startOrder.charAt(i);
                // convert char -> int (save as int called "intNum")
                int intNum = Character.getNumericValue(charNum); // 1 // 2 // 3
                // add intNum to Queue ("trainA")
                trainA.add(intNum);
                // add intNum to Queue ("copyOftrainA")
                copyOftrainA.add(intNum);
            }

            // INPUT: ending config.
            System.out.print("\t Enter the order of reconfiguration in trainB: ");
            String endOrder = scan.next();
            // CONVERT: String -> int & Add to Queue ("trainB")
            // loop thru String ("endOrder")
            for (int j = 0; j < numOfCars; j++)
            {
                // save char @ index (j) as cNum
                char cNum = endOrder.charAt(j);
                // convert char -> int (save int as "iNum")
                int iNum = Character.getNumericValue(cNum);
                // add iNum to Queue ("trainB")
                trainB.add(iNum);
            }

            // LOGIC:
            // if trainA's element != train B's element -> add trainA's element to Stack ("myStack")
            // if trainA's element == train B's element -> add to trainA's element to Queue ("actual")

            // loop thru Queue ("trainA")
            int a = 0;
            int nextB = 0;
            trainA.add(0); // for comparison if statements (so that it is not out of bounds)
            //for (int a = 0; trainA.size() > 0; a++) //&& nextB < trainA.size()-1 +1?
            while (trainA.size() > 0 && nextB < trainB.size()) // / trainA.size() > 1 && myStack.size() > 0
            {
                // if trainA's int == trainB's int
                if (trainA.get(a) == trainB.get(nextB))
                {
                    // add trainA's int to Queue ("actual")
                    actual.add(trainA.get(a));
                    trainA.remove(a);
                    nextB++;
                }
                // if trainA's int != trainB's int
                else if (trainA.get(a) != trainB.get(nextB))
                {
                    if (myStack.top() == trainB.get(nextB))
                    {
                        // add top of Stack ("myStack") to Queue ("actual") & // remove top from Stack ("myStack")
                        actual.add(myStack.pop());
                        nextB++;
                    }
                    else if (myStack.top() != trainB.get(nextB))
                    {
                        // add trainA's int to Stack ("myStack")
                        myStack.push(trainA.get(a));
                        // remove trainA's int from Queue ("trainA")
                        trainA.remove(a);
                    }
                }
            }
            if (actual.size() == numOfCars)
            {
                System.out.println("Smooth move - the reconfiguration is successful");
            }
            else {
                System.out.println("Bozo! You can't do that! Reconfiguration is impossible");
            }
            System.out.print("original (trainA)   : ");
            displayTrain(copyOftrainA);
            System.out.print("target (trainB) \t: ");
            displayTrain(trainB);
            System.out.print("actual  \t\t\t: ");
            displayTrain(actual);
            System.out.println();
        }
    }

    public static void displayTrain(ArrayList<Integer> train)
    {
        for(int trainCar = 0; trainCar < train.size(); trainCar++)
        {
            if (trainCar == train.size()-1)
            {
                System.out.println(train.get(trainCar));
            }
            else {
                System.out.print(train.get(trainCar) + "-");
            }
        }
    }
}
