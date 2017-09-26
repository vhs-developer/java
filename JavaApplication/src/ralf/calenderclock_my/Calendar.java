package ralf.calenderclock_my;

/**
 *
 * @author ralf
 */
public class Calendar {
    /**
     * daysPerMonth ist eine Klassenvariable (static)
     */
    public static int[] daysPerMonth = new int[] {-1, 31, 28, 31, 30, 31, 30 , 31, 31, 30, 31, 30, 31};
    
    private int year;
    private int month;
    private int day;

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    /**
     * Konstruktormethode für die Klasse Calendar
     * @param year
     * @param month
     * @param day 
     */
    public Calendar(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public static void main(String[] args) { // Template: "psvm"
        Calendar calendar = new Calendar(2017, 9 , 30);
        
        calendar.nextDay();
        System.out.println(calendar); // Template: "sout"
        calendar.nextDay();
        System.out.println(calendar.toString());
    }

    @Override
    public String toString() {
        return "Calendar{" + "year=" + year + ", month=" + month + ", day=" + day + '}';
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    /**
     * wechselt zum nächsten Tag
     */
    public void nextDay() {
        day++;
        if (isLeapYear(year))
            daysPerMonth[2] = 29;
        else
            daysPerMonth[2] = 28;
        
        if (day > daysPerMonth[month]) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                   year++;
            }
        }
    }
           
}
