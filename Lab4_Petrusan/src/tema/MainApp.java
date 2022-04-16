package tema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Vector;

public class MainApp {

	public static void scrie(Object o, String fis) {
		try {
			FileOutputStream f = new FileOutputStream(fis);
			ObjectOutputStream oos = new ObjectOutputStream(f);
			oos.writeObject(o);
			oos.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static Object citeste(String fis) {
		try {
			FileInputStream f = new FileInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(f);
			Object o = ois.readObject();
			ois.close();
			f.close();
			return o;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("echipamente.txt"));
		Vector<Echipament> vec = new Vector<Echipament>();
		while (sc.hasNext()) {
			String[] s = sc.nextLine().split(";");

			switch (s[5]) {
			case "imprimanta":
				Imprimanta im = new Imprimanta(1, s[0], Integer.parseInt(s[1]), Double.parseDouble(s[2]), s[3],
						Stare.valueOf(s[4]), Integer.parseInt(s[6]), s[7], Integer.parseInt(s[8]),
						ModScriere.valueOf(s[9]));
				vec.add(im);
				break;
			case "copiator":
				Copiator c = new Copiator(2, s[0], Integer.parseInt(s[1]), Double.parseDouble(s[2]), s[3],
						Stare.valueOf(s[4]), Integer.parseInt(s[6]), Integer.parseInt(s[7]),
						FormatCopiere.valueOf(s[8]));
				vec.add(c);
				break;
			case "sistem de calcul":
				SistemDeCalcul sdc = new SistemDeCalcul(3, s[0], Integer.parseInt(s[1]), Double.parseDouble(s[2]), s[3],
						Stare.valueOf(s[4]), s[6], Double.parseDouble(s[7]), Integer.parseInt(s[8]),
						SistemDeOperare.valueOf(s[9]));
				vec.add(sdc);
				break;
			}

		}

		for (var a : vec) {
			System.out.println(a);
		}
		while (true) {
			Scanner sc2 = new Scanner(System.in);

			System.out.println("1 - afisare imprimante");
			System.out.println("2 - afisare copiatoare");
			System.out.println("3 - afisare sisteme de calcul");
			System.out.println("4 - modificare stare echipament");
			System.out.println("5 - setare mod scriere pt imprimanta");
			System.out.println("6 - setare mod format copiere pt copiatoare");
			System.out.println("7 - instalare sistem operare");
			System.out.println("8 - afisare echipamente vandute");
			System.out.println("9 - serializare");
			System.out.println("0 - IESIRE");

			int opt;
			opt = Integer.parseInt(sc2.nextLine());
			String nume;
			switch (opt) {
			case 0:
				System.exit(0);
				break;
			case 1:
				for (var aux : vec) {
					if (aux.getTip() == 1)
						System.out.println(aux);
				}
				break;
			case 2:
				for (var aux : vec) {
					if (aux.getTip() == 2)
						System.out.println(aux);
				}
				break;
			case 3:
				for (var aux : vec) {
					if (aux.getTip() == 3)
						System.out.println(aux);
				}
				break;
			case 4:
				System.out.println("numele cautat: ");
				nume = sc2.nextLine();
				for (var aux : vec) {
					if (aux.getNume().equals(nume)) {
						System.out.println("achizitionat, expus, vandut");
						aux.setStare(Stare.valueOf(sc2.nextLine()));
					}
				}
				break;
			case 5:
				System.out.println("numele cautat: ");
				nume = sc2.nextLine();
				for (var aux : vec) {
					if (aux.getNume().equals(nume)) {
						System.out.println("tiparireColor, tiparireAlbNegru");
						Imprimanta aux2 = (Imprimanta) aux;
						aux2.setModScriere(ModScriere.valueOf(sc2.nextLine()));
					}
				}

				break;
			case 6:
				System.out.println("numele cautat: ");
				nume = sc2.nextLine();
				for (var aux : vec) {
					if (aux.getNume().equals(nume)) {
						System.out.println("A4, A3");
						Copiator aux3 = (Copiator) aux;
						aux3.setFormatCopiere(FormatCopiere.valueOf(sc2.nextLine()));
					}
				}
				break;
			case 7:
				System.out.println("numele cautat: ");
				nume = sc2.nextLine();
				for (var aux : vec) {
					if (aux.getNume().equals(nume)) {
						System.out.println("Windows, Linux");
						SistemDeCalcul aux4 = (SistemDeCalcul) aux;
						aux4.setSistemDeOperare(SistemDeOperare.valueOf(sc2.nextLine()));
					}
				}

				break;
			case 8:
				for (var aux : vec) {
					if (aux.getStare() == Stare.vandut) {
						System.out.println(aux);
					}
				}
				break;
			case 9:
				scrie(vec, "echip.bin");
				Vector q = (Vector) citeste("echip.bin");
				for (var aux : q)
					System.out.println(aux);
				break;

			}

		}

	}

}
