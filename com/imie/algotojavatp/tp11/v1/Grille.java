/**
 * 
 */
package com.imie.algotojavatp.tp11.v1;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */
public class Grille {
	
	Vaisseau [][] carte;

	public Grille(int dimUn, int dimDeux) {
		super();
		this.setCarte( new Vaisseau[dimUn][dimDeux] );
	}

	public Vaisseau[][] getCarte() {
		return carte;
	}
	public void setCarte(Vaisseau[][] carte) {
		this.carte = carte;
	}
	
	public Vaisseau getCase(int x, int y) {
		return this.getCarte()[x][y];
	}
	public void setCase(int x, int y, Vaisseau vaisseau) {
		this.getCarte()[x][y] = vaisseau;
	}
	
	//TODO : il manque la prise en compte de l'absence de superposition
	public boolean placerVaisseau(Vaisseau vaisseau, int x, int y, boolean hztl) {
		boolean goodPlace = false;
		
		if ( hztl ) {
			if ( vaisseau.getLenght() + x < this.getCarte().length ) {
				for( int i = x; i <= vaisseau.getLenght(); i++ ) {
					setCase(i, y, vaisseau);
				}
				goodPlace = true;
			}
		}
		else {
			if ( vaisseau.getLenght() + y < this.getCarte()[0].length ) {
				for ( int i = y; i<= vaisseau.getLenght(); i++ ) {
					setCase(x, i, vaisseau);
				}
				goodPlace = true;
			}
		}
		
		return goodPlace;
	}
	
	public String toString() {
		StringBuilder grille = new StringBuilder();
		
		grille.append("    ");
		for (int i = 0; i < this.getCarte().length; i++) {
			grille.append(" ");
			grille.append(Integer.toString(i));
			grille.append(" ");
		}
		
		for (int i = 0; i < this.getCarte().length; i++) {
			for (int j = 0; j < this.getCarte()[i].length; j++) {
				grille.append(" ");
				grille.append(Integer.toString(j));
				grille.append(" | ");
				
				if ( this.getCase(i, j) != null )
					grille.append( this.getCase(i, j).getId() );
				else
					grille.append(" ");
				
				grille.append(" |");
			}
		}
		
		grille.append("    ");
		for (int i = 0; i < this.getCarte().length; i++) {
			grille.append(" ");
			grille.append(Integer.toString(i));
			grille.append(" ");
		}
		
		return grille.toString();
	}

}
