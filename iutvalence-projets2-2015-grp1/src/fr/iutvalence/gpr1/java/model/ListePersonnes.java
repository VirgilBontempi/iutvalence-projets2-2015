package fr.iutvalence.gpr1.java.model;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.basic.BasicComboPopup.ListDataHandler;

public class ListePersonnes {
	private final String PathListeAdministrateur;
	private final String PathListeEtudiants;
	private final String PathListeProfesseurs;


	private final File listPersonnes;
 	
	public ListePersonnes(File listPersonnes){
		this.listPersonnes = listPersonnes;
		this.PathListeAdministrateur = "temp/ListeAdministrateurs.txt";
		this.PathListeEtudiants = "temp/ListeEtudiants.txt";
		this.PathListeProfesseurs = "temp/ListeProfesseurs.txt";
	}
	
	public void writeFileEtudiants(LinkedList<Etudiant> listeEtudiants) {

	    // définition d'un fichier
	   File fichier =  new File(PathListeEtudiants) ;
	   
	    // la définition du writer doit se faire ici
	    // pour des raisons de visibilité
	   Writer writer = null ;

	    try {

	       // ouverture d'un flux de sortie sur un fichier
	       // a pour effet de créer le fichier
	      writer =  new FileWriter(fichier) ;
	      
	        Etudiant etudiant_courant = null;

	         for(int curseur=1; curseur<listeEtudiants.size(); curseur++)
	         {
	                 etudiant_courant = listeEtudiants.get(curseur);
	       	         writer.write(etudiant_courant.getNom() + "," + etudiant_courant.getPrenom() + "," + etudiant_courant.getgprTP() + "," + etudiant_courant.getnumEtudiant() + "," + etudiant_courant.getLogin() + "," + etudiant_courant.getPassword() + "|") ;
	                 
	

	         }
	        

	   }  catch (IOException e) {

	       // affichage du message d'erreur et de la pile d'appel
	      System.out.println("Erreur " + e.getMessage()) ;
	      e.printStackTrace() ;
	      
	   }  finally {
	      
	       // il se peut que l'ouverture du flux ait échoué, 
	       // et que ce writer n'ait pas été initialisé
	       if (writer != null) {

	          try {

	             // la méthode close de FileWriter appelle elle-même flush()
	            writer.close() ;
						
	         }  catch (IOException e) {

	            System.out.println("Erreur " + e.getMessage()) ;
	            e.printStackTrace() ;
	         }
	      }
	   }
		
	}
	 public LinkedList<Etudiant> getListEtudiants() throws IOException {
		try (BufferedReader entry = new BufferedReader(new FileReader(this.listPersonnes))) {
				String readText = entry.readLine();
		
				LinkedList<Etudiant> listeEtudiants = new LinkedList<Etudiant>();
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
 	
 	public LinkedList<Professeur> getListProfesseurs() throws IOException {
		try (BufferedReader entry = new BufferedReader(new FileReader(this.listPersonnes))) {
			String readText = entry.readLine();
	
			LinkedList<Professeur> listeProfesseurs = new LinkedList<Professeur>();
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
 	
 	public LinkedList<Administrateur> getListAdministrateurs() throws IOException {
		try (BufferedReader entry = new BufferedReader(new FileReader(this.listPersonnes))) {
			String readText = entry.readLine();
	
			LinkedList<Administrateur> listeAdministrateurs = new LinkedList<Administrateur>();
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

	
	
    public Etudiant GetEtudiant(File fichierEtudiants, String login) {
        
        Etudiant etudiant_courant = null;
        LinkedList<Etudiant> listeEtudiants;
        ListePersonnes fichierEtudiant = new ListePersonnes(fichierEtudiants);
    	try
		{
	
		listeEtudiants = fichierEtudiant.getListEtudiants();

         for(int curseur=1; curseur<listeEtudiants.size(); curseur++)
         {
                 etudiant_courant = listeEtudiants.get(curseur);
                 
                 if(etudiant_courant.getLogin().equals(login))
                         return etudiant_courant;

         }
                return etudiant_courant;
                
		}  		catch(IOException e)
		{
			e.printStackTrace();
		}
    	
        return etudiant_courant;

         }

    
	public void ajouterEtudiant(File fichierEtudiants, Etudiant etudiant){
	        LinkedList<Etudiant> listeEtudiants;
	        ListePersonnes fichierEtudiant = new ListePersonnes(fichierEtudiants);
	    	try
			{
		
			listeEtudiants = fichierEtudiant.getListEtudiants();

			listeEtudiants.add(etudiant);
			writeFileEtudiants(listeEtudiants);
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