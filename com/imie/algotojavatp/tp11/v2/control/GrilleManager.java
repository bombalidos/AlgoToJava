/**
 * 
 */
package com.imie.algotojavatp.tp11.v2.control;

import java.util.ArrayList;
import java.util.List;

import com.imie.algotojavatp.tp11.v2.model.Case;
import com.imie.algotojavatp.tp11.v2.model.Grille;
import com.imie.algotojavatp.tp11.v2.model.Vaisseau;

/**
 * @author Florian
 * @date 2018-06-05
 *
 */
public class GrilleManager {
	
	Grille grid;

	/**
	 * @throws Exception 
	 * 
	 */
	public GrilleManager() throws Exception {
		this.grid = new Grille(24, 18);
	}

	public Grille getGrid() {
		return grid;
	}
	public void setGrid(Grille grid) {
		this.grid = grid;
	}

	public boolean hasCase(int x, int y) throws Exception {
		Case caseCherchee = new Case(x, y);
		
		return ( this.getGrid().getCases().contains(caseCherchee) );
	}
	public boolean hasCase(Case c) {
		boolean flag = this.getGrid().getCases().contains(c); 
		return flag;
	}
	public boolean hasCase(List<Case> cases) {
		boolean flag = false;
		
		for (Case caseCourante : cases) {
			if ( this.hasCase(caseCourante) ) {
				//System.out.println("bateau déjà présent");
				flag = true;
				break;
			}				
		}
		
		return flag;
	}
	
	public Case getCase(int x, int y) throws Exception {
		Case caseATrouver = new Case(x, y);
 		Case caseTrouvee = null;
		
		if ( this.hasCase(x, y) )
			caseTrouvee = this.grid.getCases().get( this.grid.getCases().indexOf(caseATrouver) );
		
		return caseTrouvee;
	}
	
	public void addCases(List<Case> cases) {
		if ( ! hasCase(cases) )
			this.grid.getCases().addAll(cases);
	}
	
	public boolean placeVaisseau(Vaisseau vaisseau, int x, int y, boolean hztl) throws Exception {
		boolean flag;
		List<Case> casesVaisseau = new ArrayList<Case>();
		
		//Est-ce en-dehors de la grille
		if ( (hztl && x+vaisseau.getLenght() > this.getGrid().getDimX()) ||
				(!hztl && y+vaisseau.getLenght() > this.getGrid().getDimY()) ) {
			flag = false;
		}
		else {
			//Création des coordonnées possibles du bateau
			for(int i=0; i < vaisseau.getLenght(); i++) {
				Case caseCourante;
				if ( hztl )
					caseCourante = new Case(x+i, y);
				else
					caseCourante = new Case(x, y+i);
				
				casesVaisseau.add(caseCourante);
			}
			
			//Si case(s) déjà enregistrée(s), un bateau y est
			if ( this.hasCase(casesVaisseau) ) {
				flag = false;
			}
			else {
				flag = true;
				vaisseau.setCasesVaisseau(casesVaisseau);
				this.addCases(casesVaisseau);
				for (Case caseCourante : casesVaisseau) {
					caseCourante.setVaisseau(vaisseau);
				}
				//System.out.println(vaisseau);
			}
		}
		
		return flag;
	}

	public String toString() {
		StringBuilder grille = new StringBuilder();
		
		try {
			grille.append("      ");
			for (int i = 0; i < this.getGrid().getDimX(); i++) {
				grille.append(String.format(" %02d |", i+1));
			}
			grille.deleteCharAt(grille.length()-1);
			grille.append("\n");

			for (int j = 0; j < this.getGrid().getDimY(); j++) {
				grille.append(String.format(" %02d |", j+1));
				
				for (int i = 0; i < this.getGrid().getDimX(); i++) {
					grille.append("  ");
					if ( this.hasCase(i, j) )
						if ( this.getCase(i, j).isTouche() )
							grille.append("X");
						else
							grille.append(this.getCase(i, j).getVaisseau().getId());
					else
						grille.append(" ");
					grille.append("  ");
				}

				grille.append(String.format("| %02d\n", j+1));
			}
			
			grille.append("      ");
			for (int i = 0; i < this.getGrid().getDimX(); i++) {
				grille.append(String.format(" %02d |", i+1));
			}
			grille.deleteCharAt(grille.length()-1);
			grille.append("\n");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return grille.toString();
	}

}
