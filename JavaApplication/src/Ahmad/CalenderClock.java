/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahmad;

/**
 *
 * @author kubuntu
 */
public class CalenderClock {
    // composition: 
    private Clock clock;
    private Calender calender;

    public CalenderClock(int year, int month, int day, int hour, int minute, int second) {
        calender = new Calender(year, month, day);
        clock = new Clock(hour, minute, second);
    }
    
    public void tick() {
        clock.nextTick();
        if (clock.getHour() == 0 && clock.getMinute() == 0 && clock.getSecond() == 0) {
            calender.nextDay();
        }
    }

    @Override
    public String toString() {
        return "CalenderClock{" + "clock=" + clock + ", calender=" + calender + '}';
    }
    public static void main(String[] args) {
        CalenderClock cc = new CalenderClock(2017, 9, 25, 23, 59,59);
        cc.tick();
        System.out.print(cc);
    }
  
}
