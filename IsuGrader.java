import java.util.Scanner;

public class IsuGrader {

    public static void main(String[] args) {

        // INITIALIZATION:
        double highestScore = 0;
        double lowestScore = 10;
        double sum = 0;

        // runs the following code 9 times (bc 9 judges)
        for (int i = 1; i <= 9; i++) {

            // INITIALIZATION:
            double scoreJudge = -1;
            boolean scoreJudgeValid = false;

            // asks for user input, "scoreJudge" again if not between 0 and 10
            while (!scoreJudgeValid) {

                // ASKS FOR USER INPUT:
                // creates new Scanner object, "scan"
                Scanner scan = new Scanner(System.in);
                // prompts user
                System.out.print("Please enter judge #" + i + "'s score: ");
                // saves user input as variable, "scoreJudge"
                scoreJudge = scan.nextDouble();
                // validates user input
                if (scoreJudge >= 0 & scoreJudge <= 10) {
                    scoreJudgeValid = true;
                }
                // TEST: System.out.println(scoreJudge);

            }

            // saves highest value of "scoreJudge" as "highestScore"
            if (scoreJudge >= highestScore) {
                highestScore = scoreJudge;
            }
            // TEST: System.out.println(highestScore);

            // saves lowest value of "scoreJudge" as "lowestScore"
            if (scoreJudge <= lowestScore) {
                lowestScore = scoreJudge;
            }
            // TEST: System.out.println(lowestScore);

            // CALCULATIONS:
            // sum = each user input, "scoreJudge" added up
            sum = sum + scoreJudge;
            // TEST: System.out.println(sum);

        }

        double finalScore = (sum - (highestScore + lowestScore))/7;
        System.out.println("Your final score is " + finalScore);

    }

}
