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
public class Calender {
    /**
     * daysPerMonth ist eine Klassenvariable (static)
     */
    public static int[] daysPerMonth = new int[-1, 31, 28, 31, 30, 31, 31, 30, 31, 30, 31];
    
    private int year;
    private int month;
    private int day;

    /**
     * isLeapYear ist eine Klassenmethode (static), i.e. "Bibliotheksmethode"
     * @param year
     * @return 
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year != 0 || year % 400 == 0);
    }
    
    
    
    /**
     * 
     * @param year
     * @param month
     * @param day 
     */
    public Calender(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public static void main(String[] args) {
        Calendar calendar = new Calendar(2017,9,25);
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
    
    /**
     * Die Methode wechselt zum nächsten Tag
     */
    public void nextDay () {
        int days = Calender.daysPerMonth[this.month];  //expliz. Scheibweise
        // days = dasePerMonth[month]; // dazu semantisch äquivalent impl. Schreibweise
        days++;
        if day > daysPerMonth[month] {
            day =1;
            if (isLeapYear(year) {
                month;
            }
            month++;
            if (month > 12) {
                month=1;
                year++;
            }
        }
    }

    public static void main(String[] args) {
        Calendar calendar = new Calendar(2017, 9 , 30);
        calendar.nextDay();
        System.out.println("calender");
    }
    
    
}



          
   

