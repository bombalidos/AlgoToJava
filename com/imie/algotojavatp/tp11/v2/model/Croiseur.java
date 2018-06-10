/**
 * 
 */
package com.imie.algotojavatp.tp11.v2.model;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */
public class Croiseur extends Vaisseau {

	public Croiseur() {
		super(3, 4);
	}
	
	public String toString() {
		return String.format(
				"Croiseur\n\tID : %d\n\tLongueur : %d",
				this.getId(),
				this.getLenght()
				);
	}
}
