package Tom.calendarclock;

public interface Clock {
    public int getHour();
    public void setHour(int hour);
    public int getMinute();
    public void setMinute(int minute);
    public int getSecond();
    public void setSecond(int second);
    public void tick();
}

class MyClock implements Clock {
    private int hour;
    private int minute;
    private int second;

    public MyClock(int hour, int minute, int second) {
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
        second++;
        if (second >= 60) {
            second = 0;
            minute++;
            if (minute >= 60) {
                minute = 0;
                hour++;
                if (hour >= 24) {
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
        Clock clock = new MyClock(15, 2, 59);
        clock.tick();
        System.out.println(clock);
    }
    
}
