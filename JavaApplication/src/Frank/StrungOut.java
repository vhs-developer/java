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
public class StrungOut {
public static void main(String[] args) {
Stringy s = new Stringy("Hello world");
System.out.println(s);
}
}
class Stringy {
private final java.lang.String s;
public Stringy(java.lang.String s) {
this.s = s;
}
public java.lang.String toString() {
return s;
}
}