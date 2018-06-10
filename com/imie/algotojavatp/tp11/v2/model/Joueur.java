/**
 * 
 */
package com.imie.algotojavatp.tp11.v2.model;

import com.imie.algotojavatp.tp11.v2.control.GrilleManager;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */

//TODO transformer le tableau de navire en List<Vaisseau>
public class Joueur {
	private String name;
	private GrilleManager grid;
	private Vaisseau [] vaisseaux;	
	
	/**
	 * @param name
	 * @param vaisseaux
	 */
	public Joueur(String name, Vaisseau[] vaisseaux, GrilleManager grid) {
		super();
		this.setName(name);
		this.setVaisseaux(vaisseaux);
		this.setGrid(grid);
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public GrilleManager getGrid() {
		return this.grid;
	}
	public void setGrid(GrilleManager grid) {
		this.grid = grid;
	}
	
	public Vaisseau[] getVaisseaux() {
		return this.vaisseaux;
	}
	public void setVaisseaux(Vaisseau[] vaisseaux) {
		this.vaisseaux = vaisseaux;
	}
}
