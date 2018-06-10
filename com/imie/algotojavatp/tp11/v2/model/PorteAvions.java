/**
 * 
 */
package com.imie.algotojavatp.tp11.v2.model;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */
public class PorteAvions extends Vaisseau {

	public PorteAvions() {
		super(4, 6);
	}
	
	public String toString() {
		return String.format(
				"Porte-avions\n\tID : %d\n\tLongueur : %d",
				this.getId(),
				this.getLenght()
				);
	}
}
