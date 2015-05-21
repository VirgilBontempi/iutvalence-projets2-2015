package fr.iutvalence.gpr1.java;

public class Cours {
	
	private String typeCours; //on fera des exceptions (tp, td ou cm)
	
	private String libelle;
	
	private Date date;
	
	Cours cours = new Cours();

	public String getTypeCours() {
		return typeCours;
	}

	public String getLibelle() {
		return libelle;
	}
	
}
