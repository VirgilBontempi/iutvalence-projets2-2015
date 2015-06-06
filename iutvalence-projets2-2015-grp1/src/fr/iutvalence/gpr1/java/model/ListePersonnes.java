package fr.iutvalence.gpr1.java.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.basic.BasicComboPopup.ListDataHandler;

public class ListePersonnes {
	
	private final File listPersonnes;
 	
	public ListePersonnes(File listPersonnes){
		this.listPersonnes = listPersonnes;
	}
	
	 public List<Etudiant> getListEtudiants() throws IOException {
		try (BufferedReader entry = new BufferedReader(new FileReader(this.listPersonnes))) {
				String readText = entry.readLine();
		
				List<Etudiant> listeEtudiants = new LinkedList<Etudiant>();
				if (readText!=null) {
					String[] etudiants = readText.split("|");
					for (int index=0; index < etudiants.length; index++) {
						String[] etudiant = etudiants[index].split(",");
						String nom = etudiant[0];
						String prenom = etudiant[1];
						String grpTp = etudiant[2];
						int numEtudiants = Integer.parseInt(etudiants[3]);
						String login = etudiant[4];
						String password = etudiant[5];
						Etudiant etudiantCourant = new Etudiant(nom, prenom, grpTp, numEtudiants, login, password);
						listeEtudiants.add(etudiantCourant);
						}
					}		
			return listeEtudiants;
			}	
		}
 	
 	public List<Professeur> getListProfesseurs() throws IOException {
		try (BufferedReader entry = new BufferedReader(new FileReader(this.listPersonnes))) {
			String readText = entry.readLine();
	
			List<Professeur> listeProfesseurs = new LinkedList<Professeur>();
			if (readText!=null) {
				String[] professeurs = readText.split("|");
				for (int index=0; index < professeurs.length; index++) {
					String[] professeur = professeurs[index].split(",");
					String nom = professeur[0];
					String prenom = professeur[1];
					String login = professeur[2];
					String password = professeur[3];
					Professeur professeurCourant = new Professeur(nom, prenom, login, password);
					listeProfesseurs.add(professeurCourant);
					}
				}		
			return listeProfesseurs;
			}	
		}
 	
 	public List<Administrateur> getListAdministrateurs() throws IOException {
		try (BufferedReader entry = new BufferedReader(new FileReader(this.listPersonnes))) {
			String readText = entry.readLine();
	
			List<Administrateur> listeAdministrateurs = new LinkedList<Administrateur>();
			if (readText!=null) {
				String[] administrateurs = readText.split("|");
				for (int index=0; index < administrateurs.length; index++) {
					String[] administrateur = administrateurs[index].split(",");
					String nom = administrateur[0];
					String prenom = administrateur[1];
					String login = administrateur[2];
					String password = administrateur[3];
					Administrateur administrateurCourant = new Administrateur(nom, prenom, login, password);
					listeAdministrateurs.add(administrateurCourant);
					}
				}		
			return listeAdministrateurs;
			}	
		}
 	
 	public List<Etudiant> getListEtudiantsAbs() throws IOException {
		try (BufferedReader entry = new BufferedReader(new FileReader(this.listPersonnes))) {
			String readText = entry.readLine();
	
			List<Etudiant> listeEtudiantsAbs = new LinkedList<Etudiant>();
			if (readText!=null) {
				String[] etudiantsAbs = readText.split("|");
				for (int index=0; index < etudiantsAbs.length; index++) {
					String[] etudiantAbs = etudiantsAbs[index].split(",");
					String nom = etudiantAbs[0];
					String prenom = etudiantAbs[1];
					String grpTp = etudiantAbs[2];
					int numEtudiants = Integer.parseInt(etudiantsAbs[3]);
					String login = etudiantAbs[4];
					String password = etudiantAbs[5];
					Etudiant etudiantAbsCourant = new Etudiant(nom, prenom, grpTp, numEtudiants, login, password);
					listeEtudiantsAbs.add(etudiantAbsCourant);
					}
				}		
		return listeEtudiantsAbs;
		}	
	}

	public List<Etudiant> getListEtudiantsPresent() throws IOException {
		try (BufferedReader entry = new BufferedReader(new FileReader(this.listPersonnes))) {
			String readText = entry.readLine();
	
			List<Etudiant> listeEtudiantsPresent = new LinkedList<Etudiant>();
			if (readText!=null) {
				String[] etudiantsPresent = readText.split("|");
				for (int index=0; index < etudiantsPresent.length; index++) {
					String[] etudiantPresent = etudiantsPresent[index].split(",");
					String nom = etudiantPresent[0];
					String prenom = etudiantPresent[1];
					String grpTp = etudiantPresent[2];
					int numEtudiants = Integer.parseInt(etudiantsPresent[3]);
					String login = etudiantPresent[4];
					String password = etudiantPresent[5];
					Etudiant etudiantPresentCourant = new Etudiant(nom, prenom, grpTp, numEtudiants, login, password);
					listeEtudiantsPresent.add(etudiantPresentCourant);
					}
				}		
		return listeEtudiantsPresent;
		}	
	}	
	
//	public Etudiant getEtudiant(String login){
//		
//	    Etudiant etudiant_trouve = null;
//		
//		for(int i=0; i < NBRE_MAX_ETUDIANTS; i++) {
//		if(etudiants[i].login() == login) etudiant_trouve = etudiants[i];	
//		}
//		
//		return etudiant_trouve;
//	}
//	

	public void ajouterEtudiant(Etudiant etudiant){
		try {
			getListEtudiants().add(etudiant);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void viderListe(){
		try {
			getListEtudiants().clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
