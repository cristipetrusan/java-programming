package tema2;

public class Intrare extends Thread{
	private String nume;
	private Parcare parcare;
	
	public Intrare(String nume, Parcare p)
	{
		super(nume);
		this.parcare = p;
	}
	
	public void run()
	{
		while(true)
		{
			parcare.Intrare(this.getName());
			try {
				sleep((int)(Math.random() * 1000));
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
}
