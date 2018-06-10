/**
 * 
 */
package com.imie.algotojavatp.tp11.v2.model;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */
public class Corvette extends Vaisseau {

	/**
	 * @param id
	 * @param lenght
	 */
	public Corvette() {
		super(1, 1);
	}
	
	public String toString() {
		return String.format(
				"Corvette\n\tID : %d\n\tLongueur : %d",
				this.getId(),
				this.getLenght()
				);
	}
}
