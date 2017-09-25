package Tom;

/**
 *
 * @author kubuntu
 */
public class Calendar {
    /**
     * daysPerMonth ist eine Klassenvariable (static),
     * also für alle Objekte einmal definiert und nicht unterschiedlich
     */
    public static int[] daysPerMonth = new int[] {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    /**
     * isLeapYear ist eine Klassenmethode (static), i.e. eine "Bibliotheksmethode
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    
    private int year;
    private int month;
    private int day;

    /**
     * Eine Konstruktormethode für die Klasse Calendar
     * @param year
     * @param month
     * @param day 
     */
    public Calendar(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    /**
     * wechselt zum nächsten Tag
     */
    public void nextDay() {
        int days = Calendar.daysPerMonth[this.month];
        // int days = daysPerMonth[month];
        
        if (this.month == 2 && Calendar.isLeapYear(this.year)) {
            days++;
        }
    
        day++;
        if (day > days) {
            day = 1;
            month++;
            if (month > 12) {
                    month = 1;
                    year++;
            }
        }
    }

    @Override
    public String toString() {
        return "Calendar{" + "year=" + year + ", month=" + month + ", day=" + day + '}';
    }

    public static void main(String[] args) {
        Calendar calendar = new Calendar(2016,2,28);
        System.out.println("aktueller Tag: " + calendar);
        calendar.nextDay();
        System.out.println("nächster Tag:  " + calendar);
    }
}

