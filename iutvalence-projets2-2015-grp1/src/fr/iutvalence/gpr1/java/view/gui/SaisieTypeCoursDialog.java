package fr.iutvalence.gpr1.java.view.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class SaisieTypeCoursDialog extends JDialog implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Object> typeCours;
	private JButton okButton;
	private JButton cancelButton;
	private String typeCoursInput;
	
	public SaisieTypeCoursDialog(){
		this.setModal(true);
		this.setTitle("Libelle du Cours");
		this.setSize(350, 140);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		JPanel pan = new JPanel();
		pan.setBorder(BorderFactory.createTitledBorder("Veuillez saisir le type du cours"));
		pan.setLayout(new GridLayout(1, 2));
		Object[] elements = new Object[]{"CM", "TD", "TP"};
		this.typeCours = new JComboBox<Object>(elements);
		JLabel nomLabel = new JLabel("Type :");
		pan.add(nomLabel);
		pan.add(this.typeCours);
		
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
		if(e.getSource()==this.okButton){
			this.typeCoursInput=this.typeCours.getSelectedItem().toString();
			this.dispose();
		}
		if(e.getSource()==this.cancelButton){
			this.dispose();
		}
	}

	public String getTypeCours() {
		return this.typeCoursInput;
	}

}
