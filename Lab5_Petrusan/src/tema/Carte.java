package tema;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Carte {
	private String titlu;
	private String autor;
	private int anAparitie;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("in.txt"));
		Map<Integer, Carte> map = new HashMap<Integer, Carte>();
		while (sc.hasNext()) {
			String sir[] = sc.nextLine().split(";");
			map.put(Integer.parseInt(sir[0]), new Carte(sir[1], sir[2], Integer.parseInt(sir[3])));
		}

		System.out.println(map);
		System.out.println();
		
		List<Carte> list = new ArrayList<Carte>();

		for (var key : map.keySet()) {
			System.out.println("Key: " + key + ", Value: " + map.get(key));
			list.add(map.get(key));
		}
		System.out.println();

		for (var item : list) {
			System.out.println(item);
		}
		System.out.println();
		
		list.sort(Comparator.comparing(Carte::getTitlu));
		for (var item : list) {
			System.out.println(item);
		}
		System.out.println();
	}

	public Carte(String titlu, String autor, int anAparitie) {
		this.titlu = titlu;
		this.autor = autor;
		this.anAparitie = anAparitie;
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnAparitie() {
		return anAparitie;
	}

	public void setAnAparitie(int anAparitie) {
		this.anAparitie = anAparitie;
	}

	public String toString() {
		return this.titlu + ", " + this.autor + "," + this.anAparitie;
	}

}
