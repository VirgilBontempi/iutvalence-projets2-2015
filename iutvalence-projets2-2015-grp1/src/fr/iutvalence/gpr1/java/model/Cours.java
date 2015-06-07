package fr.iutvalence.gpr1.java.model;

import java.util.LinkedList;
import java.util.List;

/** Classe Cours. */
public class Cours {

	private String typeCours; // on fera des exceptions (tp, td ou cm)

	private String libelle;

	private Date date;

	private List<Etudiant> listeEtudiant;

	/**
	 * Constructeur de Cours.
	 * 
	 * @param typeCours
	 * @param libelle
	 * @param date
	 */
	public Cours(String typeCours, String libelle, Date date) {
		this.typeCours = typeCours;
		this.libelle = libelle;
		this.date = date;
		this.listeEtudiant = new LinkedList<Etudiant>();
	}

	/**
	 * Getter du type de cours.
	 * 
	 * @return typeCours
	 */
	public String getTypeCours() {
		return typeCours;
	}

	/**
	 * Getter du Libelle de cours.
	 * 
	 * @return libelle
	 */
	public String getLibelle() {
		return libelle;
	}

}
