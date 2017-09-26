package bernhard;
import java.util.logging.Logger;

/**
 *
 * @author bernhard
 */
public class Clock{
    
    /**
     * days per month inst eine Klassenvariable (static).
     */
//    public  static int[] daysPerMonth = new int [] {-1, 31,28,31,30,31,30,31,31,30,31,30,31};

//
    
    private int hour;   
    // durch private "kapselt" man die eigenschaften, Zugriff dann nur noch über Schnittstellen möglich
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

    public void tick(){
        this.second++;
        if (second > 59){
            minute++;
            second = 0;
            if (minute > 59){
                hour++;
                minute = 0;
                if (hour > 23){
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
        Clock clock = new Clock(0, 0,0);
        clock.tick();
        System.out.println(clock);
    }          
    
}
