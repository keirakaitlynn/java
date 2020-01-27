// Keira Wong
// CECS 274-05
// Prog 0 - Happy Birthday
// Aug 29, 2019

// imports scanner/input
import java.util.Scanner;

// must match
public class birthday
{
    // psvm
    public static void main(String[] args)
    {
        // creates new scanner called "in"
        Scanner in = new Scanner(System.in);
        // Initialization:
        String name;
        String reply;
        int age;
        int birthYear;
        char thisYear;

        // asks user for name
        System.out.print("What is your name?");
        // allows for user to input name, saves input as variable "name"
        name = in.next();
        // asks user age
        System.out.print("How old are you " + name + "? ");
        // saves user input as "age"
        age = in.nextInt();
        // asks if birthday is past
        System.out.print(name + ", have you had your birthday yet this year? (y/n)");
        // saves user input as "reply"
        reply = in.next();
        // saves the first character of "reply" as "thisYear"
        thisYear = reply.charAt(0);

        // if birthday is past, subtracts age from 2019 "birthYear"
        if (thisYear == 'y' || thisYear == 'Y')
            birthYear = 2019 - age;
        else
            // if birthday has not past, subtracts (age + 1) from 2019, saves as "birthYear"
            birthYear = 2019 - age - 1;
        // prints birthYear
        System.out.println("I guess that you were born in " + birthYear);
    }
}
