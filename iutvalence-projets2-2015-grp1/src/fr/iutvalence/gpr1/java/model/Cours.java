package fr.iutvalence.gpr1.java.model;

public class Cours {
	
	private String typeCours; //on fera des exceptions (tp, td ou cm)
	
	private String libelle;
	
	private Date date;
	
	private Liste_Etudiants listeEtudiant;
	Cours cours = new Cours();

	public String getTypeCours() {
		return typeCours;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setAbsences() {
	
			for(int i=0; i < listeEtudiant.getNbreMaxEtudiants(); i++) {
			if(listeEtudiant[i].getAbsense == true) listeEtudiant[i].addAbsence();	
			}
					

	}
	
	
}
