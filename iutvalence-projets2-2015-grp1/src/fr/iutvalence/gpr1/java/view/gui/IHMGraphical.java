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
		return ((SaisieIdentifiantsDialog) identifiant).getLogin();
	}

	@Override
	public String saisiePassword() {
		JDialog password = new SaisiePasswordDialog();
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Administrateur inputAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inputAdmin2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayNewAdminAdded(Administrateur nouvelAdmin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAdmin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayAdminRemoved(Administrateur administrateur) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inputProf2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayNewProfAdded(Professeur professeur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProf() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayProfRemoved(Professeur professeur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherListeProf(List<Professeur> listProf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputAdmin2Invalide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputProf2Invalide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.interfaceAdmin){
			this.affichageIdAdministrateur();
			Administrateur admin = this.gestionnaire.identificationAdministrateur();
			if (admin != null) {
				this.idValide(admin);
				this.gestionnaire.choixAdministrateur();
			} else {
				this.idInvalide();
			}
		}
		
	}

}
