package tema;

import java.io.Serializable;

enum Stare {
	achizitionat, expus, vandut
}

public class Echipament implements Serializable {
	private int tip;
	private String nume;
	private int nr_inv;
	private double pret;
	private String zona_mag;
	private Stare stare;

	public Echipament(int tip, String nume, int nr_inv, double pret, String zona_mag, Stare stare) {
		this.tip = tip;
		this.nume = nume;
		this.nr_inv = nr_inv;
		this.pret = pret;
		this.zona_mag = zona_mag;
		this.stare = stare;
	}

	public int getTip() {
		return tip;
	}

	public void setTip(int tip) {
		this.tip = tip;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getNr_inv() {
		return nr_inv;
	}

	public void setNr_inv(int nr_inv) {
		this.nr_inv = nr_inv;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public String getZona_mag() {
		return zona_mag;
	}

	public void setZona_mag(String zona_mag) {
		this.zona_mag = zona_mag;
	}

	public Stare getStare() {
		return stare;
	}

	public void setStare(Stare stare) {
		this.stare = stare;
	}

	public String toString() {
		return nume + " " + nr_inv + " " + pret + " " + zona_mag + " " + stare;
	}
}
