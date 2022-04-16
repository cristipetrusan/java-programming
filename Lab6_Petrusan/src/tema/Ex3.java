package tema;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

class Exceptie3 extends Exception {
	public Exceptie3(String s) {
		super(s);
	}
}

class CNP {
	String cnp;
	int sex, an, luna, zi;

	public CNP(String s) {
		this.cnp = s;
	}

	public void verifica() throws Exceptie3 {
		if (cnp.length() != 13)
			throw new Exceptie3("Nu are 13 caractere");
		try {
			long numar = Long.parseLong(cnp);
		} catch (NumberFormatException e) {
			throw new Exceptie3("Nu este numar");
		}

		sex = Integer.parseInt(cnp.substring(0, 1));
		an = Integer.parseInt(cnp.substring(1, 3));
		luna = Integer.parseInt(cnp.substring(3, 5));
		zi = Integer.parseInt(cnp.substring(5, 7));

		if (sex < 1 || sex > 6)
			throw new Exceptie3("Prima cifra invalida");
		if (luna > 12)
			throw new Exceptie3("Luna invalida");

		if (luna == 2) {
			if (zi > 28)
				throw new Exceptie3("Zi invalida");
		} else if (luna == 1 || luna == 3 || luna == 5 || luna == 7 || luna == 8 || luna == 10 || luna == 12) {
			if (zi > 31)
				throw new Exceptie3("Zi invalida");
		} else {
			if (zi > 30)
				throw new Exceptie3("Zi invalida");
		}
	}

	public Date getDate() throws Exceptie3 {
		this.verifica();
		if (sex == 5 || sex == 6)
			return new Date(an + 100, luna - 1, zi);
		if (sex == 1 || sex == 2)
			return new Date(an, luna - 1, zi);
		if (sex == 3 || sex == 4)
			return new Date(an - 100, luna - 1, zi);
		return null;
	}

	public int getVarsta() throws Exceptie3 {
		this.verifica();
		LocalDate data1 = LocalDate.now();
		if (sex == 5 || sex == 6)
			data1 = LocalDate.of(an + 2000, luna, zi);
		if (sex == 1 || sex == 2)
			data1 = LocalDate.of(an + 1900, luna, zi);
		if (sex == 3 || sex == 4)
			data1 = LocalDate.of(an + 1800, luna, zi);

		LocalDate data2 = LocalDate.now();

		Period diff = Period.between(data1, data2);
		return diff.getYears();
	}
}

public class Ex3 {

	public static void main(String[] args) {
		boolean ok = false;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Numele: ");
			String nume = sc.nextLine();
			System.out.println("CNP: ");
			CNP cnp = new CNP(sc.nextLine());
			try {
				cnp.verifica();
				System.out.println("Data nasterii: " + cnp.getDate());
				System.out.println("Varsta: " + cnp.getVarsta());
				ok = true;

			} catch (Exceptie3 e) {
				System.out.println(e.getMessage());
			}
		} while (!ok);
	}

}
