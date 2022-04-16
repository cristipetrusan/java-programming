package tema;

public class Melodie {
	String numeMelodie;
	String numeArtist;
	int anLansare;
	int numarVizualizariYoutube;

	public Melodie(String numeMelodie, String numeArtist, int anLansare, int numarVizualizariYoutube) {
		this.numeArtist = numeArtist;
		this.numeMelodie = numeMelodie;
		this.anLansare = anLansare;
		this.numarVizualizariYoutube = numarVizualizariYoutube;
	}

	public String getNumeMelodie() {
		return numeMelodie;
	}

	public void setNumeMelodie(String numeMelodie) {
		this.numeMelodie = numeMelodie;
	}

	public String getNumeArtist() {
		return numeArtist;
	}

	public void setNumeArtist(String numeArtist) {
		this.numeArtist = numeArtist;
	}

	public int getAnLansare() {
		return anLansare;
	}

	public void setAnLansare(int anLansare) {
		this.anLansare = anLansare;
	}

	public int getNumarVizualizariYoutube() {
		return numarVizualizariYoutube;
	}

	public void setNumarVizualizariYoutube(int numarVizualizariYoutube) {
		this.numarVizualizariYoutube = numarVizualizariYoutube;
	}

	public String toString() {
		return "nume: " + String.format("%-23s", this.numeMelodie) + " | artist: "
				+ String.format("%-23s", this.numeArtist) + " | an lansare: " + this.anLansare
				+ " | numar vizualizari: " + this.numarVizualizariYoutube;
	}

}
