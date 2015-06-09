package fr.iutvalence.gpr1.java.view.gui;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class menuCoursWindow extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton oui;
	private JButton non;
	private int choice;


	public menuCoursWindow() {
		this.setModal(true);
		this.setTitle("Choix d'arrêt du cours");
		this.setSize(350, 250);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		JPanel pan = new JPanel();
		pan.setBorder(BorderFactory.createTitledBorder("Choisissez une action"));
		pan.setLayout(new GridLayout(2, 1));
		this.oui = new JButton("Arrêter le cours");
		this.oui.addActionListener(this);
		pan.add(this.oui);
		this.non = new JButton("Poursuivre l'appel");
		this.non.addActionListener(this);
		pan.add(this.non);
		this.add(pan);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.oui) {
			this.choice=1;
			this.dispose();
		}
		if (e.getSource()==this.non) {
			this.choice=2;
			this.dispose();
		}
	}
	
	
	public int getChoice() {
		return this.choice;
	}

}
