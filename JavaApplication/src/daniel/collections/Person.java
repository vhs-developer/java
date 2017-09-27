package daniel.collections;

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

    @Override
    public String toString() {
        return "Person{" + "vorname=" + vorname + ", programmiersprachen=" + programmiersprachen + ", geburtsdatum=" + geburtsdatum + ", wohnort=" + wohnort + ", partei=" + partei + '}';
    }
    
    
}
