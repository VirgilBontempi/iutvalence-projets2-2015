package fr.iutvalence.gpr1.java.view.console;

import java.util.Scanner;

import fr.iutvalence.gpr1.java.view.IHM;

public class IHMConsole implements IHM {
	
	Scanner scanner = new Scanner(System.in);
	
	public String saisieLogin() {
		System.out.println("Saisissez vos identifiants");
		return scanner.nextLine();
	}

	public String saisiePassword() {
		return scanner.nextLine();
	}
	
	

}
