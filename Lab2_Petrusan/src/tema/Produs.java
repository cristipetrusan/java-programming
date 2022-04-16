package tema;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produs {

	private String nume;
	private double pret;
	private double cantitate;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("-----Ex2 produs-----\n");
		
		Scanner scanner = new Scanner(new File("produsIn.txt"));
		List<Produs> lista = new ArrayList<Produs>();
		
		while (scanner.hasNext()) {
			String[] s = scanner.nextLine().split(";");
			lista.add(new Produs(s[0], Double.parseDouble(s[1]), Double.parseDouble(s[2])));
		}

		double minim = Double.MAX_VALUE;
		double maxim = Double.MIN_VALUE;
		int minimIndex = -1, maximIndex = -1;

		for (var i = 0; i < lista.size(); i++) {
			if (minim > lista.get(i).getPret()) {
				minim = lista.get(i).getPret();
				minimIndex = i;
			}
			if (maxim < lista.get(i).getPret()) {
				maxim = lista.get(i).getPret();
				maximIndex = i;
			}
		}
		System.out.println("produsul cu pret minim: " + lista.get(minimIndex));
		System.out.println("produsul cu pret maxim: " + lista.get(maximIndex));

		PrintStream fluxOut = new PrintStream(new File("produsOut.txt"));
		fluxOut.println("produsul cu pret minim: " + lista.get(minimIndex));
		fluxOut.println("produsul cu pret maxim: " + lista.get(maximIndex));
		fluxOut.close();

	}

	public Produs(String nume, double pret, double cantitate) {
		this.nume = nume;
		this.pret = pret;
		this.cantitate = cantitate;
	}

	public String toString() {
		return nume + ", pret: " + Double.toString(pret) + ", cantitate: " + Double.toString(cantitate);
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public double getCantitate() {
		return cantitate;
	}

	public void setCantitate(double cantitate) {
		this.cantitate = cantitate;
	}

}
