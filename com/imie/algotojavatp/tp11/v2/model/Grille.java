/**
 * 
 */
package com.imie.algotojavatp.tp11.v2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */

//TODO faire le "toString()"
public class Grille {
	
	int dimX, dimY;
	List<Case> cases = new ArrayList<Case>();

	/*
	 * Constructeur
	 */
	public Grille(int dimX, int dimY) throws Exception {
		super();
		this.setDimX(dimX);
		this.setDimY(dimY);
	}

	/*
	 * Getters and setters (properties)
	 */
	public int getDimX() {
		return this.dimX;
	}
	public void setDimX(int dimX) throws Exception {
		if ( dimX > 0 )
			this.dimX = dimX;
		else
			throw new Exception("X dimension <= 0");
	}
	
	public int getDimY() {
		return this.dimY;
	}
	public void setDimY(int dimY) throws Exception {
		if ( dimY > 0 )
			this.dimY = dimY;
		else
			throw new Exception("Y dimension <= 0");
	}
	
	public List<Case> getCases() {
		return this.cases;
	}
	public void setCases(List<Case> cases) {
		this.cases = cases;
	}

	public Case getCase(int x, int y) throws Exception {
		Case caseATrouver = new Case(x, y);
 		Case caseTrouvee = null;
		
		if ( this.getCases().contains(caseATrouver) )
			caseTrouvee = this.getCases().get( this.getCases().indexOf(caseATrouver) );
		
		return caseTrouvee;
	} 
	public void addCases(List<Case> cases) {
		this.cases.addAll(cases);
	}
}
