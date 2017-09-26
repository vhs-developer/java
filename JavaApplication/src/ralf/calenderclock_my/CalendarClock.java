package ralf.calenderclock_my;

/**
 *
 * @author ralf
 */
public class CalendarClock {

    private Calendar calendar;
    private Clock clock;

    public CalendarClock(int year, int month, int day, int hour, int minute, int second) {
        calendar = new Calendar(year, month, day);
        clock = new Clock(hour, minute, second);   
    }
    public static void main(String[] args) {
        CalendarClock cc = new CalendarClock(2017, 12, 31, 23, 59, 59);
        
        cc.tick();
        System.out.println(cc);
    }

    @Override
    public String toString() {
        return "CalendarClock{" + "calendar=" + calendar + ", clock=" + clock + '}';
    }
    
    public void tick() {
        clock.tick();
        if (clock.getHour() == 0 && clock.getMinute() == 0 && clock.getSecond() == 0)
            calendar.nextDay();
        
    }
}
