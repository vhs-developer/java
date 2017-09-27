/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tom.anonyme_klassen;




/*
 * !!! Siehe besseres Beispiel von Daniel:
 *          Überschreiben einer Methode: sageHallo()
 */


/**
 *
 * @author kubuntu
 */
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
    
    public static void main(String[] args) {
        PremiumKunde pk = new PremiumKunde(42, "Gabi");

        Kunde k = new Kunde("Gabi") {
            private int status = 42;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        };
    }
}

class PremiumKunde extends Kunde {
    private int status;

    public PremiumKunde(int status, String vorname) {
        super(vorname);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }   
}
