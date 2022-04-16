package tema;

import java.util.Random;

public class Vers {
	private String vers;

	public String getVers() {
		return vers;
	}

	public void setVers(String vers) {
		this.vers = vers;
	}

	public Vers(String vers) {
		this.vers = vers;
	}

	public Vers() {
		this.vers = "";
	}

	public int numarCuvinte() {
		String[] aux = vers.split(" ");
		return aux.length;
	}

	public int numarVocale() {
		int numar = 0;
		for (int i = 0; i < vers.length(); i++) {
			if ("aeiouAEIOU".indexOf(vers.charAt(i)) != -1) {
				numar++;
			}
		}
		return numar;
	}

	public String afisare() {
		String sir = new String("");
		sir += this.numarCuvinte() + " cuvinte,  " + this.numarVocale() + " vocale\t| " + vers;

		Random rand = new Random();
		var aux = rand.nextDouble();
		// System.out.println(aux);

		if (aux < 0.1)
			sir = sir.toUpperCase();
		if (vers.endsWith("ooh"))
			sir += "*";

		return sir;
	}
}
