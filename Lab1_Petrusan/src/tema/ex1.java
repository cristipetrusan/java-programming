package tema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader flux = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("lungime : ");
		int lungime = Integer.parseInt(flux.readLine());
		System.out.print("latime : ");
		int latime = Integer.parseInt(flux.readLine());
		System.out.println("Perimetrul este : " + (2 * lungime + 2 * latime));
		System.out.println("Aria este : " + lungime * latime);
	}

}
