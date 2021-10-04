package fr.cbu.OwnCrm.test;

import java.io.FileWriter;
import java.io.IOException;

import fr.cbu.OwnCrm.balise.Balise;

public class TestBalise {

	public static void main(String[] args) throws IOException {

		Balise body = new Balise();
		body.setNom("body");
		body.setValue("Oh la beau body");

		Balise title = new Balise();
		title.setNom("h1");
		title.setContenu("C'est mon titre");

		body.add(title);

		Balise contenu = new Balise();
		contenu.setNom("p");
		contenu.setContenu("Ca c'est un top contenu");

		body.add(contenu);

		Balise table = new Balise();
		table.setNom("table");

		body.add(table);

		Balise tr = new Balise();
		tr.setNom("tr");

		table.add(tr);

		Balise td = new Balise();
		td.setNom("td");
		td.setContenu("Ceci est une valeur");

		tr.add(td);

		System.out.println(body);

		FileWriter out = new FileWriter("test.html");
		out.write(body.toString());
		out.flush();
		out.close();

	}
}