//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.Scanner;
//import java.util.TimeZone;

public class Lab1Marathon
{
    // METHODS
    public static void printTable(double pace, String name)
    {
        int pMin = (int) pace;
        int pSec = (int) ((pace - pMin) * 60);

        // Convert Pace (in Mins) --> Marathon time (in Mins)
        final int YARDSPERMILE = 1760;
        final int YARDSPERMARATHON = (YARDSPERMILE * 26) + 385; // 46145
        double totalMinutes = ((pace / YARDSPERMILE) * YARDSPERMARATHON); // 232.5xxx

        // Convert Marathon time (in Mins) --> Hours, Minutes, & Seconds:
        int t = (int) ( totalMinutes * 60);

        int hour = t / 3600;
        t %= 3600;
        int min = t / 60;
        t %= 60;
        int sec = t;

        // Format (every % is replaced w/ variable. 0 means to add 0's in front if 0 or 1 digit
        System.out.printf("%d:%02d\t%d:%02d:%02d\t%s", pMin, pSec, hour, min, sec, name);
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        // USER PROMPT & Initialization
        System.out.print("What is your first name? ");
        String name = scan.next();
        System.out.print("How far did you run today? ");
        double distance = scan.nextDouble();
        System.out.print("How long did it take? hours: ");
        int hours = scan.nextInt();
        System.out.print("\t\t\t\t\t  minutes: ");
        int mins = scan.nextInt();
        System.out.print("\t\t\t\t\t  seconds: ");
        int secs = scan.nextInt();

        // CONVERSIONS

        // Time in Total:
        int timeInSecs = (hours * 60 * 60) + (mins * 60) + secs; // 5657
        int timeInMins = (timeInSecs / 60); // 94

        // Pace:
        double paceInSecs = (timeInSecs / distance); // 533.679
        double paceInMins = timeInMins / distance; // 8.89465

        // Separate each unit of time of Pace:
        int paceJustMins = (int) (paceInMins); // 8
        // takes decimal part of double, "paceInMins" & converts to seconds, ALSO converts to int (gets rid of remainder)
        int paceJustSecs = (int) ((paceInMins - paceJustMins) * 60); // 52

        // Convert Pace (in Mins) --> Marathon time (in Mins)
        final int YARDSPERMILE = 1760;
        final int YARDSPERMARATHON = (YARDSPERMILE * 26) + 385; // 46145
        double totalMinutes = ((paceInMins / YARDSPERMILE) * YARDSPERMARATHON); // 232.5xxx

        // Convert Marathon time (in Mins) --> Hours, Minutes, & Seconds:
        int t = (int) ( totalMinutes * 60);
        int hour = t / 3600;
        t %= 3600;
        int min = t / 60;
        t %= 60;
        int sec = t;

        // OUTPUT
        System.out.println("\nHi " + name + ",");
        System.out.print("Your pace is ");
        System.out.printf("%d:%02d", paceJustMins, paceJustSecs);
        System.out.println();
        System.out.print("At this rate your marathon time would be ");
        System.out.printf("%d:%02d:%02d", hour, min, sec);
        System.out.println("\n\nGood luck with your training!");
        System.out.println();
        System.out.println("Pace Table");
        System.out.println("Pace\t" + "Marathon");
        // TABLE
        double pace = (4 + (37 / 60.0));
        String recName = "<--- Eliud Kipchoge";
        while (pace < paceInMins)
        {
            printTable(pace, recName);
            recName = "";
            pace += (40 / 60.0); // difference between each entry, converted sec --> min
        }
        recName = "<--- " + name;
        printTable(paceInMins, recName);

        /*
        // QUESTIONS:
        1) Are we allowed to use String.format / Are we supposed to use String.format?
        2) How would we loop/feed multiple values into String.format function?
        3) Can we just use ":" / strings?
        */

    }
}
