package fr.iutvalence.gpr1.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.PrintWriter;
import java.util.Iterator;

import fr.iutvalence.gpr1.java.model.Etudiant;
import fr.iutvalence.gpr1.java.model.Gestionnaire;
import fr.iutvalence.gpr1.java.model.ListePersonnes;
import fr.iutvalence.gpr1.java.view.IHM;
import fr.iutvalence.gpr1.java.view.console.IHMConsole;

public class Application {

        public static void main(String[] args) {

        File FichierListe = new File("ListeEtudiants.txt");
        
        ListePersonnes a= new ListePersonnes(FichierListe);     
                
        Etudiant test = new Etudiant("AAAAAA","BBBBB","TP3F",6,"login","password");
        
        try {
			a.getListEtudiants();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        a.ajouterEtudiant(FichierListe, test);
        
        try {
			a.getListEtudiants();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
     
        
        
       
                
        File listProfesseurs = new File("ListeProfesseurs.txt");
        File listAdministrateurs = new File("ListeAdministrateurs.txt");
        IHM monIHM = new IHMConsole();
//                Gestionnaire monGestionnaire = new Gestionnaire(monIHM, listEtudiants, listProfesseurs, listAdministrateurs);
        }

}
