package daniel.timer;

import java.util.function.Function;

public class Mathe {
    
    public static long tueWasLangsam(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    
    public static long tueWasSchnell(int n) {
        return n * (n + 1) / 2;
    }
  
    public static <S, T> long timer(Function<S, T> f, S s) {
        long start = System.nanoTime();
        f.apply(s);
        long ende = System.nanoTime();
        return ende - start;        
    }
    
    public static void main(String[] args) {
        long zeit = timer(Mathe::tueWasLangsam, 5000);
        System.out.println(zeit);
        zeit = timer(Mathe::tueWasSchnell, 5000);
        System.out.println(zeit);
    }
    
}
