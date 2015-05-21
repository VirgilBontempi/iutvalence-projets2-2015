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

	public void setAbsences() {
	
			
			for(int i=0; i < NBRE_MAX_ETUDIANTS; i++) {
			if(etudiants[i].login() == login) etudiant_trouve = etudiants[i];	
			}
					

	}
	
	
}
