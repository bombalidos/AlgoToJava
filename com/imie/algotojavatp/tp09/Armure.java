/**
 * 
 */
package com.imie.algotojavatp.tp09;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */
public class Armure {
	
	private String nom;
	private int defense;
	private boolean equipee = true;
	
	public Armure (String nom, int defense) {
		this.setNom(nom);
		this.setDefense(defense);
	}

	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getDefense() {
		return this.defense;
	}
	public void setDefense(int defense) {
		if ( defense < 0 )
			this.defense = 0;
		else
			this.defense = defense;
	}
	
	public boolean isEquipee() {
		return this.equipee;
	}
	public void setEquipee(boolean equipee) {
		this.equipee = equipee;
	}
}
