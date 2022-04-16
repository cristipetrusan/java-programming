package tema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader flux = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Numarul dv : ");
		int counter = 0;
		int n = Integer.parseInt(flux.readLine());
		System.out.print("Divizorii lui " + n + " sunt : " + 1 + " ");
		for (int i = 2; i <= n / 2; i++)
			if (n % i == 0) {
				System.out.print(i + " ");
				counter++;
			}
		System.out.print(n);
		if (counter == 0)
			System.out.print("\nNumarul este PRIM");
	}

}
