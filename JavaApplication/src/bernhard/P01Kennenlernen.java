package p01kennenlernen;

import java.util.ArrayList;
import java.util.Date;

class Person {
    String vorname;  /** datentypen **/
    String[] programmiersprachen;
    Date geburtsdatum; // ctrl shift i
    String wohnort;
    String partei;
}

/**
 *
 * @author bernhard
 */
public class P01Kennenlernen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Person> personen = new ArrayList<>();
        // datentyp       variablennamen    konstruktor, leere Liste wird initialisiert  
        Person person = new Person();
        person.vorname = "Frank";
        person.programmiersprachen = new String [] {"python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1964,14,3);
        person.wohnort = "Wiedenbrück";
        person.partei = "3";        
        personen.add(person);
        
        person = new Person();
        person.vorname = "Ahmad";
        person.programmiersprachen = new String [] {"python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1961,14,3);
        person.wohnort = "Wiedenbrück";
        person.partei = "3";        
        personen.add(person);
        
        person = new Person();
        person.vorname = "Paul";
        person.programmiersprachen = new String [] {"python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1961,14,3);
        person.wohnort = "Wiedenbrück";
        person.partei = "3";        
        personen.add(person);
        
        person = new Person();
        person.vorname = "Tom";
        person.programmiersprachen = new String [] {"python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1961,14,3);
        person.wohnort = "Wiedenbrück";
        person.partei = "3";        
        personen.add(person);

  
        person = new Person();
        person.vorname = "Wolfgang";
        person.programmiersprachen = new String [] {"Assembler", "Pascal", "C", "C#", "PHP",  "Basic"};
        person.geburtsdatum = new Date(1961,14,3);
        person.wohnort = "Wiedenbrück";
        person.partei = "3";        
        personen.add(person);

        person = new Person();
        person.vorname = "Bernhard";
        person.programmiersprachen = new String [] {"Assembler", "Pascal", "C", "VHDL", "PHP",  "Basic"};
        person.geburtsdatum = new Date(1958,6,2);
        person.wohnort = "Bad Driburg";
        person.partei = "3";        
        personen.add(person);   
        
        person = new Person();
        person.vorname = "Ralf";
        person.programmiersprachen = new String [] {"Assembler", "Pascal", "C", "PL/1", "PHP",  "Basic"};
        person.geburtsdatum = new Date(1958,6,2);
        person.wohnort = "Bad Driburg";
        person.partei = "3";        
        personen.add(person);      
        
    }
    
}
