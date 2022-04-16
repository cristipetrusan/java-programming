package tema;

import java.util.Scanner;

class Exceptie2 extends Exception {
	public Exceptie2(String mesaj) {
		super(mesaj);
	}
}

class ImpartireLa0 {
	double x, y;

	public ImpartireLa0(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void verifica() throws Exceptie2 {
		if (y == 0)
			throw new Exceptie2("Impartire la 0! REINTRODUCETI\n");
	}

	public String toString() {
		return x + "/" + y + "=" + x/y;
	}
}

public class Ex2 {

	public static void main(String[] args) {
		boolean ok = false;
		do {
			double nr1 = 0, nr2 = 0;
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("Dati 2 nr: ");
				System.out.println("Primul: ");
				nr1 = Double.parseDouble(sc.nextLine());
				System.out.println("Al doilea: ");
				nr2 = Double.parseDouble(sc.nextLine());
				try {
					ImpartireLa0 impartire = new ImpartireLa0(nr1, nr2);
					impartire.verifica();
					System.out.println(impartire);
					ok = true;
				} catch (Exceptie2 e) {
					System.out.println(e.getMessage());
				}

			} catch (NumberFormatException e) {
				System.out.println("Nu este numar! REINTRODUCETI\n");
			}

		} while (!ok);
	}

}
