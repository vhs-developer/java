package ralf.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
abstract class Checker {
    public abstract boolean test(Integer element);

    public boolean notTest(Integer element) {
        return test(element);
    }
}
*/

interface Checker {
    public boolean test(Integer element);
}
// class CheckerPositiv extends Checker {
class CheckerPositiv implements Checker {
    public boolean test(Integer element) {
        return element > 0;
    }
}
// class CheckerGerade extends Checker {
class CheckerGerade implements Checker {
  public boolean test(Integer element) {
        return element % 2 == 0;
    }
}
public class Filtern {
    
    public static void main(String[] args) {
        List<Integer> messwerte = Arrays.asList(new Integer[] {3, -7, 42, -11, 0, 5});
        List<Integer> gefiltert = Filtern.filtern(messwerte, new CheckerGerade());
        System.out.println(gefiltert);
    }

    public static List<Integer> filtern(List<Integer> liste, Checker checker) {
        List<Integer> ergebnis = new ArrayList<>();
        for (Integer element : liste) {
            if (checker.test(element)) {
                ergebnis.add(element);
            }
        }
        return ergebnis;
    }
    
}
