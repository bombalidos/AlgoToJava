/**
 * 
 */
package com.imie.algotojavatp.tp11.v2.model;

/**
 * @author Florian
 *
 */

//TODO donner à la case le navire qu'elle contient
public class Case {
	int x, y;
	Vaisseau vaisseau;
	boolean touche = false;

	public Case() throws Exception {
		this(0, 0);
	}
	public Case (int x, int y) throws Exception {
		if ( x >= 0 && y >= 0) {
			this.x = x;
			this.y = y;
		}
		else {
			throw new Exception("Invalid (x, y)");
		}
	}
	
	public int getX() {
		return this.x;
	}
	public void setX(int x) throws Exception {
		if ( x >= 0 )
			this.x = x;
		else
			throw new Exception("x < 0");
	}
	
	public int getY() {
		return this.y;
	}
	public void setY(int y) throws Exception {
		if ( y >= 0 )
			this.y = y;
		else
			throw new Exception("y < 0");
	}
	
	public boolean isTouche() {
		return this.touche;
	}
	public void setTouche(boolean touche) {
		this.touche = touche;
	}
	
	public Vaisseau getVaisseau() {
		return this.vaisseau;
	}
	public void setVaisseau(Vaisseau vaisseau) {
		this.vaisseau = vaisseau;
	}
	
	public boolean equals(Object c) {
		boolean flag = this.getX() == ((Case)c).getX() && this.getY() == ((Case) c).getY();
		return flag;
	}
	public String toString() {
		String txtCase = "%d, %d : %s";
		txtCase = String.format(txtCase, this.getX(), this.getY(), this.isTouche() ? "Touchée" : "Intouchée");
		
		return txtCase;
	}
}
