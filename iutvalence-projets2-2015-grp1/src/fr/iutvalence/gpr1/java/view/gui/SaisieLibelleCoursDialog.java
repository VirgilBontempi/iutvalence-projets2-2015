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

public class SaisieLibelleCoursDialog extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField libelle;
	private JButton okButton;
	private JButton cancelButton;
	private String libelleInput;
	
	public SaisieLibelleCoursDialog(){
		this.setModal(true);
		this.setTitle("Libelle du Cours");
		this.setSize(350, 140);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		JPanel pan = new JPanel();
		pan.setBorder(BorderFactory.createTitledBorder("Veuillez saisir le libellé du cours"));
		pan.setLayout(new GridLayout(1, 2));
		this.libelle = new JTextField();
		JLabel nomLabel = new JLabel("Libellé :");
		pan.add(nomLabel);
		pan.add(this.libelle);
		
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
		if(e.getSource()==this.okButton && this.libelle.getText().length() != 0){
			this.libelleInput=this.libelle.getText();
			this.dispose();
		}
		if(e.getSource()==this.cancelButton){
			this.dispose();
		}
	}

	public String getLibelleCours() {
		return this.libelleInput;
	}

}
