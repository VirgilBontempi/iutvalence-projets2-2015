package fr.iutvalence.gpr1.java.model;

import java.util.*;

public class Liste_Admin {
	
	
	private static final int NBRE_MAX_ADMIN = 5;
	private Administrateur[] admin = null;


	private int nombre_admin = 0;
	public Liste_Admin() {
 		admin = new Administrateur[NBRE_MAX_ADMIN];
 		initListe_Admin();
 	}
	
	private void initListe_Admin() {
		admin[0] = new Administrateur("BARNEOUD","barneohe", "abcd12");
		nombre_admin++;
		admin[1] = new Administrateur("BONTEMPI","bontemvi", "abcd12");
		nombre_admin++;
		admin[2] = new Administrateur("BOULAKHSOUMI","boulakfa", "abcd12");
		nombre_admin++;
		admin[3] = new Administrateur("CADET","cadetmax", "abcd12");
		nombre_admin++;
		admin[4] = new Administrateur("POLOCE","polocean", "abcd12");
		nombre_admin++;
	}
	
	public Administrateur[] getAdmin() {
		return admin;
	}

}
