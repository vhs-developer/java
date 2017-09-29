package daniel.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anwendung {
    public static void main(String[] args) {
        List<Person> personen = new ArrayList<>();
        
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
        
        // Wie viele Personen können C? Erwartete Ausgabe: 7
        long kannC = personen.stream().filter(p -> Arrays.asList(p.programmiersprachen).contains("C")).count();
        System.out.println(kannC);

        // Wie viele Personen kommen aus Paderborn?
        long anzahl = personen.stream().filter(p -> p.wohnort.equals("Paderborn")).count();
        System.out.println(anzahl);
        
        // Welche Personen kommen aus Paderborn?
        List<Person> paderborner = personen.stream().filter(p -> p.wohnort.equals("Paderborn")).collect(Collectors.toList());
        paderborner.forEach(p -> {System.out.println(p);});

        // Durchschnittsalter aller Paderborner:
        OptionalDouble d = personen.stream().filter(p -> p.wohnort.equals("Paderborn")).mapToInt(p -> p.getAlter()).average();
        System.out.println(d.orElse(0));
        
        // Alternative zu vorhergehender Anweisung:
        // for (Person p : paderborner) {
        //    System.out.println(p);
        // }
        
        // 1) Liste aller Personen deren Vornamen mit A beginnt
        List<Person> beginntA = personen.stream().filter(p -> p.vorname.startsWith("A")).collect(Collectors.toList());
        System.out.println("Beginnen mit A: " + beginntA);
        
        // 2) Liste aller Programmiersprachen
        List<String> sprachen = personen.
                stream().
                map(p -> Arrays.asList(p.programmiersprachen)).
                flatMap(List<String>::stream).
                distinct().
                sorted().
                collect(Collectors.toList());
        System.out.println("Sprachen: " + sprachen);
        
        // 3) Wie viele Personen kommen aus Paderborn?
        long n = personen.stream().filter(p -> p.wohnort.equals("Paderborn")).count();
        
        // 4) Stärkste Partei ermitteln
        personen.stream().collect(Collectors.groupingBy(p -> p.partei, TreeMap::new, Collectors.counting())).
                entrySet().stream().max(Comparator.comparing(Entry::getValue)).
                ifPresent(entry -> {System.out.println("Stärkste Partei ist " + entry.getKey() + " mit " + entry.getValue() + " Stimmen.");});
        
        // 5) Weiseste Person ermitteln
        Person weise = personen.stream().max((p1, p2) -> (Integer.compare(p1.getAlter(), p2.getAlter()))).get();
        System.out.println(weise);

        // 6) Programmiersprachen nach Häufigkeit ermitteln
        personen.
                stream().
                map(p -> Arrays.asList(p.programmiersprachen)).
                flatMap(List<String>::stream).
                collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting())).
                entrySet().stream().sorted(Comparator.comparingLong(Entry::getValue)).
                forEach(System.out::println);
    }
}