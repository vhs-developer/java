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
public class Calender {
    /**
     * Dist eine Klassenvariable (static).
     */
    public static int[] daysPerMonth = new int[] {-1,31, 28, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31};
    
    private int year;
    private int month;
    private int day;
    
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        
    }

    public Calender(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Calender{" + "year=" + year + ", month=" + month + ", day=" + day + '}';
    }
    
    /**
     * Methode wechesel zum nächsten Kalendertag
     */
    public void nextDay() {
        int days = daysPerMonth[month];
        if (isLeapYear(year) && month == 2)
            days++
                    ;
        day++;
                
        if (day > days) {
            day = 1;
            month++;
            if (month > 12) {
                    month = 1;
                      year++;
            }
        }
    }

        // Template "psvm" benutze, um Methode main zu erzeugen
    public static void main(String[] args) {
        Calender calender = new Calender(2017, 9, 25);
        calender.nextDay();
        System.out.println(calender);
    }
}
