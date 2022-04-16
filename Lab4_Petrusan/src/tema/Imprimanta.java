package tema;

import java.io.Serializable;

enum ModScriere {
	tiparireColor, tiparireAlbNegru
}

public class Imprimanta extends Echipament implements Serializable {
	private int ppm;
	private String dpi;
	private int p_car;
	private ModScriere modScriere;

	public Imprimanta(int tip, String nume, int nr_inv, double pret, String zona_mag, Stare stare, int ppm, String dpi,
			int p_car, ModScriere modScriere) {
		super(tip, nume, nr_inv, pret, zona_mag, stare);
		this.ppm = ppm;
		this.dpi = dpi;
		this.p_car = p_car;
		this.modScriere = modScriere;
	}

	public int getPpm() {
		return ppm;
	}

	public void setPpm(int ppm) {
		this.ppm = ppm;
	}

	public String getDpi() {
		return dpi;
	}

	public void setDpi(String dpi) {
		this.dpi = dpi;
	}

	public int getP_car() {
		return p_car;
	}

	public void setP_car(int p_car) {
		this.p_car = p_car;
	}

	public ModScriere getModScriere() {
		return modScriere;
	}

	public void setModScriere(ModScriere modScriere) {
		this.modScriere = modScriere;
	}

	public String toString() {
		return super.toString() + " " + ppm + " " + dpi + " " + p_car + " " + modScriere;
	}

}
