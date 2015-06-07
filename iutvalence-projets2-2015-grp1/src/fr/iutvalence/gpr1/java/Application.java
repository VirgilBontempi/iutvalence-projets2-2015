package fr.iutvalence.gpr1.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.PrintWriter;
import java.util.Iterator;

import fr.iutvalence.gpr1.java.model.Gestionnaire;
import fr.iutvalence.gpr1.java.model.ListePersonnes;
import fr.iutvalence.gpr1.java.view.IHM;
import fr.iutvalence.gpr1.java.view.console.IHMConsole;

public class Application {

        public static void main(String[] args) {
                File listEtudiants = new File("ListeEtudiants.txt");
                ListePersonnes a= new ListePersonnes(listEtudiants);
//                try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ListeEtudiants.txt", true)))) {
//                	Iterator i1 = a.getListEtudiants().iterator();
//                	for (int j = 0; j == a.getListEtudiants().size(); j++) {
//            			System.out.print(a.getListEtudiants().get(j) + " , ");
//            		}
//                }catch (IOException e) {
//                    //exception handling left as an exercise for the reader
//                }
                
                try {
					System.out.println(a.writeFileEtudiants(a.getListEtudiants()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                File listProfesseurs = new File("ListeProfesseurs.txt");
                File listAdministrateurs = new File("ListeAdministrateurs.txt");
                IHM monIHM = new IHMConsole();
                Gestionnaire monGestionnaire = new Gestionnaire(monIHM, listEtudiants, listProfesseurs, listAdministrateurs);
        }

}
