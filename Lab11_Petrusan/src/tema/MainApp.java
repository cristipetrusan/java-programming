package tema;

public class MainApp {

	public static void main(String[] args) {
		ContBancar c = new ContBancar();
		Depunere d = new Depunere(c);
		Extragere e = new Extragere(c);
		d.start();
		e.start();
	}

}
