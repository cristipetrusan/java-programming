package tema;

public class Extragere extends Thread{
	ContBancar cont;
	
	public Extragere(ContBancar cont)
	{
		this.cont = cont;
	}
	
	public void run()
	{
		while(true)
		{
			cont.Extragere((int)(Math.random() * 1000));
			try
			{
				sleep((int)(Math.random() * 1000));
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
}
