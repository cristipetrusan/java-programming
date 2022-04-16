package tema;

import java.util.ArrayList;
import java.util.List;

public class Banca {
	private String denumireBanca;
	private List<Client> clienti;

	public Banca(String denumireBanca) {
		this.denumireBanca = denumireBanca;
		this.clienti = new ArrayList<Client>();
	}

	public List<Client> getClienti() {
		return clienti;
	}

	public void setClienti(ArrayList<Client> clienti) {
		this.clienti = clienti;
	}

	public String getDenumireBanca() {
		return denumireBanca;
	}

	public void setDenumireBanca(String denumireBanca) {
		this.denumireBanca = denumireBanca;
	}

	public void adaugareClient(Client c) {
		for (var i : clienti)
			if (i.getNume().equals(c.getNume())) {
				System.out.println("Clientul deja exista");
				return;
			}
		clienti.add(c);
	}
	
	public String toString()
	{
		return "*BANCA\nNume: " + this.denumireBanca + "\n";
	}

	public void afisare() {
		System.out.println("*BANCA\nNume: " + this.denumireBanca);
		for(var aux : clienti)
			aux.afisare();
		}

}
