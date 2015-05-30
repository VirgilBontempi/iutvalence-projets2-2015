package fr.iutvalence.gpr1.java.model;

/** Classe Date. */
public class Date {
	private int jour;
	private int mois;
	private int annee;
	
	public Date(int jour, int mois, int annee) {
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	/** Getter d'un jour. */
	public int getJour() {
		return jour;
	}

	/** Getter d'un mois. */
	public int getMois() {
		return mois;
	}

	/** Getter d'une année. */
	public int getAnnee() {
		return annee;
	}

}
