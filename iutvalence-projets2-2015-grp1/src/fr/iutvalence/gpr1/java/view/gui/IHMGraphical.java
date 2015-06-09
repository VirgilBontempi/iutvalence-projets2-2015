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
		this.gestionnaire=gestionnaire;
		this.setLayout(null);
//		JLabel title = new JLabel("Mon Application");
//		title.setBounds(512,50, 360, 100);
//		this.add(title);
		this.interfaceAdmin = new JButton("Administrateur");
		this.interfaceAdmin.setBounds(335, 90, 360, 160);
		this.interfaceAdmin.addActionListener(this);
		this.add(this.interfaceAdmin);
		this.interfaceProf = new JButton("Professeur");
		this.interfaceProf.setBounds(335, 260, 360, 160);
		
		this.add(this.interfaceProf);
		this.quitter = new JButton("Quitter");
		this.quitter.setBounds(335, 430, 360, 160);
		this.add(this.quitter);
		
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
		// TODO Auto-generated method stub
	}

	@Override
	public void affichageIdProfesseur() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affichageIdEtudiant() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String saisieTypeCours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saisieLibelleCours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saisieGrpTp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saisieGrpTd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int menuCours() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void affichageIdProfesseur2() {
		// TODO Auto-generated method stub
		
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
		JOptionPane.showMessageDialog(this, "L'adminstrateur "+nouvelAdmin.getPrenom()+" "+nouvelAdmin.getNom()+" a bien été ajoutée"," Information ",JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void removeAdmin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayAdminRemoved(Administrateur administrateur) {
		JOptionPane.showMessageDialog(this, "L'administrateur "+administrateur.getPrenom()+" "+administrateur.getNom()+" a bien été supprimé");
	}

	@Override
	public void afficherListeAdmin(List<Administrateur> listAdmin) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void affichageListeAbsence(LinkedList<Etudiant> listAbs) {
		// TODO Auto-generated method stub
		
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
		JOptionPane.showMessageDialog(this, "Le professeur "+professeur.getPrenom()+" "+professeur.getNom()+" a bien été ajoutée"," Information ",JOptionPane.INFORMATION_MESSAGE);
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
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public void newAddedPersonneExists() {
		JOptionPane.showMessageDialog(this, "L'identifiant est déjà utilisé"," Attention ",JOptionPane.WARNING_MESSAGE);
		
	}

}
