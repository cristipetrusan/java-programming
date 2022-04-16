package tema;

public class ContBancar {
	private int sold = 0;
	private boolean disponibil = false;
	private int sumaBlocata = 0;

	public synchronized void Extragere(int suma) {

		if (suma < sold) 
		{
			sold -= suma;
		} 
		else 
		{
			try 
			{
				disponibil = false;
				sumaBlocata = suma;
				wait();
			} 
			catch (Exception e) 
			{

			}
		}
		System.out.println("- A fost extrasa suma de " + suma + " din cont. \tSold ramas: " + sold);
	}

	public synchronized void Depunere(int suma) 
	{
		this.sold += suma;
		System.out.println("+ A fost depusa suma de " + suma + " in cont. \tSold ramas: " + sold);

		if (!disponibil && sold >= sumaBlocata)
		{
			notify();
		}

	}
}
