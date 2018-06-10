/**
 * 
 */
package com.imie.algotojavatp.tp11.v2.model;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */
public class Destroyer extends Vaisseau {

	public Destroyer() {
		super(2, 3);
	}
	
	public String toString() {
		return String.format(
				"Destroyer\n\tID : %d\n\tLongueur : %d",
				this.getId(),
				this.getLenght()
				);
	}
}
