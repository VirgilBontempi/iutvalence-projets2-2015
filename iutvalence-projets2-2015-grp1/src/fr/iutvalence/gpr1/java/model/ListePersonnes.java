package fr.iutvalence.gpr1.java.model;

import java.io.*;
import java.util.LinkedList;

/** Classe ListePersonnes. */
public class ListePersonnes {
	private final File listPersonnes;

	/**
	 * Constructeur ListePersonnes.
	 * 
	 * @param listPersonnes
	 */
	public ListePersonnes(File listPersonnes) {
		this.listPersonnes = listPersonnes;
	}

	/**
	 * 
	 * @param listeEtudiants
	 */
	public void writeFileEtudiants(LinkedList<Etudiant> listeEtudiants) {

		
		// la d�finition du writer doit se faire ici
		// pour des raisons de visibilit�
		Writer writer = null;

		try {

			// ouverture d'un flux de sortie sur un fichier
			// a pour effet de cr�er le fichier
			writer = new FileWriter(this.listPersonnes);

			Etudiant etudiant_courant = null;

			String etudiant_temp = "";

			etudiant_courant = listeEtudiants.get(0);
			etudiant_temp += etudiant_courant.getNom() + ","
					+ etudiant_courant.getPrenom() + ","
					+ etudiant_courant.getgprTP() + ","
					+ etudiant_courant.getGrpTd() + ","
					+ etudiant_courant.getnumEtudiant() + ","
					+ etudiant_courant.getNbrAbsence() + ","
					+ etudiant_courant.getAbsence() + ","
					+ etudiant_courant.getLogin() + ","
					+ etudiant_courant.getPassword();

			for (int curseur = 1; curseur < listeEtudiants.size(); curseur++) {
				etudiant_courant = listeEtudiants.get(curseur);
				etudiant_temp += "/" + etudiant_courant.getNom() + ","
						+ etudiant_courant.getPrenom() + ","
						+ etudiant_courant.getgprTP() + ","
						+ etudiant_courant.getGrpTd() + ","
						+ etudiant_courant.getnumEtudiant() + ","
						+ etudiant_courant.getNbrAbsence() + ","
						+ etudiant_courant.getAbsence() + ","
						+ etudiant_courant.getLogin() + ","
						+ etudiant_courant.getPassword();
				
			}
			
			writer.write(etudiant_temp);


		} catch (IOException e) {

			// affichage du message d'erreur et de la pile d'appel
			e.printStackTrace();

		} finally {

			// il se peut que l'ouverture du flux ait �chou�,
			// et que ce writer n'ait pas �t� initialis�
			if (writer != null) {

				try {

					// la m�thode close de FileWriter appelle elle-m�me flush()
					writer.close();

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
		
	}

	
	/**
	 * 
	 * 
	 * @param listeProfesseurs
	 */
	public void writeFileProfesseurs(LinkedList<Professeur> listeProfesseurs) {

		
		// la d�finition du writer doit se faire ici
		// pour des raisons de visibilit�
		Writer writer = null;

		try {

			// ouverture d'un flux de sortie sur un fichier
			// a pour effet de cr�er le fichier
			writer = new FileWriter(this.listPersonnes);

			Professeur professeur_courant = null;

			String professeur_temp =  "";
			
			professeur_courant = listeProfesseurs.get(0);
			professeur_temp += professeur_courant.getNom() + ","
					+ professeur_courant.getPrenom() + ","
					+ professeur_courant.getLogin() + ","
					+ professeur_courant.getPassword();
			
			
			for (int curseur = 1; curseur < listeProfesseurs.size(); curseur++) {
				professeur_courant = listeProfesseurs.get(curseur);
				professeur_temp += "/" + professeur_courant.getNom() + ","
						+ professeur_courant.getPrenom() + ","
						+ professeur_courant.getLogin() + ","
						+ professeur_courant.getPassword();
						

			}
			
			writer.write(professeur_temp);


		} catch (IOException e) {

			// affichage du message d'erreur et de la pile d'appel
			e.printStackTrace();

		} finally {

			// il se peut que l'ouverture du flux ait �chou�,
			// et que ce writer n'ait pas �t� initialis�
			if (writer != null) {

				try {

					// la m�thode close de FileWriter appelle elle-m�me flush()
					writer.close();

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
		
	}


	/**
	 * 
	 * 
	 * @param listeAdministrateurs
	 */
	public void writeFileAdministrateurs(LinkedList<Administrateur> listeAdministrateurs) {

		// la d�finition du writer doit se faire ici
		// pour des raisons de visibilit�
		Writer writer = null;

		try {

			// ouverture d'un flux de sortie sur un fichier
			// a pour effet de cr�er le fichier
			writer = new FileWriter(this.listPersonnes);

			Administrateur administrateur_courant = null;

			String liste_temp = "";
			
			administrateur_courant = listeAdministrateurs.get(0);

			liste_temp += administrateur_courant.getNom() + ","
					+ administrateur_courant.getPrenom() + ","
					+ administrateur_courant.getLogin() + ","
					+ administrateur_courant.getPassword();
			
			for (int curseur = 1; curseur < listeAdministrateurs.size(); curseur++) {
				administrateur_courant = listeAdministrateurs.get(curseur);

				liste_temp += "/" + administrateur_courant.getNom() + ","
						+ administrateur_courant.getPrenom() + ","
						+ administrateur_courant.getLogin() + ","
						+ administrateur_courant.getPassword();
			}
			
			writer.write(liste_temp);

		} catch (IOException e) {

			// affichage du message d'erreur et de la pile d'appel
			e.printStackTrace();

		} finally {

			// il se peut que l'ouverture du flux ait �chou�,
			// et que ce writer n'ait pas �t� initialis�
			if (writer != null) {

				try {

					// la m�thode close de FileWriter appelle elle-m�me flush()
					writer.close();

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	/**
	 * Obtenir la liste Etudiants.
	 * 
	 * @return listeEtudiants
	 * @throws IOException
	 */
	public LinkedList<Etudiant> getListEtudiants() throws IOException {
		try (BufferedReader entry = new BufferedReader(new FileReader(this.listPersonnes))) {
			String readText = entry.readLine();

			LinkedList<Etudiant> listeEtudiants = new LinkedList<Etudiant>();
			if (readText != null) {
				String[] etudiants = readText.split("/");
				for (int index = 0; index < etudiants.length; index++) {
					String[] etudiant = etudiants[index].split(",");
					String nom = etudiant[0];
					String prenom = etudiant[1];
					String grpTP = etudiant[2];
					int grpTD = Integer.parseInt(etudiant[3]);
					int numEtudiant = Integer.parseInt(etudiant[4]);
					int nbrabsence = Integer.parseInt(etudiant[5]);
					String absence_temp = etudiant[6];
					String login = etudiant[7];
					String password = etudiant[8];
					boolean absence;
					if(absence_temp.equals("true")) {
					absence = true;
					}
					else
					{
					absence = false;
					}
										
					Etudiant etudiantCourant = new Etudiant(nom, prenom, grpTP, grpTD, numEtudiant, nbrabsence, absence, login, password);
					listeEtudiants.add(etudiantCourant);
				}
			}
			return listeEtudiants;
		}
	}

	
	/**
	 * Obtenir la liste Professeur.
	 * 
	 * @return listeProfesseur
	 * @throws IOException
	 */
	public LinkedList<Professeur> getListProfesseurs() throws IOException {
		try (BufferedReader entry = new BufferedReader(new FileReader(this.listPersonnes))) {
			String readText = entry.readLine();

			LinkedList<Professeur> listeProfesseurs = new LinkedList<Professeur>();
			if (readText != null) {
				String[] professeurs = readText.split("/");
				for (int index = 0; index < professeurs.length; index++) {
					String[] professeur = professeurs[index].split(",");
					String nom = professeur[0];
					String prenom = professeur[1];
					String login = professeur[2];
					String password = professeur[3];
					Professeur professeurCourant = new Professeur(nom, prenom,
							login, password);
					listeProfesseurs.add(professeurCourant);
				}
			}
			return listeProfesseurs;
		}
	}

	/**
	 * Obtenir la liste Administrateurs.
	 * 
	 * @return listeAdministrateurs
	 * @throws IOException
	 */
	public LinkedList<Administrateur> getListAdministrateurs()
			throws IOException {
		try (BufferedReader entry = new BufferedReader(new FileReader(this.listPersonnes))) {
			String readText = entry.readLine();

			LinkedList<Administrateur> listeAdministrateurs = new LinkedList<Administrateur>();
			if (readText != null) {
				String[] administrateurs = readText.split("/");
				for (int index = 0; index < administrateurs.length; index++) {
					String[] administrateur = administrateurs[index].split(",");
					String nom = administrateur[0];
					String prenom = administrateur[1];
					String login = administrateur[2];
					String password = administrateur[3];
					Administrateur administrateurCourant = new Administrateur(
							nom, prenom, login, password);
					listeAdministrateurs.add(administrateurCourant);
				}
			}
			return listeAdministrateurs;
		}
	}

//	/**
//	 * Obtenir un étudiant de la liste.
//	 * 
//	 * @param fichierEtudiants
//	 * @param login
//	 * @return etudiantCourant
//	 */
//	public Etudiant GetEtudiant(String login) {
//
//		Etudiant etudiantCourant = null;
//		LinkedList<Etudiant> listeEtudiants;
//		try {
//
//			listeEtudiants = getListEtudiants();
//
//			for (int curseur = 1; curseur < listeEtudiants.size(); curseur++) {
//				etudiantCourant = listeEtudiants.get(curseur);
//
//				if (etudiantCourant.getLogin().equals(login))
//					return etudiantCourant;
//
//			}
//			return etudiantCourant;
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return etudiantCourant;
//
//	}
//
//	/**
//	 * Ajouter un étudiant à la liste.
//	 * 
//	 * @param fichierEtudiants
//	 * @param etudiant
//	 */
//	public void ajouterEtudiant(Etudiant etudiant) {
//		LinkedList<Etudiant> listeEtudiants;
//		try {
//
//			listeEtudiants = getListEtudiants();
//
//			listeEtudiants.add(etudiant);
//			writeFileEtudiants(listeEtudiants);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
