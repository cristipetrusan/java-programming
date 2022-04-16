package tema;

import java.util.Random;

public class ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int a = rand.nextInt(30) + 1;
		int b = rand.nextInt(30) + 1;
		System.out.println(a + " " + b);
		while (a != b) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}

		System.out.println("cmmdc : " + a);
	}

}
