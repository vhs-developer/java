/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tom;

/**
 *
 * @author kubuntu
 */
public class CalendarClock {
    // Composition, da Mehrfach-Vererbung in Java nicht geht
    private Calendar calendar;
    private Clock clock;
    
    public CalendarClock(int year,int month,int day,int hour,int minute,int second) {
        calendar = new Calendar(year, month, day);
        clock = new Clock(hour, minute, second);
    }
    
    public void tick() {
        clock.tick();
        if (clock.getHour() == 0 && clock.getMinute() == 0 && clock.getSecond() == 0) {
            calendar.nextDay(); // wenn Mitternacht, dann neuer Tag
            
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
        System.out.println(cc);
        cc.tick();
        System.out.println(cc);
        cc.nextDay();
        System.out.println(cc);
    }
}
