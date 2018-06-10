/**
 * 
 */
package com.imie.algotojavatp.tp11.v1;

/**
 * @author Florian
 * @date 2018-06-04
 * TODO Prof : Vaisseau posséde les cases où il est et a des classes filles Corverte, etc...
 * TODO Prof : batailleNavale connaît les cases utilisées
 *
 */
public class BatailleNavale {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Joueur [] joueurs = new Joueur[2];
		
		Vaisseau [] defaultVaisseauxJoueur = new Vaisseau[6];
		defaultVaisseauxJoueur[0] = new Vaisseau(1, 1, TypeVaisseau.Corvette);
		defaultVaisseauxJoueur[1] = new Vaisseau(2, 3, TypeVaisseau.Destroyer);
		
		
		//joueurs[0] = new Joueur("Joueur un", vaisseaux);
	}

}
