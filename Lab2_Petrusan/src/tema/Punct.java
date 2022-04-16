package tema;

public class Punct {
	private double x;
	private double y;

	public Punct(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Punct(Punct pct) {
		this.x = pct.x;
		this.y = pct.y;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
