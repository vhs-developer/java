/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paul;

/**
 *
 * @author kubuntu
 */
public class Clock {
    /**
     * daysPerMonth ist eine Klassenvariable (static)
     */
  
    
    private int hour;
    private int minute;
    private int second;

    /**
     * Erzeugt Urzeit-Anzeige
     * @param hour
     * @param minute
     * @param second 
     */
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

   
    /**
     * Die Methode gibt eine Uhrzeit aus
     */
    
    public void tick () {
        
        second++;
        if (second >= 60) {
            second = 0;
            minute++;
            if (minute > 60) {
                minute = 0;
                hour++;
                if (hour >= 24 ) {
                    hour = 0;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Clock{" + "hour=" + hour + ", minute=" + minute + ", second=" + second + '}';
    }

    
    
    public static void main(String[] args) {
        Clock  clock = new Clock(15 , 2 , 58);
        clock.tick();
        System.out.println(clock); 
        clock.tick();
        System.out.println(clock); 
        clock.tick();
        System.out.println(clock); 
        
        
    }
    

}



          
   

