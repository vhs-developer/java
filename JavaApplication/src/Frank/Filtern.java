/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kubuntu
 */
abstract class Checker {
    public abstract boolean test(Integer element);
    
    public boolean notTest(Integer element) {
    return !test(element);
    }
}

class CheckerPositiv extends Checker {

    public boolean test(Integer element) {
        return element > 0;
    }
}

class CheckerGerade extends Checker {

    public boolean test(Integer element) {
        return element % 2 == 0;
    }
}

public class Filtern {

    public static List<Integer> filtern(List<Integer> liste, Checker checker) {
        List<Integer> ergebnis = new ArrayList<>();
        for (Integer element : liste) {
            if (checker.test(element)) {
                ergebnis.add(element);
            }
        }
        return ergebnis;
    }

    public static void main(String[] args) {
        List<Integer> messwerte = Arrays.asList(new Integer[]{3, -7, 42, -11, 0, 5});
        List<Integer> gefiltert = Filtern.filtern(messwerte, new CheckerPositiv());
        System.out.print(gefiltert);
    }

}
