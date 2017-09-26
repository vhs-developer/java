/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frank;

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

    public void tick() {
        if (second >= 60) {
            second++;
        }

        minute++;
        if (minute >= 60) {
            minute = 0;
            minute++;
            if (hour >= 24) {
                hour = 0;
                hour++;
            }

        }
    }

    @Override
    public String toString() {
        return "Clock{" + "hour=" + hour + ", minute=" + minute + ", second=" + second + '}';
    }

    public static void main(String[] args) {
        Clock clock = new Clock(15, 2, 59);
        clock.tick();
        System.out.println(clock);
    }

}
