package tema;

import java.util.Random;

public class ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int a = rand.nextInt(20);
		System.out.println(a);

		int first = 0;
		int second = 1;
		int aux;

		boolean flag = false;
			
		while (second < 20) {
			aux = first;
			first = second;
			second = aux + first;
			if (a == first || a == second)
				flag = true;
		}
		if (flag)
			System.out.println("Numar Fibonacci");
		else
			System.out.println("NU e Fibonacci");

	}
}