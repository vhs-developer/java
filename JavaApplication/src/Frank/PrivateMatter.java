/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frank;

class Base {
public String className = "Base";
}
class Derived extends Base {
public String className = "Derived";
}
public class PrivateMatter {
public static void main(String[] args) {
System.out.println(new Derived().className);
}
}