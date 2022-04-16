package tema;

import java.util.HashSet;
import java.util.Set;

public class Client {
	private String nume;
	private String adresa;
	private Set<ContBancar> conturi;

	public Client(String nume, String adresa) {
		this.nume = nume;
		this.adresa = adresa;
		this.conturi = new HashSet<ContBancar>();
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Set<ContBancar> getConturi() {
		return conturi;
	}

	public void setConturi(HashSet<ContBancar> conturi) {
		this.conturi = conturi;
	}

	public void adaugareCont(ContBancar cont) {
		for (var c : conturi) {
			if (c.getNumarCont().equals(cont.getNumarCont())) {
				System.out.println("Contul deja exista");
				return;
			}
		}
		conturi.add(cont);
	}

	public String toString() {
		return "** CLIENT\nNume: " + this.nume + "\nAdresa: " + this.adresa + "\n" + this.conturi;
	}

	public void afisare() {
		System.out.println("\t** CLIENT\n\tNume: " + this.nume + "\n\tAdresa: " + this.adresa);
		for (var aux : conturi)
			aux.afisare();
	}
}
