package fr.iutvalence.gpr1.java;


import java.io.File;

import fr.iutvalence.gpr1.java.model.Gestionnaire;
import fr.iutvalence.gpr1.java.view.IHM;
import fr.iutvalence.gpr1.java.view.console.IHMConsole;
import fr.iutvalence.gpr1.java.view.gui.IHMGraphical;

import javax.swing.SwingUtilities;

/** Classe Application. */
public class Application {

	public static void main(String[] args) {

		File listEtudiants = new File("ListeEtudiants.txt");
		File listProfesseurs = new File("ListeProfesseurs.txt");
		File listAdministrateurs = new File("ListeAdministrateurs.txt");
		IHM monIHM = new IHMConsole();
		Gestionnaire monGestionnaire = new Gestionnaire(monIHM, listEtudiants,
				listProfesseurs, listAdministrateurs);
		monGestionnaire.starter();
//		((IHMGraphical) monIHM).initWindow(monGestionnaire);
//		SwingUtilities.invokeLater((Runnable) monIHM);
	}
}
