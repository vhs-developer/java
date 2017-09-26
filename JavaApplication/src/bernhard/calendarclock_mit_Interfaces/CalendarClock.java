package bernhard.calendarclock_mit_Interfaces;

public class CalendarClock implements Clock, Calendar{
    // Composition:
    private Clock clock;
    private Calendar calendar;
    
    public CalendarClock(int year, int month, int day, int hour, int minute, int second) {
        calendar = new MyCalendar(year, month, day);
        clock = new MyClock(hour, minute, second);
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

    @Override
    public int getHour() { 
        clock.getHour();
    }

    @Override
    public void setHour(int hour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMinute() {
        clock.getMinute();
    }

    @Override
    public void setMinute(int minute) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSecond() {
        clock.getSecond();
    }

    @Override
    public void setSecond(int second) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getYear() {
        clock.getYear();
    }

    @Override
    public void setYear(int year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMonth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMonth(int month) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDay(int day) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
