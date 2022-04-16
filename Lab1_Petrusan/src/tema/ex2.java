package tema;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int counter = 0;
		float mediaAritmetica = 0;
		float suma = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int curent;
		
		Scanner flux = new Scanner(new File("in.txt"));

		while (flux.hasNext()) {
			counter += 1;
			curent = Integer.parseInt(flux.nextLine());
			if (curent < min)
				min = curent;
			if (curent > max)
				max = curent;
			suma += curent;
		}
		mediaAritmetica = suma / counter;
		System.out.println("Suma : " + suma);
		System.out.println("Media aritmetica : " + mediaAritmetica);
		System.out.println("Maxim : " + max);
		System.out.println("Minim : " + min);
		
		File fisierOut = new File("out.txt");
		fisierOut.createNewFile();

		PrintStream fluxOut = new PrintStream(fisierOut);
		fluxOut.println("Suma : " + suma);
		fluxOut.println("Media aritmetica : " + mediaAritmetica);
		fluxOut.println("Maxim : " + max);
		fluxOut.println("Minim : " + min);
		fluxOut.close();

	}

}
