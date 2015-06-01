package fr.iutvalence.gpr1.java.model;

import java.util.LinkedList;
import java.util.List;

/** Classe Cours. */
public class Cours {
	
	private String typeCours; //on fera des exceptions (tp, td ou cm)
	
	private String libelle;
	
	private Date date;
	
	private List<Etudiant> listeEtudiant;
	
	/** Constructeur d'un cours. */
	public Cours(String typeCours, String libelle, Date date){
		this.typeCours = typeCours;
		this.libelle = libelle;
		this.date = date;
		this.listeEtudiant = new LinkedList<Etudiant>();
	}
	
	
	
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
