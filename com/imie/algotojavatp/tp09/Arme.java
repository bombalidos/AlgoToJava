/**
 * 
 */
package com.imie.algotojavatp.tp09;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */
public class Arme {
	private String nom;
	private int attaque;
	private int pa;
	private boolean equipee = false; 
	
	public Arme(String nom, int attaque, int pa) {
		this.setNom(nom);
		this.setAttaque(attaque);
		this.setPa(pa);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getAttaque() {
		return attaque;
	}
	public void setAttaque(int attaque) {
		if ( attaque < 0 )
			this.attaque = 0;
		else
			this.attaque = attaque;
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

	public boolean isEquipee() {
		return equipee;
	}
	public void setEquipee(boolean equipee) {
		this.equipee = equipee;
	}
	
}
