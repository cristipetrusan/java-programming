package tema;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Vector;

public class ClientiiBancilor {
	public static void main(String[] args) throws FileNotFoundException {

		String numeBanca, nume, nrCont;
		double suma;
		Vector<Banca> v = new Vector<Banca>();

		while (true) {
			System.out.println("1 - Adaugare banca, clienti, conturi");
			System.out.println("2 - Afisare date introduse");
			System.out.println("3 - Depunere suma in cont");
			System.out.println("4 - Extragere suma din cont");
			System.out.println("5 - Transfer de bani intre conturi");
			System.out.println("0 - IESIRE");
			Scanner sc = new Scanner(System.in);
			System.out.println("Optiunea dv: ");
			//int opt = Integer.parseInt(sc.nextLine());
			switch (sc.nextLine()) {
			case "1":
				Scanner sc2 = new Scanner(new File("clienti.txt"));
				while (sc2.hasNext()) {
					String aux[] = sc2.nextLine().split(";");
					switch (aux[0]) {
					case "banca":
						Banca b = new Banca(aux[1]);
						v.add(b);
						break;
					case "client":
						Client client = new Client(aux[2], aux[3]);
						for (var banca : v) {
							if (banca.getDenumireBanca().equals(aux[1])) {
								banca.adaugareClient(client);
							}
						}
						break;
					case "cont":
						String data1[] = aux[6].split("\\.");
						Calendar cal1 = new GregorianCalendar(Integer.parseInt(data1[0]),
								Integer.parseInt(data1[1]) - 1, Integer.parseInt(data1[2]));

						String data2[] = aux[7].split("\\.");
						Calendar cal2 = new GregorianCalendar(Integer.parseInt(data2[0]),
								Integer.parseInt(data2[1]) - 1, Integer.parseInt(data2[2]));

						ContBancar cont = new ContBancar(aux[3], Double.parseDouble(aux[4]), aux[5], cal1, cal2);
						for (var banca : v) {
							if (banca.getDenumireBanca().equals(aux[1])) {
								for (var client2 : banca.getClienti()) {
									if (client2.getNume().equals(aux[2]) && client2.getConturi().size() <= 5)
										client2.adaugareCont(cont);
								}
							}
						}
						break;
					}

				}
				break;
			case "2":
				for (var aux : v) {
					aux.afisare();
				}
				break;
			case "3":
				System.out.println("Dati banca: ");
				numeBanca = sc.nextLine();
				for (var aux : v)
					if (aux.getDenumireBanca().equals(numeBanca)) {
						System.out.println("Dati numele proprietarului: ");
						nume = sc.nextLine();
						for (var aux2 : aux.getClienti())
							if (aux2.getNume().equals(nume)) {
								System.out.println("Dati numarul contului: ");
								nrCont = sc.nextLine();
								for (var aux3 : aux2.getConturi())
									if (aux3.getNumarCont().equals(nrCont)) {
										System.out.println("Dati suma: ");
										aux3.depunere(Double.parseDouble(sc.nextLine()));
									}
							}
					}
				break;
			case "4":
				System.out.println("Dati banca: ");
				numeBanca = sc.nextLine();
				for (var aux : v)
					if (aux.getDenumireBanca().equals(numeBanca)) {
						System.out.println("Dati numele proprietarului: ");
						nume = sc.nextLine();
						for (var aux2 : aux.getClienti())
							if (aux2.getNume().equals(nume)) {
								System.out.println("Dati numarul contului: ");
								nrCont = sc.nextLine();
								for (var aux3 : aux2.getConturi())
									if (aux3.getNumarCont().equals(nrCont)) {
										System.out.println("Dati suma: ");
										suma = Double.parseDouble(sc.nextLine());
										aux3.extragere(suma);
									}
							}
					}

				break;
			case "5":
				boolean creditor = false, debitor = false;

				ContBancar contCreditor = new ContBancar();
				ContBancar contDebitor = new ContBancar();

				System.out.println("Dati banca creditorului: ");
				numeBanca = sc.nextLine();
				for (var aux : v)
					if (aux.getDenumireBanca().equals(numeBanca)) {
						System.out.println("Dati numele creditorului: ");
						nume = sc.nextLine();
						for (var aux2 : aux.getClienti())
							if (aux2.getNume().equals(nume)) {
								System.out.println("Dati numarul contului creditorului: ");
								nrCont = sc.nextLine();
								for (var aux3 : aux2.getConturi())
									if (aux3.getNumarCont().equals(nrCont)) {
										contCreditor = aux3;
										creditor = true;
									}
							}
					}

				System.out.println("Dati banca debitorului: ");
				numeBanca = sc.nextLine();
				for (var aux : v)
					if (aux.getDenumireBanca().equals(numeBanca)) {
						System.out.println("Dati numele debitorului: ");
						nume = sc.nextLine();
						for (var aux2 : aux.getClienti())
							if (aux2.getNume().equals(nume)) {
								System.out.println("Dati numarul contului debitorului: ");
								nrCont = sc.nextLine();
								for (var aux3 : aux2.getConturi())
									if (aux3.getNumarCont().equals(nrCont)) {
										contDebitor = aux3;
										debitor = true;
									}
							}
					}
				if (debitor && creditor && (contCreditor.getMoneda().equals(contDebitor.getMoneda()))) {
					System.out.println("Dati suma: ");
					suma = Double.parseDouble(sc.nextLine());
					if (contCreditor.extragere(suma))
						contDebitor.depunere(suma);
				} else
					System.out.println("Nu s-a putut realiza transferul");
				break;
			case "0":
				sc.close();
				return;
			default:
				break;

			}

		}

	}

}
