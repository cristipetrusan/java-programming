package tema2;

public class MainApp {

	public static void main(String[] args) {
		Parcare p = new Parcare();
		Intrare in1 = new Intrare("1", p);
		Intrare in2 = new Intrare("2", p);
		Intrare in3 = new Intrare("3", p);
		Iesire out = new Iesire("out", p);
		
		in1.start();
		in2.start();
		in3.start();
		out.start();
	}

}
