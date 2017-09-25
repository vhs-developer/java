package Wolfgang;

import java.util.ArrayList;
import java.util.Date;

class Person {
    String vorname;
    String[] programmiersprachen;
    Date geburtsdatum;      
    String wohnort;
    String partei;
}

/**
 *
 * @author admin
 */
public class P01Kennenlernen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Person> personen = new ArrayList<>();
        
        Person person = new Person();
        person.vorname = "Frank";
        person.programmiersprachen = new String[] {"Python", "C", "C++", "PHP", "Pascal", "Basic" };
        person.geburtsdatum = new Date(1964, 14, 3);
        person.wohnort = "Wiedenbrück";
        person.partei = "3";

        person = new Person();
        person.vorname = "Ahmad";
        person.programmiersprachen = new String[] {"Python", "C", "C++", "PHP", "Pascal", "Basic" };
        person.geburtsdatum = new Date(1961, 2, 10);
        person.wohnort = "Paderborn";
        person.partei = "4";

        person = new Person();
        person.vorname = "Paul";
        person.programmiersprachen = new String[] { "C", "C++", "PHP", "Pascal", "Assembler" };
        person.geburtsdatum = new Date(1959, 12, 2 );
        person.wohnort = "Brakel";
        person.partei = "2";

        person = new Person();
        person.vorname = "Tom";
        person.programmiersprachen = new String[] { "Java", "Simula", "Python", "C", "C++", "PHP", "Pascal", "Basic" };
        person.geburtsdatum = new Date(1957, 3, 10);
        person.wohnort = "Paderborn";
        person.partei = "1";

        person = new Person();
        person.vorname = "Wolfgang";
        person.programmiersprachen = new String[] { "Python", "C", "C#", "PHP", "Basic", "Assembler", "RexX" };
        person.geburtsdatum = new Date(1955, 6, 6);
        person.wohnort = "Delbrück";
        person.partei = "2";

        person = new Person();
        person.vorname = "Bernhard";
        person.programmiersprachen = new String[] { "PHP", "Python", "C", "Pascal", "Assembler", "VHDL" };
        person.geburtsdatum = new Date(1958, 6, 2);
        person.wohnort = "Bad Driburg";
        person.partei = "3";

        person = new Person();
        person.vorname = "Ralf";
        person.programmiersprachen = new String[] { "PHP", "Python", "C", "C++", "Java", "PL/1", "Cobol", "Assembler" };
        person.geburtsdatum = new Date(1960, 2, 3);
        person.wohnort = "Paderborn";
        person.partei = "3";

        person = new Person();
        person.vorname = "Daniel";
        person.programmiersprachen = new String[] { "PHP", "Python", "C", "C++", "Java", "PL/1", "Cobol", "Assembler" };
        person.geburtsdatum = new Date(1983, 1, 2);
        person.wohnort = "Paderborn";
        person.partei = "3";




        
        personen.add(person);
    }
    
}
