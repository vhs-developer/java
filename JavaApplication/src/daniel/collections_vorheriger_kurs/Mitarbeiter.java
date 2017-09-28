/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daniel.collections_vorheriger_kurs;



public class Mitarbeiter {
	private String vorname;
	private String ort;
	private double gehalt;
	
	public Mitarbeiter(String vorname, String ort, double gehalt) {
		super();
		this.vorname = vorname;
		this.ort = ort;
		this.gehalt = gehalt;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public double getGehalt() {
		return gehalt;
	}

	public void setGehalt(double gehalt) {
		this.gehalt = gehalt;
	}

	@Override
	public String toString() {
		return "Mitarbeiter [vorname=" + vorname + ", ort=" + ort + ", gehalt=" + gehalt + "]";
	}
}

