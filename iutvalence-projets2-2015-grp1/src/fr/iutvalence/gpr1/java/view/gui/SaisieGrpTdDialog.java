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

public class SaisieGrpTdDialog extends JDialog implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Object> grpTd;
	private JButton okButton;
	private JButton cancelButton;
	private String grpTdInput;
	
	public SaisieGrpTdDialog(){
		this.setModal(true);
		this.setTitle("Groupe de TD");
		this.setSize(350, 140);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		JPanel pan = new JPanel();
		pan.setBorder(BorderFactory.createTitledBorder("Veuillez saisir le groupe de TD avec lequel vous avez cours"));
		pan.setLayout(new GridLayout(1, 2));
		Object[] elements = new Object[]{"1", "2", "3"};
		this.grpTd = new JComboBox<Object>(elements);
		JLabel nomLabel = new JLabel("Groupe TD :");
		pan.add(nomLabel);
		pan.add(this.grpTd);
		
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
			this.dispose();
		}
		if(e.getSource()==this.cancelButton){
			this.dispose();
		}
	}

	public String getGrpTd() {
		return this.grpTdInput;
	}


}
