package daniel.calendarclock_mit_interfaces;

public class CalendarClock implements Clock, Calendar {
    // Composition:
    private Clock clock;
    private Calendar calendar;
    
    public CalendarClock(int year, int month, int day, int hour, int minute, int second) {
        calendar = new MyCalendar(year, month, day);
        clock = new MyClock(hour, minute, second);
    }

    public CalendarClock(Calendar calendar, Clock clock) {
        this.calendar = calendar;
        this.clock = clock;
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
        CalendarClock cc = new CalendarClock(new MyCalendar(2017, 9, 25), new MyClock(23, 59, 59)); // Die konkrete Implementierung von Calendar und Clock ist austauschbar, da wir mit Interfaces arbeiten.
        // cc = new CalendarClock(2017, 9, 25, 23, 59, 59);
        cc.tick();
        System.out.println(cc);
        cc.nextDay();
        System.out.println(cc);
    }

    @Override
    public int getHour() {
        return clock.getHour(); // Forwarding
    }

    @Override
    public void setHour(int hour) {
        clock.setHour(hour);
    }

    @Override
    public int getMinute() {
        return clock.getMinute();
    }

    @Override
    public void setMinute(int minute) {
        clock.setMinute(minute);
    }

    @Override
    public int getSecond() {
        return clock.getSecond();
    }

    @Override
    public void setSecond(int second) {
        clock.setSecond(second);
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
