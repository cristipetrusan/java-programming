package tema;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Angajat {
	private String nume;
	private String post;
	private LocalDate dataAngajarii;
	private float salariu;

	public Angajat(String nume, String post, LocalDate dataAngajarii, float salariu) {
		this.nume = nume;
		this.post = post;
		this.dataAngajarii = dataAngajarii;
		this.salariu = salariu;
	}

	public String toString() {
		return nume + "," + post + "," + dataAngajarii.toString() + "," + salariu;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<Angajat> listaAngajati = new ArrayList<Angajat>();
		Scanner sc = new Scanner(new File("in.txt"));
		while (sc.hasNext()) {
			String[] s = sc.nextLine().split(",");
			String[] d = s[2].split("\\.");
			LocalDate data = LocalDate.of(Integer.parseInt(d[2]), Integer.parseInt(d[1]), Integer.parseInt(d[0]));
			Angajat a = new Angajat(s[0], s[1], data, Float.parseFloat(s[3]));
			listaAngajati.add(a);
		}
		
		System.out.println("2.");
		for (var a : listaAngajati)
		{
			System.out.println(a);
		}
		
		System.out.println("\n3. Salarii mai mici de 2500");
		listaAngajati
		.stream()
		.filter((a) -> a.salariu < 2500)
		.forEach(System.out::println);
		
		System.out.println("\n4. Creare lista cu angajati pana in aprilie 2021, functii de conducere");
		List<Angajat> lista4 = listaAngajati
				.stream()
				.filter((a) -> (a.dataAngajarii.compareTo(LocalDate.of(2021, 5, 1)) < 0) && (a.post.equals("sef") || a.post.equals("director")))
				.collect(Collectors.toList());
		for (var variabila : lista4)
			System.out.println(variabila);
		
		System.out.println("\n5. Angajati care nu au functii de conducere, ordine descrescatoare ");		
		listaAngajati
		.stream()
		.filter(a -> !(a.post.equals("sef") || a.post.equals("director")))
		.sorted((a,b)->a.salariu < b.salariu ? 1 : -1)
		.forEach(System.out::println);
				
		System.out.println("\n6. Extrage lista de nume, cu majuscule");
		sc.close();
		List<String> lista6 = listaAngajati
		.stream()
		.map(a -> a.getNume().toUpperCase())
		.collect(Collectors.toList());
		
		for (var aux : lista6)
			System.out.println(aux);
		
		System.out.println("\n7. Doar salariile mai mici de 3000");
		listaAngajati
		.stream()
		.filter(a -> a.salariu < 3000)
		.map(a -> a.getSalariu())
		.forEach(System.out::println);
		
		
		
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public LocalDate getDataAngajarii() {
		return dataAngajarii;
	}

	public void setDataAngajarii(LocalDate dataAngajarii) {
		this.dataAngajarii = dataAngajarii;
	}

	public float getSalariu() {
		return salariu;
	}

	public void setSalariu(float salariu) {
		this.salariu = salariu;
	}

}
