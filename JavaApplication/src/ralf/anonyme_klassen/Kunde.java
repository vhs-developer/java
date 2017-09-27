package ralf.anonyme_klassen;

public class Kunde {
    private String vorname;

    public Kunde(String vorname) {
        this.vorname = vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    public int getStatus() {
        return 0;
    }
    
    public static void main(String[] args) {
        PremiumKunde pk = new PremiumKunde(42, "Gabi");
        
        Kunde k = new Kunde("Gabi") {
            // anonyme Klasse
            private int status = 44;

            @Override
            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        };
        
        System.out.println(pk.getStatus());
        System.out.println(k.getStatus());
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
