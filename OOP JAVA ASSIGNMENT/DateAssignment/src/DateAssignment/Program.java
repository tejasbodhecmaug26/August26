package DateAssignment;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Date objDate = new Date();

        int choice;

        do {

            System.out.println("\n-----------------------------");
            System.out.println("          Date Menu");
            System.out.println("-----------------------------");
            System.out.println("1. Set Date");
            System.out.println("2. Add Days");
            System.out.println("3. Add Months");
            System.out.println("4. Add Years");
            System.out.println("5. Display");
            System.out.println("6. Compare Dates");
            System.out.println("7. Exit");
            System.out.println("-----------------------------");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter day: ");
                int dd = sc.nextInt();

                System.out.print("Enter month: ");
                int mm = sc.nextInt();

                System.out.print("Enter year: ");
                int yy = sc.nextInt();

                objDate.setDate(dd, mm, yy);

                break;

            case 2:

                System.out.print("Enter number of days: ");
                int days = sc.nextInt();

                objDate.addDays(days);

                break;

            case 3:

                System.out.print("Enter number of months: ");
                int months = sc.nextInt();

                objDate.addMonths(months);

                break;

            case 4:

                System.out.print("Enter number of years: ");
                int years = sc.nextInt();

                objDate.addYears(years);

                break;

            case 5:

                System.out.println(
                    "Date: "
                    + objDate.getDay() + "/"
                    + objDate.getMonth() + "/"
                    + objDate.getYear()
                );

                break;

            case 6:

                System.out.println("Compare Dates (Not Implemented)");

                break;

            case 7:

                System.out.println("Exiting...");

                break;

            default:

                System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}