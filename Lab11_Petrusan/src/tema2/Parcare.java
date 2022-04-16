package tema2;

public class Parcare {
	private int locuriOcupate = 0;
	private boolean plina;
	private boolean goala;

	public Parcare() {
		plina = false;
		goala = true;
	}

	public synchronized void Intrare(String numeParcare) {
		if (locuriOcupate == 10) {
			try {
				plina = true;
				wait();
			} catch (Exception e) {

			}
		}
		locuriOcupate++;
		System.out.println("+ A intrat o masina prin intrarea " + numeParcare + "\tTotal masini: " + locuriOcupate);
		
		if (goala)
		{
			goala = false;
			notify();
		}
	}	

	public synchronized void Iesire(String numeParcare) {
		if (locuriOcupate == 0) {
			try {
				goala = true;
				wait();
			} catch (Exception e) {

			}
		}	
		locuriOcupate--;
		System.out.println("- A iesit o masina prin iesirea " + numeParcare + "\tTotal masini: " + locuriOcupate);
		
		if (plina)
		{
			plina = false;
			notify();
		}
	}
}
