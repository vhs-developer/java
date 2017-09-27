package daniel.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//abstract class Checker {
//    public abstract boolean test(Integer element);
//    
//    public boolean notTest(Integer element) {
//        return !test(element);
//    }
//}

interface Checker {
    public boolean test(Integer element);
}
    
class CheckerPositiv implements Checker {
    public boolean test(Integer element) {
        return element > 0;
    }
}

class CheckerGerade implements Checker {
    public boolean test(Integer element) {
        return element % 2 == 0;
    }
}

public class Filtern {

    public static List<Integer> filtern(List<Integer> liste, Checker checker) {
        List<Integer> ergebnis = new ArrayList<>(); // leere Liste für die Ergebnisliste erzeugen
        for (Integer element : liste) { // jedes Element der betrachteten Liste durchgehen
            if (checker.test(element)) { // Filterkriterium für das aktuelle Element überprüfen
                ergebnis.add(element); // Element in die Ergebnisliste einfügen
            }
        }
        return ergebnis; // Ergebnisliste zurückgeben
    }

    public static void main(String[] args) {
        List<Integer> messwerte = Arrays.asList(new Integer[] {3, -7, 42, -11, 0, 5});
        List<Integer> gefiltert = Filtern.filtern(messwerte, new CheckerPositiv());
        gefiltert = Filtern.filtern(messwerte, x -> x % 2 == 0);

        System.out.print(gefiltert);
    }
}
