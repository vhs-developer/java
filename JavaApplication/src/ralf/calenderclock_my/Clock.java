/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ralf.calenderclock_my;

/**
 *
 * @author ralf
 */
public class Clock {
    private int hour;
    private int minute;
    private int second;

    public static void main(String[] args) {
        Clock clock = new Clock(23, 0, 0);
        
        clock.tick(600);
        System.out.println(clock);
        clock.tick(6000);
        System.out.println(clock);
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

    @Override
    public String toString() {
        return "Clock{" + "hour=" + hour + ", minute=" + minute + ", second=" + second + '}';
    }

    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public void tick() {
        second++;
        if (second > 59) {
            second = 0;
            minute++;
            if (minute > 59) {
                minute = 0;
                hour++;
                if (hour > 23) {
                    hour = 0;
                }
            }
        }
    }   
  
    public void tick(int ticks) {
        for (int t = 0; t < ticks; t++)
            tick();
    }
}
