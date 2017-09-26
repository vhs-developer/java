package Frank;

/**
 *
 * @author kubuntu
 */

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

interface CheckerG<T> {
    public boolean test(T element);
}
    
class CheckerPositivG implements CheckerG<Integer> {
    public boolean test(Integer element) {
        return element > 0;
    }
}

class CheckerGeradeG implements CheckerG<Integer> {
    public boolean test(Integer element) {
        return element % 2 == 0;
    }
}

public class FilternGenerisch {

    public static <T> List<T> filtern(List<T> liste, CheckerG<T> checker) {
        List<T> ergebnis = new ArrayList<>(); // leere Liste für die Ergebnisliste erzeugen
        for (T element : liste) { // jedes Element der betrachteten Liste durchgehen
            if (checker.test(element)) { // Filterkriterium für das aktuelle Element überprüfen
                ergebnis.add(element); // Element in die Ergebnisliste einfügen
            }
        }
        return ergebnis; // Ergebnisliste zurückgeben
    }

    public static void main(String[] args) {
        List<Integer> messwerte = Arrays.asList(new Integer[] {3, -7, 42, -11, 0, 5});
        List<Integer> gefiltert = FilternGenerisch.filtern(messwerte, new CheckerPositivG());
        gefiltert = FilternGenerisch.filtern(messwerte, x -> x % 2 == 0);

        System.out.print(gefiltert);
    }
}

