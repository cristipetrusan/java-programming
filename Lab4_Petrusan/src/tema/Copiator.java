package tema;

import java.io.Serializable;

enum FormatCopiere {
	A4, A3
}

public class Copiator extends Echipament implements Serializable {
	private int ppm;
	private int p_ton;
	private FormatCopiere formatCopiere;

	public int getPpm() {
		return ppm;
	}

	public void setPpm(int ppm) {
		this.ppm = ppm;
	}

	public int getP_ton() {
		return p_ton;
	}

	public void setP_ton(int p_ton) {
		this.p_ton = p_ton;
	}

	public FormatCopiere getFormatCopiere() {
		return formatCopiere;
	}

	public void setFormatCopiere(FormatCopiere formatCopiere) {
		this.formatCopiere = formatCopiere;
	}

	public Copiator(int tip, String nume, int nr_inv, double pret, String zona_mag, Stare stare, int ppm, int p_ton,
			FormatCopiere formatCopiere) {
		super(tip, nume, nr_inv, pret, zona_mag, stare);
		this.ppm = ppm;
		this.p_ton = p_ton;
		this.formatCopiere = formatCopiere;
	}

	public String toString() {
		return super.toString() + " " + ppm + " " + p_ton + " " + formatCopiere;
	}
}
