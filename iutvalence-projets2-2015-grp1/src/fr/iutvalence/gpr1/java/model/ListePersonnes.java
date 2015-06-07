package fr.iutvalence.gpr1.java.model;

import java.io.*;
import java.util.LinkedList;

public class ListePersonnes {
	private final String PathListeAdministrateur;
	private final String PathListeEtudiants;
	private final String PathListeProfesseurs;

	private final File listPersonnes;

	/**
	 * Constructeur ListePersonnes.
	 * 
	 * @param listPersonnes
	 */
	public ListePersonnes(File listPersonnes) {
		this.listPersonnes = listPersonnes;
		this.PathListeAdministrateur = "temp/ListeAdministrateurs.txt";
		this.PathListeEtudiants = "temp/ListeEtudiants.txt";
		this.PathListeProfesseurs = "temp/ListeProfesseurs.txt";
	}

	/**
	 * 
	 * @param listeEtudiants
	 * @return
	 */
	public File writeFileEtudiants(LinkedList<Etudiant> listeEtudiants) {

		// d�finition d'un fichier
		File fichier = new File(PathListeEtudiants);

		// la d�finition du writer doit se faire ici
		// pour des raisons de visibilit�
		Writer writer = null;

		try {

			// ouverture d'un flux de sortie sur un fichier
			// a pour effet de cr�er le fichier
			writer = new FileWriter(fichier);

			Etudiant etudiant_courant = null;

			for (int curseur = 1; curseur < listeEtudiants.size(); curseur++) {
				etudiant_courant = listeEtudiants.get(curseur);
				writer.write(etudiant_courant.getNom() + ","
						+ etudiant_courant.getPrenom() + ","
						+ etudiant_courant.getgprTP() + ","
						+ etudiant_courant.getnumEtudiant() + ","
						+ etudiant_courant.getLogin() + ","
						+ etudiant_courant.getPassword() + "|");

			}

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
		return fichier;

	}

	/**
	 * Obtenir la liste Etudiants.
	 * 
	 * @return listeEtudiants
	 * @throws IOException
	 */
	public LinkedList<Etudiant> getListEtudiants() throws IOException {
		try (BufferedReader entry = new BufferedReader(new FileReader(
				this.listPersonnes))) {
			String readText = entry.readLine();

			LinkedList<Etudiant> listeEtudiants = new LinkedList<Etudiant>();
			if (readText != null) {
				String[] etudiants = readText.split("/");
				for (int index = 0; index < etudiants.length; index++) {
					String[] etudiant = etudiants[index].split(",");
					String nom = etudiant[0];
					String prenom = etudiant[1];
					String grpTp = etudiant[2];
					int numEtudiants = Integer.parseInt(etudiant[3]);
					String login = etudiant[4];
					String password = etudiant[5];
					Etudiant etudiantCourant = new Etudiant(nom, prenom, grpTp,
							numEtudiants, login, password);
					listeEtudiants.add(etudiantCourant);
					System.out.println(listeEtudiants);
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
		try (BufferedReader entry = new BufferedReader(new FileReader(
				this.listPersonnes))) {
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
		try (BufferedReader entry = new BufferedReader(new FileReader(
				this.listPersonnes))) {
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

	/**
	 * Obtenir un étudiant de la liste.
	 * 
	 * @param fichierEtudiants
	 * @param login
	 * @return etudiantCourant
	 */
	public Etudiant GetEtudiant(File fichierEtudiants, String login) {

		Etudiant etudiantCourant = null;
		LinkedList<Etudiant> listeEtudiants;
		ListePersonnes fichierEtudiant = new ListePersonnes(fichierEtudiants);
		try {

			listeEtudiants = fichierEtudiant.getListEtudiants();

			for (int curseur = 1; curseur < listeEtudiants.size(); curseur++) {
				etudiantCourant = listeEtudiants.get(curseur);

				if (etudiantCourant.getLogin().equals(login))
					return etudiantCourant;

			}
			return etudiantCourant;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return etudiantCourant;

	}

	/**
	 * Ajouter un étudiant à la liste.
	 * 
	 * @param fichierEtudiants
	 * @param etudiant
	 */
	public void ajouterEtudiant(File fichierEtudiants, Etudiant etudiant) {
		LinkedList<Etudiant> listeEtudiants;
		ListePersonnes fichierEtudiant = new ListePersonnes(fichierEtudiants);
		try {

			listeEtudiants = fichierEtudiant.getListEtudiants();

			listeEtudiants.add(etudiant);
			writeFileEtudiants(listeEtudiants);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Vide la liste d'etudiants.
	 */
	public void viderListe() {
		try {
			getListEtudiants().clear();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}