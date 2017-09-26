/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daniel.newpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Predicate<T> {
    public boolean test(T t);
}

/**
 *
 * @author kubuntu
 */
public class Foo {
    static <T> List<T> filter(List<T> l, Predicate<T> p) {
        List<T> r = new ArrayList<>();
        for (T t : l) {
            if (p.test(t)) {
                r.add(t);
            }
        }
        
        return r;
    }
    
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(new Integer[] {4, -7, 1, 42});
        Predicate<Integer> p = new PositiveInteger();
        List<Integer> fl = Foo.filter(l, p);
        System.out.println(l);
        System.out.println(fl);

        fl = Foo.filter(l, x -> x >= 0);
        System.out.println(fl);
       
    }
}

class PositiveInteger implements Predicate<Integer> {
    @Override
    public boolean test(Integer t) {
        return t > 0;
    }
}