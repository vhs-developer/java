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
public class Clock {
   private int hour;
   private int minute;
   private int second;

    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
    
    
    
    public void nextTick() {
        
        second++;
        if (this.second >= 60) {
            this.minute++;
            this.second = 0;
        
            if (this.minute >= 60) {
                this.hour++;
                this.minute = 0;
                this.second = 0;
            }
            
            if (this.hour >= 24) {
                hour = 0;
            }
        }
    }

    @Override
    public String toString() {
        return "Clock{" + "hour=" + hour + ", minute=" + minute + ", second=" + second  + '}';
    }
    
    
    
    public static void main(String[] args) {
        int i;
        Clock clock = new Clock(14, 5, 58);
            clock.nextTick();            System.out.println(clock);            
            clock.nextTick();            System.out.println(clock);
            clock.nextTick();            System.out.println(clock);
            clock.nextTick();            System.out.println(clock);             
            clock.nextTick();            System.out.println(clock);             
    }
}
