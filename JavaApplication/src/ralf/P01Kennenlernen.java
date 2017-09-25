package ralf;

import java.util.ArrayList;
import java.util.Date;

class Person {
    String vornamen;
    String[] programmiersprache;
    Date geburtsdatum;
    String wohnort;
    String partei;
}

/**
 *
 * @author ralf
 */
public class P01Kennenlernen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Person> personen = new ArrayList<>();
        
        Person person = new Person();
        person.vornamen = "Frank";
        person.programmiersprache = new String[] {"Python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1964, 14, 3);
        person.wohnort = "Wiedenbrück";
        person.partei = "3";
        personen.add(person);
        
        person = new Person();
        person.vornamen = "Ahmad";
        person.programmiersprache = new String[] {"Python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1961, 2, 10);
        person.wohnort = "Paderborn";
        person.partei = "4";
        personen.add(person);

        person = new Person();
        person.vornamen = "Paul";
        person.programmiersprache = new String[] {"C", "C++", "PHP", "Pascal", "Fortran", "Assembler"};
        person.geburtsdatum = new Date(1959, 12, 2);
        person.wohnort = "Brakel";
        person.partei = "2";
        personen.add(person);
        
        person = new Person();
        person.vornamen = "Tom";
        person.programmiersprache = new String[] {"Java", "Simula", "Python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1957, 3, 10);
        person.wohnort = "Paderborn";
        person.partei = "1";
        personen.add(person);
        
        person = new Person();
        person.vornamen = "Wolfgang";
        person.programmiersprache = new String[] {"Python", "C", "C#", "PHP", "Basic", "Assembler", "RexX"};
        person.geburtsdatum = new Date(1955, 6, 6);
        person.wohnort = "Delbrück";
        person.partei = "2";
        personen.add(person);
        
        person = new Person();
        person.vornamen = "Bernhard";
        person.programmiersprache = new String[] {"Python", "C", "PHP", "Pascal", "Assembler", "VHDL"};
        person.geburtsdatum = new Date(1958, 6, 2);
        person.wohnort = "Bad Driburg";
        person.partei = "3";
        personen.add(person);
        
        person = new Person();
        person.vornamen = "Ralf";
        person.programmiersprache = new String[] {"Python", "C", "C++", "PHP", "Java", "Assembler", "PL/1", "Cobol"};
        person.geburtsdatum = new Date(1960, 2, 3);
        person.wohnort = "Paderborn";
        person.partei = "1";
        personen.add(person);
  
        person = new Person();
        person.vornamen = "Daniel";
        person.programmiersprache = new String[] {"Python", "C", "C#", "PHP", "Basic", "Assembler", "RexX"};
        person.geburtsdatum = new Date(1983, 1, 2);
        person.wohnort = "Bielefeld";
        person.partei = "1";
        personen.add(person);
     
        System.out.println("Personen-");
    }
    
}
