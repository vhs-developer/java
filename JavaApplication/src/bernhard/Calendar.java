package bernhard;
import java.util.logging.Logger;

/**
 *
 * @author bernhard
 */
public class Calendar {
    /**
     * days per month inst eine Klassenvariable (static).
     */
    public  static int[] daysPerMonth = new int [] {-1, 31,28,31,30,31,30,31,31,30,31,30,31};

    @Override
    public String toString() {
        return "Calendar{" + "year=" + year + ", month=" + month + ", day=" + day + '}';
    }
    
    private int year;   
    // durch private "kapselt" man die eigenschaften, Zugriff dann nur noch über Schnittstellen möglich
    private int month;
    private int day;

    /**
     * 
     * is LeaperYear ist eine Klassenmethode (static) , i.e. eine Bibliotheksmethode 
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
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
    
//    public static void main(String[] args) {
//        Calendar calendar = new Calendar(2017, 9, 25);    
 //   }

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
     * Die nextDay - Methode wechselt zum nächsten Kalendertag
     */ 
    public void nextDay(){
        int days = Calendar.daysPerMonth[this.month]; // explizite Schreibweise
        // days = daysPerMonth[month]; // dazu äquivalente implizite Schreibweise 
        if (this.month == 2 && Calendar.isLeapYear(this.year)){ 
            day++;
        }
        if (day > days) {
            day = 1;
            month++;
            if (month > 12){
                month = 1;
                year++;
            }
        }
    }
    public static void main(String[] args) {
        Calendar calendar = new Calendar(2017, 9,30);
        calendar.nextDay();
        System.out.println(calendar);
    }          
    
}
