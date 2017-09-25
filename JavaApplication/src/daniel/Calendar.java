package daniel;

/**
 *
 * @author kubuntu
 */
public class Calendar {
    private int year;
    private int month;
    private int day;

    /**
     * Eine Konstruktormethode für die Klasse Calendar
     */
    public Calendar(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public static void main(String[] args) {
        Calendar calendar = new Calendar(2017, 9, 25);
    }
    
}
