package fr.cbu.OwnCrm.html;

public class Totaux extends Div {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public Totaux(String title, String value, String suffixe) {

		this.setStyle("width:98%");

		Span spanTitle = new Span(title);
		spanTitle.setStyle("width:54%;display:inline-block;font-weight:bold");

		Span spanValue = new Span(value);
		spanValue.setStyle("width:22%;text-align:right;display:inline-block");

		Span spanSuffixe = new Span(suffixe);
		spanSuffixe.setStyle("width:18%;display:inline-block");

		this.add(spanTitle);
		this.add(spanValue);
		this.add(spanSuffixe);

	}

}
