package fr.iutvalence.gpr1.java.view.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import fr.iutvalence.gpr1.java.model.Administrateur;

public class inputAdminDialog extends JDialog implements ActionListener{

	private JTextField nom;
	private JTextField prenom;
	private JTextField login;
	private JTextField password;
	private JButton okButton;
	private JButton cancelButton;
	private Administrateur administrateur;

	public inputAdminDialog(){
		this.setModal(true);
		this.setTitle("Saisie");
		this.setSize(400, 200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		JPanel pan = new JPanel();
		pan.setBorder(BorderFactory
				.createTitledBorder("Informations sur l'adiministrateur"));
		pan.setLayout(new GridLayout(4,2));
		this.nom = new JTextField();
		JLabel nomLabel = new JLabel("Saisir un nom :");
		pan.add(nomLabel);
		pan.add(this.nom);
		this.prenom = new JTextField();
		JLabel prenomLabel = new JLabel("Saisir un prenom :");
		pan.add(prenomLabel);
		pan.add(this.prenom);
		this.login = new JTextField();
		JLabel loginLabel = new JLabel("Saisir le login :");
		pan.add(loginLabel);
		pan.add(this.login);
		this.password = new JTextField();
		JLabel passwordLabel = new JLabel("Saisir le mot de passe :");
		pan.add(passwordLabel);
		pan.add(this.password);

		JPanel control = new JPanel();
		this.okButton = new JButton("Valider");
		this.okButton.setPreferredSize(new Dimension(90, 30));
		control.add(this.okButton);
		this.okButton.addActionListener(this);

		this.cancelButton = new JButton("Annuler");
		this.cancelButton.setPreferredSize(new Dimension(90, 30));
		control.add(this.cancelButton);
		this.cancelButton.addActionListener(this);

		JSplitPane split = new JSplitPane();
		split.setOrientation(JSplitPane.VERTICAL_SPLIT);
		split.setTopComponent(pan);
		split.setBottomComponent(control);
		split.setDividerSize(0);
		split.setEnabled(false);
		this.add(split);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.okButton && this.nom.getText().length() != 0 && this.prenom.getText().length() != 0 && this.login.getText().length() != 0 && this.password.getText().length() != 0){
			this.administrateur = new Administrateur(this.nom.getText(), this.prenom.getText(), this.login.getText(), this.password.getText());
			this.dispose();
		}
		if (e.getSource()==this.cancelButton) {
			this.dispose();
		}	
	}

	public Administrateur getAdmin() {
		return this.administrateur;
	}

}
