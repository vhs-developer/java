/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daniel.newpackage;

public class StrungOut {

    public static void main(java.lang.String[] args) {
        String s = new String("Hello world");
        System.out.println(s);
    }
}

class String {

    private final java.lang.String s;

    public String(java.lang.String s) {
        this.s = s;
    }

    public java.lang.String toString() {
        return s;
    }
}
