import java.util.Scanner;

public class Menuuser { 
    public static void main(String[] args) {
        
    int ch;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your choice: " + "\n" + "1. Check Leap Year" + "\n" + "2. Calculate Average Marks" + "\n" + "3. Display Day of the Week" + "\n" + "4. Display Default Values of Data Types");
    ch = sc.nextInt();

    switch(ch) {
        case 1:
            Menuuser.checkLeapYear();
            break;
        case 2:
            Menuuser.calculateAverageMarks();
            break;
        case 3:
            Menuuser.displayDayOfWeek();
            break;
        case 4:
            Menuuser.displayDefaultValues();
            break;
        default:
            System.out.println("Invalid choice");
    }
}
    



    static void checkLeapYear() {
    int y = 1901;
    int leap_year = y % 4;

    if(leap_year==0) {
        System.out.println(y + " is a leap year");
    }
    else {
        System.out.println(y + " is not a leap year");
    }  
}

    static void calculateAverageMarks() {
    int math = 80;
        int science = 85;
        int history = 90;

        int avg = (math+science+history)/3;
        System.out.println("Average Marks: " + avg);

        if(avg>=90) {
            System.out.println("Grade A");
        }
        else if (avg<=89 && avg>=70) {
            System.out.println("Grade B");
        }
        else if (avg<=69 && avg>=50) {
            System.out.println("Grade C");
        }
        else if (avg<=49 && avg>=30) {
            System.out.println("Grade D");
        }
        else {
            System.out.println("Fail");
        }
    }

    static void displayDayOfWeek() {
        int day = 3;
        switch(day) {
            case 1: 
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default :
                System.out.println("Invalid choice");

        }
    }

    byte a;
    int b;
    short c;
    long d;
    float e;
    double f;
    char g;
    boolean h;
    static void displayDefaultValues() {
        
       Menuuser obj = new Menuuser();


       System.out.println("Default value of byte: " + obj.a);
       System.out.println("Default value of int: " + obj.b);    
       System.out.println("Default value of short: " + obj.c);
       System.out.println("Default value of long: " + obj.d);
       System.out.println("Default value of float: " + obj.e);
       System.out.println("Default value of double: " + obj.f);
       System.out.println("Default value of char: " + obj.g);
       System.out.println("Default value of boolean: " + obj.h);
}
}

