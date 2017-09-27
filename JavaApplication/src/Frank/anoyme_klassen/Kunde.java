/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frank.anoyme_klassen;

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
    
   public static void main(String[] args)  {
       PremiumKunde pk = new PremiumKunde(42, "Gabi");
   }
           
}
class PremiumKunde extends Kunde {
    public
}