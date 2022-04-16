package tema;

import java.util.Calendar;

interface Operatiuni {
	public double calculeaza_dobanda();

	public double actualizare_suma();

	public void depunere(double suma);

	public boolean extragere(double suma);

}

public class ContBancar implements Operatiuni {
	private String numarCont;
	private double suma;
	private String moneda;
	private Calendar dataDeschiderii;
	private Calendar dataUltimeiOperatiuni;

	public ContBancar() {

	}

	public ContBancar(String numarCont, double suma, String moneda, Calendar dataDeschiderii,
			Calendar dataUltimeiOperatiuni) {
		this.numarCont = numarCont;
		this.suma = suma;
		this.moneda = moneda;
		this.dataDeschiderii = dataDeschiderii;
		this.dataUltimeiOperatiuni = dataUltimeiOperatiuni;
	}

	public ContBancar(ContBancar cb) {
		this.numarCont = cb.numarCont;
		this.suma = cb.suma;
		this.moneda = cb.moneda;
		this.dataDeschiderii = cb.dataDeschiderii;
		this.dataUltimeiOperatiuni = cb.dataUltimeiOperatiuni;
	}

	public String getNumarCont() {
		return numarCont;
	}

	public double getSuma() {
		return suma;
	}

	public String getMoneda() {
		return moneda;
	}

	public Calendar getDataDeschiderii() {
		return dataDeschiderii;
	}

	public Calendar getDataUltimeiOperatiuni() {
		return dataUltimeiOperatiuni;
	}

	public void setNumarCont(String numarCont) {
		this.numarCont = numarCont;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public void setDataDeschiderii(Calendar dataDeschiderii) {
		this.dataDeschiderii = dataDeschiderii;
	}

	public void setDataUltimeiOperatiuni(Calendar dataUltimeiOperatiuni) {
		this.dataUltimeiOperatiuni = dataUltimeiOperatiuni;
	}

	@Override
	public double calculeaza_dobanda() {
		long diferenta = Calendar.getInstance().getTimeInMillis() - this.dataUltimeiOperatiuni.getTimeInMillis();
		long zile = diferenta / 1000 / 60 / 60 / 24;

		if (this.moneda == "RON") {
			if (this.suma < 500)
				return zile * 0.3;
			else
				return zile * 0.8;
		}
		if (this.moneda == "EUR") {
			return zile * 0.1;
		}
		return 0;
	}

	@Override
	public double actualizare_suma() {
		double dobanda = this.calculeaza_dobanda();
		this.dataUltimeiOperatiuni = Calendar.getInstance();
		this.suma += dobanda;
		return this.suma;
	}

	@Override
	public void depunere(double suma) {
		this.suma = this.actualizare_suma();
		this.suma += suma;
		System.out.println("A fost depusa suma de " + suma + " " + this.moneda + " din contul " + this.numarCont);
		System.out.println("Sold ramas: " + this.suma + " " + this.moneda);
	}

	@Override
	public boolean extragere(double suma) {
		this.suma = this.actualizare_suma();
		if (suma > this.suma) {
			System.out.println("Nu exista fonduri suficiente");
			return false;
		}
		this.suma -= suma;
		System.out.println("A fost extrasa suma de " + suma + " " + this.moneda + " din contul " + this.numarCont);
		System.out.println("Sold ramas: " + this.suma + " " + this.moneda);
		return true;
	}

	public String toString() {
		return "***CONT\n" + "Numar cont: " + this.numarCont + "\nSuma: " + this.suma + "\nMoneda: " + this.moneda
				+ "\nData deschiderii: " + this.dataDeschiderii.getTime().toString() + "\nData ultimei operatiuni: "
				+ this.dataUltimeiOperatiuni.getTime().toString();
	}

	public void afisare() {
		System.out.println("\t\t***CONT\n" + "\t\tNumar cont: " + this.numarCont + "\n\t\tSuma: " + this.suma
				+ "\n\t\tMoneda: " + this.moneda + "\n\t\tData deschiderii: "
				+ this.dataDeschiderii.get(Calendar.DAY_OF_MONTH) + "." + (this.dataDeschiderii.get(Calendar.MONTH) + 1)
				+ "." + this.dataDeschiderii.get(Calendar.YEAR) + "\n\t\tData ultimei operatiuni: "
				+ this.dataUltimeiOperatiuni.get(Calendar.DAY_OF_MONTH) + "."
				+ (this.dataUltimeiOperatiuni.get(Calendar.MONTH) + 1) + "."
				+ this.dataUltimeiOperatiuni.get(Calendar.YEAR));
	}

}
