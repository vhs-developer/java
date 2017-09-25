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
    private int year;
    private int month;
    private int day;

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
 
    
    
}



          
   

