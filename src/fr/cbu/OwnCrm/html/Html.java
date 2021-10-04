package fr.cbu.OwnCrm.html;

import fr.cbu.OwnCrm.balise.Balise;

public class Html extends Balise {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Balise head = new Balise();

	Balise body = new Balise();

	public Html() {
		this.setNom("html");

		this.head.setNom("head");
		this.body.setNom("body");

		this.add(head);
		this.add(body);

	}

	public Balise getHead() {
		return head;
	}

	public void setHead(Balise head) {
		this.head = head;
	}

	public Balise getBody() {
		return body;
	}

	public void setBody(Balise body) {
		this.body = body;
	}
}
