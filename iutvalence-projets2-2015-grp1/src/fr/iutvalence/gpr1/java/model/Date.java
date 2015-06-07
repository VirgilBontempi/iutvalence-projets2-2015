package fr.iutvalence.gpr1.java.model;

/** Classe Date. */
public class Date {
	private int jour;
	private int mois;
	private int annee;

	/**
	 * Constructeur de Date.
	 * 
	 * @param jour
	 * @param mois
	 * @param annee
	 */
	public Date(int jour, int mois, int annee) {
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	/**
	 * Getter du jour.
	 * 
	 * @return jour
	 */
	public int getJour() {
		return jour;
	}

	/**
	 * Getter du mois.
	 * 
	 * @return mois
	 */
	public int getMois() {
		return mois;
	}

	/**
	 * Getter de l'annee.
	 * 
	 * @return annee
	 */
	public int getAnnee() {
		return annee;
	}

}
