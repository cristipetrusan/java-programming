package tema;

import java.io.Serializable;

enum SistemDeOperare {
	Windows, Linux
}

public class SistemDeCalcul extends Echipament implements Serializable {
	private String tip_mon;
	private double vit_proc;
	private int c_hdd;
	private SistemDeOperare sistemDeOperare;

	public String getTip_mon() {
		return tip_mon;
	}

	public void setTip_mon(String tip_mon) {
		this.tip_mon = tip_mon;
	}

	public double getVit_proc() {
		return vit_proc;
	}

	public void setVit_proc(double vit_proc) {
		this.vit_proc = vit_proc;
	}

	public int getC_hdd() {
		return c_hdd;
	}

	public void setC_hdd(int c_hdd) {
		this.c_hdd = c_hdd;
	}

	public SistemDeOperare getSistemDeOperare() {
		return sistemDeOperare;
	}

	public void setSistemDeOperare(SistemDeOperare sistemDeOperare) {
		this.sistemDeOperare = sistemDeOperare;
	}

	public SistemDeCalcul(int tip, String nume, int nr_inv, double pret, String zona_mag, Stare stare, String tip_mon,
			double vit_proc, int c_hdd, SistemDeOperare sistemDeOperare) {
		super(tip, nume, nr_inv, pret, zona_mag, stare);
		this.tip_mon = tip_mon;
		this.vit_proc = vit_proc;
		this.c_hdd = c_hdd;
		this.sistemDeOperare = sistemDeOperare;
	}

	public String toString() {
		return super.toString() + " " + tip_mon + " " + vit_proc + " " + c_hdd + " " + sistemDeOperare;
	}
}
