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
class Cache {
 
/*    
public class Type1 {
public static void main(String[] args) {
String s = null;
System.out.println(s instanceof String);
}
}

    class Type2 {

        public static void main(String[] args) {
            System.out.println(new Type2() instanceof String);
        }
    }
    class Type3 {

        public static void main(String args[]) {
            Type3 t3 = (Type3) new Object();
        }
    }
*/
    
        static {
            initializeIfNecessary();
        }
        private static int sum;

        public static int getSum() {
            initializeIfNecessary();
            return sum;
        }
        private static boolean initialized = false;

        private static synchronized void initializeIfNecessary() {
            if (!initialized) {
                for (int i = 0; i < 100; i++) {
                    sum += i;
                }
                initialized = true;
            }
        }
    

    public class Client {

        public static void main(String[] args) {
            System.out.println(Cache.getSum());
        }
    }
