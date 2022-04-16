package tema;

public class Parabola {

	private double a;
	private double b;
	private double c;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----Ex1 parabola-----\n");
		Parabola para1 = new Parabola(1, 2, 4);
		Parabola para2 = new Parabola(para1);
		para2.setB(para2.getB() * -1);
		para1.afisare();
		para2.afisare();
		System.out.println("Mijlocul distantei dintre: " + para1.calculVarf().toString() + " si "
				+ para2.calculVarf().toString() + " este " + Parabola.calculMijloc(para1, para2).toString());

	}

	public Parabola(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Parabola(Parabola para) {
		this.a = para.a;
		this.b = para.b;
		this.c = para.c;
	}

	public void afisare() {
		System.out.print("f(x)=" + a + "x^2 ");
		if (b >= 0)
			System.out.print("+" + b + "x ");
		else
			System.out.print(b + "x ");
		if (c >= 0)
			System.out.println("+" + c);
		else
			System.out.println(c);

	}

	public Punct calculVarf() {
		Punct pct = new Punct(-b / (2 * a), (-b * b + 4 * a * c) / (4 * a));
		return pct;
	}

	public static Punct calculMijloc(Parabola p1, Parabola p2) {
		double x = (p1.calculVarf().getX() + p2.calculVarf().getX()) / 2;
		double y = (p1.calculVarf().getY() + p2.calculVarf().getY()) / 2;
		Punct pct = new Punct(x, y);
		return pct;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

}
