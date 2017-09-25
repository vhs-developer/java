package Tom;

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

    @Override
    public String toString() {
        return "Clock{" + "hour=" + hour + ", minute=" + minute + ", second=" + second + '}';
    }
    
    public void tick() {    
        if (this.second < 59) {
            this.second++;
        }
        else {
            this.second = 0;
            if (this.minute < 59) {
                this.minute++;
            }
            else {
                minute = 0;
                if (this.hour < 23) {
                    this.hour++;
                }
                else this.hour = 0;
            }
                
        }
    }
    
    public static void main(String[] args) {
        Clock clock = new Clock(22,59,59);
        System.out.println("aktuelle Zeit: " + clock);
        clock.tick();
        System.out.println("nächster Tick: " + clock);
    }
}

