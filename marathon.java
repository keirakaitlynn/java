import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class marathon
{
    public void printTable(double pace, String name)
    {
        int pMin = (int) pace;
        int pSec = (int) ((pace - pMin) * 60);
        int mH = ;
        int mM;
        int mS;
        System.out.println("%d:%02d\t %d:%02d:%02d\t %s", pMin, pSec, mH, mM, mS, name);
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        // USER PROMPT & Initialization
        System.out.print("What is your first name? ");
        String name = scan.next();
        System.out.println("How far did you run today? ");
        double distance = scan.nextDouble();
        System.out.println("How long did it take? hours: ");
        int hours = scan.nextInt();
        System.out.print("minutes: ");
        int mins = scan.nextInt();
        System.out.print("seconds: ");
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
        int paceJustSecs = (int) ((paceInMins - (int) (paceInMins)) * 60); // 52

        // Convert Pace (in Mins) --> Marathon time (in Mins)
        final int YARDSPERMILE = 1760;
        final int YARDSPERMARATHON = (YARDSPERMILE * 26) + 385; // 46145
        double totalMinutes = ((paceInMins / YARDSPERMILE) * YARDSPERMARATHON); // 232.5xxx

        // Convert Marathon time (in Mins) --> Hours, Minutes, & Seconds:
        int t = (int) ( totalMinutes * 60);
        int hour = t / 3600;
        System.out.println("Hours " + hour);
        t %= 3600;
        System.out.println("t = " + t);
        int min = t / 60;
        System.out.println("t = " + t);
        System.out.println("Minutes " + min);
        t %= 60;
        System.out.println("t = " + t);
        int sec = t;
        System.out.println("Seconds " + sec);

        /*

        // Alternative Formatting Method:
        long timeInMilliSeconds = (long) Math.floor(timeInMinutes * 60 * 1000);
        System.out.println(timeInMilliSeconds);
        Date date = new Date(timeInMilliSeconds);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(sdf.format(date));

        */


        // OUTPUT
        System.out.println("Hi " + name + ",");
        System.out.println("Your pace is " + (paceJustMins) + ":" + (paceJustSecs));
        System.out.println("At this rate your marathon time would be " + hour + ":" + min + ":" + sec);
        //NOTESSSS///////////////////////
        double pace;
        /////////////////////////////////
        System.out.println("Good luck with your training!");

        /*
        // QUESTIONS:
        1) Are we allowed to use String.format / Are we supposed to use String.format?
        2) How would we loop/feed multiple values into String.format function?
        3) Can we just use ":" / strings?
        */

    }
}
