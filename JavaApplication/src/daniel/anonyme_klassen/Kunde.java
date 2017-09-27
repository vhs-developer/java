/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daniel.anonyme_klassen;

public class Kunde {
    private String vorname;

    public Kunde(String vorname) {
        this.vorname = vorname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    public void sageHallo() {
        System.out.println("Hallo, ich bin " + vorname);
    }
    
    public static void main(String[] args) {
        PremiumKunde pk = new PremiumKunde("Gabi");
        
        Kunde k = new Kunde("Gabi") {
            @Override
            public void sageHallo() {
                System.out.println("Hallo, ich bin ein PremiumKunde und heiße" + getVorname());
            }
        };
        
        pk.sageHallo();
        k.sageHallo();
    }
}

class PremiumKunde extends Kunde {
    public PremiumKunde(String vorname) {
        super(vorname);
    }
    
    @Override
    public void sageHallo() {
        System.out.println("Hallo, ich bin ein PremiumKunde und heiße" + getVorname());
    }
}