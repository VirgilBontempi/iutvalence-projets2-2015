package fr.iutvalence.gpr1.java.view.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.iutvalence.gpr1.java.model.Administrateur;
import fr.iutvalence.gpr1.java.model.Etudiant;
import fr.iutvalence.gpr1.java.model.Gestionnaire;
import fr.iutvalence.gpr1.java.model.Personne;
import fr.iutvalence.gpr1.java.model.Professeur;
import fr.iutvalence.gpr1.java.view.IHM;

public class IHMGraphical extends JFrame implements IHM, Runnable, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton interfaceAdmin;
	private JButton interfaceProf;
	private JButton quitter;
	private Gestionnaire gestionnaire;

	public IHMGraphical() {
		this.setTitle("Mon Appli");
		this.setSize(1024, 720);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initWindow(Gestionnaire gestionnaire){
		JPanel background = new BackgroundPanel();
		this.add(background);
		this.gestionnaire=gestionnaire;
		background.setLayout(null);
		this.interfaceAdmin = new JButton("Administrateur");
		this.interfaceAdmin.setBounds(335, 230, 360, 100);
		this.interfaceAdmin.addActionListener(this);
		background.add(this.interfaceAdmin);
		this.interfaceProf = new JButton("Professeur");
		this.interfaceProf.setBounds(335, 350, 360, 100);
		this.interfaceProf.addActionListener(this);
		background.add(this.interfaceProf);
		this.quitter = new JButton("Quitter");
		this.quitter.setBounds(335, 470, 360, 100);
		this.quitter.addActionListener(this);
		background.add(this.quitter);
		
	}
	@Override
	public void run() {
		this.setVisible(true);	
	}

	@Override
	public String saisieLogin() {
		JDialog identifiant = new SaisieIdentifiantsDialog();
		identifiant.setVisible(true);
		return ((SaisieIdentifiantsDialog) identifiant).getLogin();
	}

	@Override
	public String saisiePassword() {
		JDialog password = new SaisiePasswordDialog();
		password.setVisible(true);
		return ((SaisiePasswordDialog) password).getPassword();
	}

	@Override
	public int showMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void affichageIdAdministrateur() {
		JOptionPane.showMessageDialog(this, "Bienvenu Administrateur, veuillez vous identifier"," Information ",JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void affichageIdProfesseur() {
		JOptionPane.showMessageDialog(this, "Bienvenu Professeur, veuillez vous identifier"," Information ",JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void affichageIdEtudiant() {
		JOptionPane.showMessageDialog(this, "Bonjour Etudiant, veuillez vous identifier"," Information ",JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void idValide(Personne personne) {
		JOptionPane.showMessageDialog(this, "Bonjour "+personne.getPrenom()+" "+personne.getNom()," Information ",JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void idInvalide() {
		JOptionPane.showMessageDialog(this, "Identifiant invalide"," Attention ",JOptionPane.WARNING_MESSAGE);
		
	}

	@Override
	public void elevePresent() {
		JOptionPane.showMessageDialog(this, "Vou avez été noté présent"," Information ",JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public String saisieTypeCours() {
		JDialog typeCours = new SaisieTypeCoursDialog();
		typeCours.setVisible(true);
		return ((SaisieTypeCoursDialog) typeCours).getTypeCours();
	}

	@Override
	public String saisieLibelleCours() {
		JDialog libelle = new SaisieLibelleCoursDialog();
		libelle.setVisible(true);
		return ((SaisieLibelleCoursDialog) libelle).getLibelleCours();
	}

	@Override
	public String saisieGrpTp() {
		JDialog grpTp = new SaisieGrpTpDialog();
		grpTp.setVisible(true);
		return ((SaisieGrpTpDialog) grpTp).getGrpTp();
	}

	@Override
	public String saisieGrpTd() {
		JDialog grpTd = new SaisieGrpTdDialog();
		grpTd.setVisible(true);
		return ((SaisieGrpTdDialog) grpTd).getGrpTd();
	}

	@Override
	public int menuCours() {
		JDialog menuCours = new menuCoursWindow();
		menuCours.setVisible(true);
		return ((menuCoursWindow) menuCours).getChoice();
	}

	@Override
	public void affichageIdProfesseur2() {
		JOptionPane.showMessageDialog(this, "Re-bonjour Professeur, veuillez vous identifier pour valider votre choix"," Information ",JOptionPane.INFORMATION_MESSAGE);
		
		
	}

	@Override
	public int adminMenu() {
		JDialog adminMenu = new adminMenuWindow();
		adminMenu.setVisible(true);
		return ((adminMenuWindow) adminMenu).getChoice();
	}

	@Override
	public Administrateur inputAdmin() {
		JDialog inputAdmin = new inputAdminDialog();
		inputAdmin.setVisible(true);
		return ((inputAdminDialog) inputAdmin).getAdmin();
	}

	@Override
	public String inputAdmin2() {
		JDialog inputAdmin2 = new inputAdmin2Dialog();
		inputAdmin2.setVisible(true);
		return ((inputAdmin2Dialog) inputAdmin2).getAdmin();
	}

	@Override
	public void displayNewAdminAdded(Administrateur nouvelAdmin) {
		JOptionPane.showMessageDialog(this, "L'adminstrateur "+nouvelAdmin.getPrenom()+" "+nouvelAdmin.getNom()+" a bien été ajouté"," Information ",JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void removeAdmin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayAdminRemoved(Administrateur administrateur) {
		JOptionPane.showMessageDialog(this, "L'administrateur "+administrateur.getPrenom()+" "+administrateur.getNom()+" a bien été supprimé"," Information ", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void afficherListeAdmin(List<Administrateur> listAdmin) {
		JOptionPane.showMessageDialog(this, this.gestionnaire.displayListAdmin(listAdmin)," Liste des Administrateurs ", JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void affichageListeAbsence(LinkedList<Etudiant> listAbs) {
		JOptionPane.showMessageDialog(this, this.gestionnaire.displayListEtudiants(listAbs)," Liste des Absents ", JOptionPane.INFORMATION_MESSAGE);
	
	}

	@Override
	public Professeur inputProf() {
		JDialog inputProf = new inputProfDialog();
		inputProf.setVisible(true);
		return ((inputProfDialog) inputProf).getProf();
	}

	@Override
	public String inputProf2() {
		JDialog inputProf2 = new inputProf2Dialog();
		inputProf2.setVisible(true);
		return ((inputProf2Dialog) inputProf2).getProf();
	}

	@Override
	public void displayNewProfAdded(Professeur professeur) {
		JOptionPane.showMessageDialog(this, "Le professeur "+professeur.getPrenom()+" "+professeur.getNom()+" a bien été ajouté"," Information ",JOptionPane.INFORMATION_MESSAGE);
		}

	@Override
	public void removeProf() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayProfRemoved(Professeur professeur) {
		JOptionPane.showMessageDialog(this, "Le professeur "+professeur.getPrenom()+" "+professeur.getNom()+" a bien été supprimé");
		
	}

	@Override
	public void afficherListeProf(List<Professeur> listProf) {
		JOptionPane.showMessageDialog(this, this.gestionnaire.displayListProf(listProf)," Information ", JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void inputAdmin2Invalide() {
		JOptionPane.showMessageDialog(this, "Identifiant invalide"," Attention ",JOptionPane.WARNING_MESSAGE);
		
	}

	@Override
	public void inputProf2Invalide() {
		JOptionPane.showMessageDialog(this, "Identifiant invalide"," Attention ",JOptionPane.WARNING_MESSAGE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.interfaceAdmin){
			this.gestionnaire.actionsAdmin();
			}
		if (e.getSource() == this.interfaceProf){
			this.gestionnaire.actionsProf();
			}
		if (e.getSource() == this.quitter){
			this.gestionnaire.quit();
			}
		
	}

	@Override
	public void newAddedPersonneExists() {
		JOptionPane.showMessageDialog(this, "L'identifiant est déjà utilisé"," Attention ",JOptionPane.WARNING_MESSAGE);
		
	}

}
