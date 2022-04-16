package tema2;

public class Iesire extends Thread{
	private String nume;
	private Parcare parcare;
	
	public Iesire(String nume, Parcare p)
	{
		super(nume);
		this.parcare = p;
	}
	
	public void run()
	{
		while(true)
		{
			parcare.Iesire(this.getName());
			try {
				sleep((int)(Math.random() * 1000));
			}
			catch(Exception e)
			{
				
			}
		}
	}}
