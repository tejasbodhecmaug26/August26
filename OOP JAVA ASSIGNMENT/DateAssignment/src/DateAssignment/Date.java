package DateAssignment;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date() {
        System.out.println("Date Constructor");
    }

    // Setter
    public void setDate(int dd, int mm, int yy) {

        year = yy;

        if (mm < 1 || mm > 12)
            month = 1;
        else
            month = mm;

        int maxDays = getDaysInMonth(month, year);

        if (dd < 1 || dd > maxDays)
            day = 1;
        else
            day = dd;
    }

    // Add Days
    public void addDays(int days) {

        day = day + days;

        while (day > getDaysInMonth(month, year)) {

            day = day - getDaysInMonth(month, year);
            month++;

            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    // Add Months
    public void addMonths(int months) {

        month = month + months;

        while (month > 12) {
            month = month - 12;
            year++;
        }

        int maxDays = getDaysInMonth(month, year);

        if (day > maxDays)
            day = maxDays;
    }

    // Add Years
    public void addYears(int years) {

        year = year + years;

        int maxDays = getDaysInMonth(month, year);

        if (day > maxDays)
            day = maxDays;
    }

    // Find number of days in month
    private int getDaysInMonth(int mm, int yy) {

        if (mm == 1 || mm == 3 || mm == 5 ||
            mm == 7 || mm == 8 || mm == 10 || mm == 12) {

            return 31;
        }

        else if (mm == 4 || mm == 6 ||
                 mm == 9 || mm == 11) {

            return 30;
        }

        else {

            // February

            if ((yy % 400 == 0) ||
                (yy % 4 == 0 && yy % 100 != 0)) {

                return 29;
            }

            return 28;
        }
    }

    // Getters

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}