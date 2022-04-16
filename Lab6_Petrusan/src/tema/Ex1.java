package tema;

import java.util.Scanner;

class Exceptie1 extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Exceptie1(String s) {
		super(s);
	}
}

class DouaNumere {
	double x, y;

	public DouaNumere(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void verifica() throws Exceptie1 {
		if (!(x < y))
			throw new Exceptie1("Primul numar nu e mai mic decat al doilea");
	}
}

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean ok = false;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.println("Introduceti 2 nr: ");
				DouaNumere clasa = new DouaNumere(Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
				clasa.verifica();
				ok = true;
			} catch (Exceptie1 e) {
				System.out.println(e.getMessage());
			}
		} while (!ok);
	}
}
