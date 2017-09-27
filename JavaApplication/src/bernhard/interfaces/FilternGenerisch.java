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

interface Checker {             
// interface ist wie "abstrakte Klasse (Oberklasse)
// im Interface stehen schon die Methoden die in den Unterklassen
// implementiert werden müssen
// in der abstrakten Klasse kann man mischen also auch schon Methoden implementieren
    public boolean test(Integer element);  
} 

/**
 * Unterklasse (extends)
 * @author bernhard
 */
class CheckerPositiv implements Checker{
    public boolean test(Integer element){
        return element > 0;
    }
}

class CheckerGerade implements Checker{
    public boolean test(Integer element){
        return element % 2 == 0;
    }
}
/**
 *
 * @author bernhard
 */
public class FilternGenerisch {
    
    public static List<Integer> filtern (List<Integer> liste, Checker checker) {
        List<Integer> ergebnis = new ArrayList<>();
        for (Integer element : liste) {
            if (element > 0) {
                ergebnis.add(element);
            }
        }
        return ergebnis;
    }
    
    public static void main(String[] args) {
        List<Integer> messwerte = Arrays.asList(new Integer[] {3, -7, 42, -11, 0, 5});
        List<Integer> gefiltert = FilternGenerisch.filtern(messwerte, new CheckerPositiv());
        
        System.out.print(gefiltert);
    }
//                                ^^         
//                                macht aus dem Array eine Liste  
}
