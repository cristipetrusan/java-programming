package tema;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ex1();
		ex2();
		ex3();
		ex4();
	}

	public static void ex1() throws FileNotFoundException {
		System.out.println("ex1");
		// Vers vers = new Vers("acesta este un test");
		// System.out.println(vers.numarCuvinte() + " " + vers.numarVocale());

		Scanner sc = new Scanner(new File("cantec_in.txt"));
		PrintStream ps = new PrintStream(new File("cantec_out.txt"));
		while (sc.hasNext()) {
			Vers vers2 = new Vers(sc.nextLine());
			ps.println(vers2.afisare());
			System.out.println(vers2.afisare());
		}
		// sc.close();
		ps.close();
	}

	public static void ex2() {
		System.out.println("ex2");
		Scanner sc = new Scanner(System.in);
		System.out.println("sirul initial: ");
		StringBuilder s = new StringBuilder(sc.nextLine());
		System.out.println("pozitie de inserat: ");
		Integer pozitie = Integer.parseInt(sc.nextLine());
		System.out.println("sir de inserat: ");
		String sirInserat = sc.nextLine();

		s.insert(pozitie - 1, sirInserat);
		System.out.println(s);

		System.out.println("pozitia de sters: ");
		Integer pozitieSters = Integer.parseInt(sc.nextLine());

		System.out.println("numar caractere de sters: ");
		Integer numarCaractere = Integer.parseInt(sc.nextLine());

		s.delete(pozitieSters - 1, pozitieSters + numarCaractere - 1);
		System.out.println(s);

		// sc.close();
	}

	public static void ex3() throws IOException {
		System.out.println("ex3");
		Scanner sc = new Scanner(new File("judete_in.txt"));
		Scanner sc2 = new Scanner(System.in);

		String[] judete = new String[42];
		int i = 0;
		while (i < 42) {
			judete[i] = sc.nextLine();
			i++;
		}
		Arrays.sort(judete);
		for (var is : judete)
			System.out.println(is);

		System.out.println("judetul cautat: ");

		String s = sc2.nextLine();
		System.out.println(Arrays.binarySearch(judete, s) + 1);

		// sc2.close();
	}

	public static void ex4() throws FileNotFoundException {
		System.out.println("ex4");
		Scanner sc = new Scanner(new File("in.txt"));
		ArrayList<Melodie> lista = new ArrayList<Melodie>();
		while (sc.hasNext()) {
			String[] s = sc.nextLine().split(",");
			lista.add(new Melodie(s[0], s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3])));
		}

		for (var melodie : lista) {
			System.out.println(melodie);
		}

		lista.sort(Comparator.comparing(Melodie::getNumarVizualizariYoutube).reversed());
		System.out.println("melodiile ordonate dupa nr vizualizari: ");
		for (var melodie : lista) {
			System.out.println(melodie);
		}

		Scanner sc2 = new Scanner(System.in);
		System.out.println("dati artistul: ");
		String artist = sc2.nextLine();
		for (var melodie : lista) {
			if (melodie.getNumeArtist().equals(artist))
				System.out.println(melodie);
		}
		// sc.close();
		// sc2.close();

	}

}
