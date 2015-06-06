package fr.iutvalence.gpr1.java.model;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fr.iutvalence.gpr1.java.view.IHM;

/** Classe Gestionnaire */
public class Gestionnaire
{

	private IHM monIHM;

	private List<Etudiant> listEtudiants;
	private List<Professeur> listProfesseurs;
	private List<Administrateur> listAdministrateurs;

	public Gestionnaire(IHM monIHM, File fichierEtudiants,
			File fichierProfesseurs, File fichierAdministrateurs)
	{
		this.monIHM = monIHM;
		ListePersonnes fichierEtudiant = new ListePersonnes(fichierEtudiants);
		try
		{
			this.listEtudiants = fichierEtudiant.getListEtudiants();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		ListePersonnes fichierProfesseur = new ListePersonnes(
				fichierProfesseurs);
		try
		{
			this.listProfesseurs = fichierProfesseur.getListProfesseurs();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		ListePersonnes fichierAdministrateur = new ListePersonnes(fichierAdministrateurs);
		try
		{
			this.listAdministrateurs = fichierAdministrateur.getListAdministrateurs();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Identifie un Admin.
	 * 
	 * @return boolean
	 */
	public boolean identificationAdministrateur()
	{
		String login = this.monIHM.saisieLogin();
		String password = this.monIHM.saisiePassword();
		if (this.rechercheProfesseur(login, password))
			return true;
		return false;
	}

	public boolean rechercheAdministrateur(String login, String password)
	{
		Iterator<Administrateur> iterator = this.listAdministrateurs.iterator();
		while (iterator.hasNext())
		{
			Administrateur currentAdministrator = iterator.next();
			if (currentAdministrator.getLogin().equals(login))
			{
				if (currentAdministrator.getPassword().equals(password))
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Identifie un Professeur.
	 * 
	 * @return boolean
	 */
	public boolean identificationProfesseur()
	{
		String login = this.monIHM.saisieLogin();
		String password = this.monIHM.saisiePassword();
		if (this.rechercheProfesseur(login, password))
			return true;
		return false;
	}

	private boolean rechercheProfesseur(String login, String password)
	{
		Iterator<Professeur> iterator = this.listProfesseurs.iterator();
		while (iterator.hasNext())
		{
			Professeur currentTeacher = iterator.next();
			if (currentTeacher.getLogin().equals(login))
			{
				if (currentTeacher.getPassword().equals(password))
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Identifie un Etudiant et change le statut 'absent' en 'non absent'.
	 * 
	 * @return void
	 */
	public void identificationEtudiant()
	{
		String login = this.monIHM.saisieLogin();
		String password = this.monIHM.saisiePassword();
		Etudiant etudiant = this.rechercheEtudiant(login, password);

		if (etudiant != null)
		{
			int index = this.listEtudiants.indexOf(etudiant);
			etudiant.setAbsence(false);
			this.listEtudiants.set(index, etudiant);
		}

	}

	private Etudiant rechercheEtudiant(String login, String password)
	{
		Iterator<Etudiant> iterator = this.listEtudiants.iterator();
		while (iterator.hasNext())
		{
			Etudiant currentStudent = iterator.next();
			if (currentStudent.getLogin().equals(login))
			{
				if (currentStudent.getPassword().equals(password))
				{
					return currentStudent;
				}
			}
		}
		return null;
	}

	/** Valide une absence. */
	public void determinerAbsence(Etudiant etudiant)
	{
		if(etudiant.getAbsence()){
			etudiant.addAbsence();
			
			
		}
	}
	
	/** Ajoute un administrateur */
	public void ajouterAdministrateur(Administrateur administrateur) {
		this.listAdministrateurs.add(administrateur);
	}

	/** Supprime un administrateur. */
	public void supprimerAdministrateur(Administrateur administrateur) {
		this.listAdministrateurs.remove(administrateur);
	}

	/** Ajoute un professeur. */
	public void ajouterProfesseur(Professeur professeur) {
		this.listProfesseurs.add(professeur);
	}

	/** Supprime un professeur. */
	public void supprimerProfesseur(Professeur professeur) {
		this.listProfesseurs.remove(professeur);
	}

//	public void ajoutPresent(Etudiant etudiant)
//	{
//		if(etudiant.getAbsence()=false){
//			
//		}
//	}
	
}
