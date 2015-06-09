package fr.iutvalence.gpr1.java.view.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.iutvalence.gpr1.java.model.Gestionnaire;

public class adminMenuWindow extends JDialog implements ActionListener{


	private static final long serialVersionUID = 1L;
	private JButton ajouterAdmin;
	private JButton supprimerAdmin;
	private JButton ajouterProf;
	private JButton supprimerProf;
	private JButton listeAdmin;
	private JButton listeProf;
	private JButton menuPrincipal;
	private int choice;


	public adminMenuWindow() {
		this.setModal(true);
		this.setTitle("Menu Administrateur");
		this.setSize(350, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		JPanel pan = new JPanel();
		pan.setBorder(BorderFactory.createTitledBorder("Choisissez une action"));
		pan.setLayout(new GridLayout(7,1));
		this.ajouterAdmin = new JButton("Ajouter un Administrateur");
		this.ajouterAdmin.addActionListener(this);
		pan.add(this.ajouterAdmin);
		this.supprimerAdmin = new JButton("Supprimer un Administrateur");
		this.supprimerAdmin.addActionListener(this);
		pan.add(this.supprimerAdmin);
		this.ajouterProf = new JButton("Ajouter un Professeur");
		this.ajouterProf.addActionListener(this);
		pan.add(this.ajouterProf);
		this.supprimerProf = new JButton("Supprimer un Professeur");
		this.supprimerProf.addActionListener(this);
		pan.add(this.supprimerProf);
		this.listeAdmin = new JButton("Voir la liste des Administrateurs");
		this.listeAdmin.addActionListener(this);
		pan.add(this.listeAdmin);
		this.listeProf = new JButton("Voir la liste des Professeurs");
		this.listeProf.addActionListener(this);
		pan.add(this.listeProf);
		this.menuPrincipal = new JButton("Retour au Menu Principal");
		this.menuPrincipal.addActionListener(this);
		pan.add(this.menuPrincipal);
		this.add(pan);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.ajouterAdmin) {
			this.choice=1;
			this.dispose();
		}
		if (e.getSource()==this.supprimerAdmin) {
			this.choice=2;
			this.dispose();
		}
		if (e.getSource()==this.ajouterProf) {
			this.choice=3;
			this.dispose();
		}
		if (e.getSource()==this.supprimerProf) {
			this.choice=4;
			this.dispose();
		}
		if (e.getSource()==this.listeAdmin) {
			this.choice=5;
			this.dispose();
		}
		if (e.getSource()==this.listeProf) {
			this.choice=6;
			this.dispose();
		}
		if (e.getSource()==this.menuPrincipal) {
			this.choice=7;
			this.dispose();
		}		
	}
	
	
	public int getChoice() {
		return this.choice;
	}

}
