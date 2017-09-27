package ralf.collections;

import daniel.generics.*;
import java.util.Date;

class Person {
    String vorname;
    String[] programmiersprachen;
    Date geburtsdatum;
    String wohnort;
    String partei;
    
    public Integer getAlter() {
        return 2017 - geburtsdatum.getYear();
    }
}
