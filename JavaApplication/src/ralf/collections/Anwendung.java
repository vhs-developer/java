package ralf.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Anwendung {
    public static void main(String[] args) {
        List<Person> personen = new ArrayList<Person>();
        
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
        person.programmiersprachen = new String[] {"C", "C++", "PHP", "Pascal", "Fortran", "Assembler"};
        person.geburtsdatum = new Date(1959, 2, 12);
        person.wohnort = "Brakel";
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
        person.programmiersprachen = new String[] {"Python", "C", "C#", "PHP", "Basic", "Assembler", "RexX"};
        person.geburtsdatum = new Date(1955, 6, 6);
        person.wohnort = "Delbrück";
        person.partei = "2";
        personen.add(person);

        person = new Person();
        person.vorname = "Bernhard";
        person.programmiersprachen = new String[] {"PHP", "Python", "C", "Pascal", "Assembler", "VHDL"};
        person.geburtsdatum = new Date(1958, 6, 2);
        person.wohnort = "Bad Driburg";
        person.partei = "2";
        personen.add(person);
        
        person = new Person();
        person.vorname = "Ralf";
        person.programmiersprachen = new String[] {"PHP", "Python", "C", "C++", "Java", "PL/1", "Cobol", "Assembler"};
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
        
        // Wie viele Personen können C?
        long anzahl = personen.stream().filter(p -> p.wohnort.equals("Paderborn")).count();
        System.out.println(anzahl);
        
        
        
    }
}