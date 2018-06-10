/**
 * 
 */
package com.imie.algotojavatp.tp11.v1;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */
public class Joueur {
	private String name;
	private Vaisseau [] vaisseaux;	
	
	/**
	 * @param name
	 * @param vaisseaux
	 */
	public Joueur(String name, Vaisseau[] vaisseaux) {
		super();
		this.setName(name);
		this.setVaisseaux(vaisseaux);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Vaisseau[] getVaisseaux() {
		return vaisseaux;
	}
	public void setVaisseaux(Vaisseau[] vaisseaux) {
		this.vaisseaux = vaisseaux;
	}
}
