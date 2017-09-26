package bernhard.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Oberklasse
 * @author bernhard
 */

//abstract class Checker {
//    public abstract boolean test(Integer element);
//    // in der Mutterklasse wird nicht gesagt 
//    // wie die Klassenmethode zu implementieren ist
//}

interface CheckerG<T> {             // durch das <T> kann der Benutzer einen Datentyp mitgeben
// interface ist wie "abstrakte Klasse (Oberklasse)
// im Interface stehen schon die Methoden die in den Unterklassen
// implementiert werden müssen
// in der abstrakten Klasse kann man mischen also auch schon Methoden implementieren
    public boolean test(T element);  
} 

/**
 * Unterklasse (extends)
 * @author bernhard
 */
class CheckerPositivG implements CheckerG<Integer>{    // dieses ist jetzt eine CheckerPositivG implemenmtierung für Integer Typen
    public boolean test(Integer element){
        return element > 0;
    }
}

class CheckerGeradeG implements CheckerG<Integer>{
    public boolean test(Integer element){
        return element % 2 == 0;
    }
}
/**
 *
 * @author bernhard
 */
public class FilternGenerisch {
    
    public static <T> List<T> filtern (List<T> liste, CheckerG<T> checker) {
        List<T> ergebnis = new ArrayList<>();
        for (T element : liste) {
            if (checker.test(element)) {
                ergebnis.add(element);
            }
        }
        return ergebnis;
    }
    
    public static void main(String[] args) {
        List<Integer> messwerte = Arrays.asList(new Integer[] {3, -7, 42, -11, 0, 5});
        List<Integer> gefiltert = FilternGenerisch.filtern(messwerte, new CheckerPositivG());
        
        System.out.print(gefiltert);
    }
//                                ^^         
//                                macht aus dem Array eine Liste  
}
