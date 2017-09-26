package Frank;

import daniel.*;

public class CalendarClock {
    // Composition:
    private Clock clock;
    private Calendar calendar;
    
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
