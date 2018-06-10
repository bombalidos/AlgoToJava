/**
 * 
 */
package com.imie.algotojavatp.tp09;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */
public class Personnage {
	
	private String nom;
	private int pdv;
	private int pa;
	private Armure armure;
	private Arme arme;
	
	public Personnage(String nom, int pdv, int pa, Armure armure, Arme arme) {
		this.setNom(nom);
		this.setPdv(pdv);
		this.setPa(pa);
		this.setArmure(armure);
		this.setArme(arme);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPdv() {
		return pdv;
	}
	public void setPdv(int pdv) {
		if ( pdv < 0 )
			this.pdv = 0;
		else
			this.pdv = pdv;
	}
	
	public int getPa() {
		return pa;
	}
	public void setPa(int pa) {
		if ( pa < 0 )
			this.pa = 0;
		else
			this.pa = pa;
	}
	
	public Armure getArmure() {
		return armure;
	}
	public void setArmure(Armure armure) {
		this.armure = armure;
	}
	
	public Arme getArme() {
		return arme;
	}
	public void setArme(Arme arme) {
		this.arme = arme;
	}
	
	public String toString() {
		StringBuilder perso = new StringBuilder();
		
		perso.append(this.getNom()).append(" a ");
		perso.append(this.getPa()).append(" points d'action, ");
		perso.append(this.getPdv()).append(" points de vie.\n");
		perso.append("Il est habillé avec un(e) ").append(this.getArmure().getNom());
		perso.append(" qui lui octroit ").append(this.getArmure().getDefense()).append(" points de défense.\n");
		perso.append("Enfin, il est équipé avec un(e) ").append(this.getArme().getNom());
		perso.append(" qui lui permet d'attaquer avec une force de ").append(this.getArme().getAttaque());
		perso.append(" en utilisant ").append(this.getArme().getPa()).append(" points d'action.");
		
		return perso.toString();
	}
}
