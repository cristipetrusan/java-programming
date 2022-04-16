package tema;

public class Depunere extends Thread{
	private ContBancar cont;
	
	public Depunere(ContBancar cont)
	{
		this.cont = cont;
	}
	
	public void run()
	{
		while(true)
		{
			cont.Depunere((int)(Math.random() * 1000));
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
