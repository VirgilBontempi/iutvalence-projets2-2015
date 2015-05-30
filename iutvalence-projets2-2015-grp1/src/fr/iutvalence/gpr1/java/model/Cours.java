package fr.iutvalence.gpr1.java.model;

/** Classe Cours. */
public class Cours {
	
	private String typeCours; //on fera des exceptions (tp, td ou cm)
	
	private String libelle;
	
	private Date date;
	
	/** Constructeur d'un cours. */
	private Liste_Etudiants listeEtudiant;
	Cours cours = new Cours();
	
	/** Getter du type d'un cours. */
	public String getTypeCours() {
		return typeCours;
	}

	/** Getter du libellé d'un cours. */
	public String getLibelle() {
		return libelle;
	}

	/** Setter d'une !absence. */
	public void setAbsences() {
	
			for(int i=0; i < listeEtudiant.getNbreMaxEtudiants(); i++) {
			if(listeEtudiant[i].getAbsense == true) listeEtudiant[i].addAbsence();	
			}
					

	}
	
	
}
