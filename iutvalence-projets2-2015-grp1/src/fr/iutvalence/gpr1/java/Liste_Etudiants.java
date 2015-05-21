package fr.iutvalence.gpr1.java;

public class Liste_Etudiants {
	
	private static final int NBRE_MAX_ETUDIANTS = 5;
 	private Etudiant[] etudiants = null;
 	
 	private int nombre_etudiants = 0;
 	
 	public Liste_Etudiants() {
 		etudiants = new Etudiant[NBRE_MAX_ETUDIANTS];
 		initListe_Etudiants();
 	}
 	
	private void initListe_Etudiants() {
			
				etudiants[0] = new Etudiant("BARNEOUD","Hector","TP3F",1,false, "barneohe", "abcd12", 0);
				nombre_etudiants++;
				etudiants[1] = new Etudiant("BONTEMPI","Virgil","TP3F",1,false, "bontemvi", "abcd12", 0);
				nombre_etudiants++;
				etudiants[2] = new Etudiant("BOULAKHSOUMI","Faris","TP3F",1,false, "boulakfa", "abcd12", 0);
				nombre_etudiants++;
				etudiants[3] = new Etudiant("CADET","Maxime","TP3F",1,false, "cadetmax", "abcd12", 0);
				nombre_etudiants++;
				etudiants[4] = new Etudiant("POLOCE","Antoine","TP3E",1,false, "polocean", "abcd12", 0);
				nombre_etudiants++;
		
	}
	
	
	public Etudiant getEtudiant(String login){
		
	    Etudiant etudiant_trouve = null;
		
		for(int i=0; i < NBRE_MAX_ETUDIANTS; i++) {
		if(etudiants[i].login() == login) etudiant_trouve = etudiants[i];	
		}
		
		return etudiant_trouve;
	}
	
	/*
	public void ajouterEtudiant(Etudiant etudiant){
		//TODO Faire la méthode
	}
	
	public void viderListe(int numeroListe){
		//TODO Faire la méthode
	}
	
	*/

}
