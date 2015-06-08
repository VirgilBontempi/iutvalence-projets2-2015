package fr.iutvalence.gpr1.java.model;

/** Classe Cours. */
public class Cours {

	private String typeCours;

	private String libelle;


	/**
	 * Constructeur de Cours.
	 * 
	 * @param typeCours
	 * @param libelle
	 */
	public Cours(String typeCours, String libelle) {
		this.typeCours = typeCours;
		this.libelle = libelle;
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
