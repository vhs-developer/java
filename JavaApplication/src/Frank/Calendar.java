
package Frank;

/**
 *
 * @author kubuntu
 */
public class Calendar {
 public static int[] daysPerMonth = new int[] {-1, 31, 28, 31, 30, 31, 31, 30, 31};
 private int year;
 private int month;
 private int day;
 
 public static boolean isleapYear(int year) {
     return (year % 4 == 0 && year % 100 !=0) || year % 400 == 0;
 }

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
    
    public void nextDay() {
        int days = Calendar.daysPerMonth[month];
        if (month == 2 && Calendar.isleapYear(year)){
            days++;
        }

        day++;
        if (day > days){
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
      Calendar calendar = new Calendar(2017, 9, 30);
      calendar.nextDay();
      System.out.println(calendar);
    }

    
}


