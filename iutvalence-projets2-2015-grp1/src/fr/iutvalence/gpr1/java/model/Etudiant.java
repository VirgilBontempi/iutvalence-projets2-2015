package fr.iutvalence.gpr1.java.model;

/** Classe Etudiant. */
public class Etudiant extends Personne {

	public static final int NBR_ABSENCE_BY_DEFAULT = 0;

	private String gprTP;
	
	private int grpTd;

	private int numEtudiant;

	private boolean absence;

	private int nbrAbsence;

	/**
	 * Constructeur de Etudiant.
	 * 
	 * @param nom
	 * @param prenom
	 * @param gprTP
	 * @param grpTD
	 * @param numEtudiant
	 * @param login
	 * @param password
	 */
	public Etudiant(String nom, String prenom, String gprTP, int grpTD, int numEtudiant, String login, String password) {
		super(nom, prenom, login, password);
		this.gprTP = gprTP;
		this.grpTd = grpTD;
		this.numEtudiant = numEtudiant;
		this.absence = true;
		this.nbrAbsence = NBR_ABSENCE_BY_DEFAULT;
	}

	/**
	 * Getter du groupe de TD.
	 * 
	 * @return grpTd
	 */
	public int getGrpTd() {
		return grpTd;
	}

	/**
	 * Getter du groupe de TP.
	 * 
	 * @return grpTp
	 */
	public String getgprTP() {
		return this.gprTP;
	}

	/**
	 * Getter du numéro d'etudiant.
	 * 
	 * @return numEtudiant
	 */
	public int getnumEtudiant() {
		return this.numEtudiant;
	}

	/**
	 * Getter du nombre d'absences.
	 * 
	 * @return nbrAbsence
	 */
	public int getNbrAbsence() {
		return this.nbrAbsence;
	}

	/**
	 * Getter de l'absence.
	 * 
	 * @return absence
	 */
	public boolean getAbsence() {
		return this.absence;
	}

	/**
	 * Setter de l'absence.
	 * 
	 * @param absence
	 */
	public void setAbsence(boolean absence) {
		this.absence = absence;
	}

	/**
	 * Ajoute une absence.
	 */
	public void addAbsence() {
		this.nbrAbsence = this.nbrAbsence++;
	}
	
	/**
	 * Définition de la méthode toString d'un Etudiant.
	 */
	public String toString(){
		return this.nom+","+this.prenom+","+this.gprTP+","+this.numEtudiant+ "/";
	}

}
