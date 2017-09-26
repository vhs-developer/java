/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frank;

/**
 *
 * @author kubuntu
 */
public class Confusing {

    private Confusing(Object o) {
        System.out.println("Object");
    }

    private Confusing(double[] dArray) {
        System.out.println("double array");
    }

    public static void main(String[] args) {
       new Confusing(new double[] {1, 5, 7});
       new Confusing("Hallo"); 
       new Confusing(null); 
    }
}

