package fr.iutvalence.gpr1.java;

import fr.iutvalence.gpr1.java.model.Gestionnaire;
import fr.iutvalence.gpr1.java.view.IHM;
import fr.iutvalence.gpr1.java.view.console.IHMConsole;

public class Application {

	public static void main(String[] args) {
		IHM monIHM = new IHMConsole();
		Gestionnaire monGestionnaire = new Gestionnaire(monIHM);
	}

}
