package fr.iutvalence.gpr1.java.model;


/** Classe Etudiant. */
public class Etudiant extends Personne {
	
	public static final int NBR_ABSENCE_BY_DEFAULT = 0;

	private String gprTp;
	
	private int numEtudiant;
	
	private boolean absence;
	
	private int nbrAbsence;
	
	
	public Etudiant(String nom, String prenom, String gprTp, int numEtudiant, String login, String password) {
	super(nom, prenom, login, password);
	this.gprTp = gprTp;
	this.numEtudiant = numEtudiant;
	this.absence = true;
	this.nbrAbsence = NBR_ABSENCE_BY_DEFAULT;
	}
	
	/**
	 * Compteur du nombre d'absence en foncion du statut 'absent' après dentification.
	 * @return nbrAbsence
	 */
	public int getNbrAbsence(){
		return this.nbrAbsence;
	}
	
	/** Getter d'une absence. */
	public boolean getAbsence() {
		return this.absence;
	}

	/** Setter d'une absence. */
	public void setAbsence(boolean absence) {
		this.absence = absence;
	}

	
	/** Ajoute une absence. */
	public void addAbsence() {
		this.nbrAbsence = this.nbrAbsence++;
	}

	

}
