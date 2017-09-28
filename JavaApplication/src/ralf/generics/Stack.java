package ralf.generics;

import java.util.Arrays;
import java.util.Date;
import java.util.TreeSet;
import static javafx.scene.input.KeyCode.T;

class IntegerMerger implements Merger<Integer, Integer> {
    @Override
    public Integer merge(Integer partial, Integer next) {
        return partial + next;
    }    
}

class PersonMerger implements Merger<Person, Integer> {
    @Override
    public Integer merge(Integer partial, Person next) {
        return partial + next.getAlter();
    }
}

interface Merger<T, U> {
    public U merge(U partial, T next);
}

public interface Stack<T> {
    public void push(T x);
    public T pop();
    public int size();
    public default boolean isEmpty() {
        return size() == 0;
    }

    public <U> U reduce(U initial, Merger<T, U> merger);
}

class ArrayStack<T> implements Stack<T> {
    private T[] elements;
    private int maxSize;
    int size;

    public <U> U reduce(U initial, Merger<T, U> merger) {
        System.out.println("Stack.reduce");
        
        U partial = initial;
        for (int i = size() - 1; i >= 0; i--) {
            System.out.println("Stack.reduce.merger " + i);
            
            partial = merger.merge(partial, elements[i]);
        }
        return partial;
    }

    public ArrayStack() {
        maxSize = 100;
        size = 0;
        elements = (T[]) new Object[maxSize]; // type erasure
    }
    
    @Override
    public void push(T x) {
        if (size >= maxSize) {
            maxSize += (maxSize >> 1);
            elements = Arrays.copyOf(elements, maxSize);

        }
        
        elements[size++] = x;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            return elements[size--];
            // TODO: ggf. trim durchführen
        } else {
            // TODO: Exception werfen (e.g. Stack underflow)
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        Stack<Person> personen = new ArrayStack<Person>();
        
        Person person = new Person();
        person.vorname = "Frank";
        person.programmiersprachen = new String[] {"Python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1964, 14, 3);
        person.wohnort = "Wiedenbrück";
        person.partei = "3";
        personen.push(person);

        person = new Person();
        person.vorname = "Ahmad";
        person.programmiersprachen = new String[] {"Python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1961, 2, 10);
        person.wohnort = "Paderborn";
        person.partei = "4";
        personen.push(person);

        person = new Person();
        person.vorname = "Paul";
        person.programmiersprachen = new String[] {"C", "C++", "PHP", "Pascal", "Fortran", "Assembler"};
        person.geburtsdatum = new Date(1959, 2, 12);
        person.wohnort = "Brakel";
        person.partei = "2";
        personen.push(person);

        person = new Person();
        person.vorname = "Tom";
        person.programmiersprachen = new String[] {"Java", "Simula", "Python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1957, 3, 10);
        person.wohnort = "Paderborn";
        person.partei = "1";
        personen.push(person);

        person = new Person();
        person.vorname = "Wolfgang";
        person.programmiersprachen = new String[] {"Python", "C", "C#", "PHP", "Basic", "Assembler", "RexX"};
        person.geburtsdatum = new Date(1955, 6, 6);
        person.wohnort = "Delbrück";
        person.partei = "2";
        personen.push(person);

        person = new Person();
        person.vorname = "Bernhard";
        person.programmiersprachen = new String[] {"PHP", "Python", "C", "Pascal", "Assembler", "VHDL"};
        person.geburtsdatum = new Date(1958, 6, 2);
        person.wohnort = "Bad Driburg";
        person.partei = "2";
        personen.push(person);
        
        person = new Person();
        person.vorname = "Ralf";
        person.programmiersprachen = new String[] {"PHP", "Python", "C", "C++", "Java", "PL/1", "Cobol", "Assembler"};
        person.geburtsdatum = new Date(1960, 2, 3);
        person.wohnort = "Paderborn";
        person.partei = "1";
        personen.push(person);

        person = new Person();
        person.vorname = "Daniel";
        person.programmiersprachen = new String[] {"Java"};
        person.geburtsdatum = new Date(1983, 1, 2);
        person.wohnort = "Bielefeld";
        person.partei = "1";
        personen.push(person);           

        // Alternative 1: Mit expliziter Klasse PersonMerger (Definition s.o.)
        // int altersSumme = personen.reduce(0, new PersonMerger());
        // System.out.println(altersSumme);

        // Alternative 2: Mit Lambda-Ausdruck. Die Klasse PersonMerger könnte man entfernen, wenn man den Lambda-Ausdruck vorzieht.
        // altersSumme = personen.reduce(0, (partial, pers) -> (partial + pers.getAlter()));
        // System.out.println(altersSumme);
        
        // Menge aller Programmiersprachen des Teams ermitteln
        TreeSet<String> set = new TreeSet<>();
        set = personen.reduce(set, (partial, pers) -> {
            partial.add(pers.wohnort);
            return partial;
        });
           
        for (String s : set) {
            System.out.println(s);
        }
        
        
    }
}