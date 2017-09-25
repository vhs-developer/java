package Tom;

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
 * @author kubuntu
 */
public class P01Kennenlernen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Person> personen = new ArrayList<>();
        
        Person person = new Person();
        person.vorname = "Frank";
        person.programmiersprachen = new String[] {"Python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1964, 14, 3);
        person.wohnort = "Wiedenbrück";
        person.partei = "3";
        
        
        personen.add(person);
        
        person = new Person();
        person.vorname = "Ahmad";
        person.programmiersprachen = new String[] {"Python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1961, 2, 10);
        person.wohnort = "Paderborn";
        person.partei = "4";
        
        personen.add(person);
        
        person = new Person();
        person.vorname = "Paul";
        person.programmiersprachen = new String[] {"Python", "C", "C++", "PHP", "Pascal", "Basic", "Assembler"};
        person.geburtsdatum = new Date(1959, 2, 12);
        person.wohnort = "Paderborn";
        person.partei = "2";
        
        personen.add(person);
        
        person = new Person();
        person.vorname = "Tom";
        person.programmiersprachen = new String[] {"Java", "Simula", "Python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1957, 3, 10);
        person.wohnort = "Paderborn";
        person.partei = "1";
        
        personen.add(person);
        
        person = new Person();
        person.vorname = "Wolfgang";
        person.programmiersprachen = new String[] {"Python", "C", "C#", "PHP","Basic", "Assembler", "RexX"};
        person.geburtsdatum = new Date(1964, 14, 3);
        person.wohnort = "Delbrück";
        person.partei = "2";
        
        personen.add(person);
        
        person = new Person();
        person.vorname = "Bernhard";
        person.programmiersprachen = new String[] {"Python", "C", "PHP", "Pascal", "Assembler", "HHDL"};
        person.geburtsdatum = new Date(1958, 6, 2);
        person.wohnort = "Bad Driburg";
        person.partei = "3";
        
        personen.add(person);
        
        person = new Person();
        person.vorname = "Ralf";
        person.programmiersprachen = new String[] {"Python", "C", "C++", "PHP", "Java", "PL/1", "Cobol", "Assembler"};
        person.geburtsdatum = new Date(1960, 2, 3);
        person.wohnort = "Paderborn";
        person.partei = "1";
        
        personen.add(person);
        
        person = new Person();
        person.vorname = "Daniel";
        person.programmiersprachen = new String[] {"Java"};
        person.geburtsdatum = new Date(1983, 1, 2);
        person.wohnort = "Bielefeld";
        person.partei = "1";
        
        personen.add(person);
    }
    
}
