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

public class inputAdmin2Dialog extends JDialog implements ActionListener{
	
	private JTextField login;
	private JButton okButton;
	private JButton cancelButton;
	private String administrateur;

	public inputAdmin2Dialog(){
		this.setModal(true);
		this.setTitle("Saisie");
		this.setSize(400, 200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		JPanel pan = new JPanel();
		pan.setBorder(BorderFactory
				.createTitledBorder("Informations sur l'adiministrateur"));
		pan.setLayout(new GridLayout(1,2));
		
		this.login = new JTextField();
		JLabel loginLabel = new JLabel("Saisir le login :");
		pan.add(loginLabel);
		pan.add(this.login);

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
		if (e.getSource()==this.okButton && this.login.getText().length() != 0){
			this.administrateur = this.login.getText();
			
			this.dispose();
		}
		if (e.getSource()==this.cancelButton && this.login.getText().length() != 0) {
			this.dispose();
		}	
	}

	public String getAdmin() {
		return this.administrateur;
	}

}
