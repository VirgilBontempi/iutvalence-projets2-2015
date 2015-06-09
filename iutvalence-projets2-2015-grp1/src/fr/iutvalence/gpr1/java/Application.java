package fr.iutvalence.gpr1.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.swing.SwingUtilities;

import fr.iutvalence.gpr1.java.model.Etudiant;
import fr.iutvalence.gpr1.java.model.Gestionnaire;
import fr.iutvalence.gpr1.java.model.ListePersonnes;
import fr.iutvalence.gpr1.java.view.IHM;
import fr.iutvalence.gpr1.java.view.console.IHMConsole;
import fr.iutvalence.gpr1.java.view.gui.IHMGraphical;

public class Application {

	public static void main(String[] args) {

		File listEtudiants = new File("ListeEtudiants.txt");
		File listProfesseurs = new File("ListeProfesseurs.txt");
		File listAdministrateurs = new File("ListeAdministrateurs.txt");
		IHM monIHM = new IHMConsole();
		Gestionnaire monGestionnaire = new Gestionnaire(monIHM, listEtudiants,
				listProfesseurs, listAdministrateurs);
		monGestionnaire.starter();
		//((IHMGraphical) monIHM).initWindow(monGestionnaire);
		//SwingUtilities.invokeLater((Runnable) monIHM);
	}
}
