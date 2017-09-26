package Frank;

/**
 *
 * @author kubuntu
 */
public class CalendarClock_mit_Interfaces {
    
    
    public interface Clock {
    public int getHour();
    public void setHour(int hour);
    public int getHour();
    public int getMinute();
    public void setMinute(int minute);
    public int getSecond();
    public void setSecond(int second);
    public void tick();
    }
    
     public interface Calendar {
        public static int[] daysPerMonth = new int[] {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
        public int getYear();
        public void setYear(int year);
        public int getMonth();
        public void setMonth(int month);
        public int getDay();
        public void setDay(int day);
        
        public void nextDay();
    }
        class MyCalendar implements Calendar {
        }
        class MyClock implements Clock {
        }

    public CalendarClock_mit_Interfaces() {
    }
                
     
     
    /**
     * Die nextDay-Methode wechselt zum nächsten Kalendertag
     */
    public void nextDay() {
        int days = Frank.calendarclock.Calendar.daysPerMonth[this.month]; // explizite Schreibweise
        // days = daysPerMonth[month]; // dazu semantisch äquivalente implizite Schreibweise
        if (this.month == 2 && Frank.calendarclock.Calendar.isLeapYear(this.year)) {
            days++;
        }       
    }
    
    public CalendarClock(int year, int month, int day, int hour, int minute, int second) {
        calendar = new Calendar(year, month, day);
        clock = new Clock(hour, minute, second);
    }

    public void tick() {
        clock.tick();
        if (clock.getHour() == 0 && clock.getMinute() == 0 && clock.getSecond() == 0) {
            calendar.nextDay(); // Wenn Mitternacht, dann neuer Tag
        }
    }
    
    public void nextDay() {
        calendar.nextDay();
    }

    @Override
    public String toString() {
        return "CalendarClock{" + "clock=" + clock + ", calendar=" + calendar + '}';
    }
    
    public static void main(String[] args) {
        CalendarClock cc = new CalendarClock(2017, 9, 25, 23, 59, 59);
        cc.tick();
        System.out.println(cc);
        cc.nextDay();
        System.out.println(cc);
    }
}
