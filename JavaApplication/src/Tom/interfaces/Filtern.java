package Tom.interfaces;

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
//
// statt implements steht dann extends bei den realisierenden Klassen

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
        List<Integer> ergebnis = new ArrayList<>();  // leere Egebnisliste
        for (Integer element: liste) {
            if (checker.test(element)) {
                ergebnis.add(element);
            }
        }
        return ergebnis; // Ergebnisliste zurückgeben
    }
    public static void main(String[] args) {
        List<Integer> messwerte = Arrays.asList(new Integer[] {3, -7, 42, -11, 0, 5});
        List<Integer> gefiltert = Filtern.filtern(messwerte, new CheckerGerade());
        System.out.println(gefiltert);
        gefiltert = Filtern.filtern(messwerte, x -> x % 2 == 0);    // dirket über Lambda-Ausdruck
        System.out.println(gefiltert);
    }
}
