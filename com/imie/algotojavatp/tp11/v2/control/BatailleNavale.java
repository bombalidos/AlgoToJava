/**
 * 
 */
package com.imie.algotojavatp.tp11.v2.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.imie.algotojavatp.tp11.v2.model.Corvette;
import com.imie.algotojavatp.tp11.v2.model.Croiseur;
import com.imie.algotojavatp.tp11.v2.model.Destroyer;
import com.imie.algotojavatp.tp11.v2.model.Joueur;
import com.imie.algotojavatp.tp11.v2.model.PorteAvions;
import com.imie.algotojavatp.tp11.v2.model.Vaisseau;

/**
 * @author Florian
 * @date 2018-06-04
 * TODO Prof : Vaisseau posséde les cases où il est et a des classes filles Corverte, etc...
 * TODO Prof : batailleNavale connaît les cases utilisées
 *
 */
public class BatailleNavale {
	
	public static void placeNavire(GrilleManager grid, Vaisseau vaisseau, String nameVaisseau, Scanner sc) throws Exception {
		int x, y;
		boolean hztl;
		boolean flag = false;
		
		do {
			do {
				if (flag) {
					System.out.println("Ces coordonnées sont invalides. Recommencez, svp.");
					flag = false;
				}
				
				System.out.println(String.format("Indiquez les coordonnées de la proue du navire '%s' :", nameVaisseau));
				System.out.println("x ->");
				x = sc.nextInt();
				System.out.println("y ->");
				y = sc.nextInt();
				System.out.println("Horizontal ? (false pour non, true pour oui)");
				hztl = sc.nextBoolean();
			} while(x <= 0 || y <= 0 || flag);
				
			flag = ! grid.placeVaisseau(vaisseau, x-1, y-1, hztl);
		} while (flag);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Joueur> joueurs = new ArrayList<Joueur>();
		
		/*
		for (int i = 0; i < joueurs.length; i++) {		
			try {
				System.out.printf("Nom du joueur %d : \n", i+1);
				String nameJoueur = sc.nextLine();	
				
				Vaisseau [] vaisseaux	= new Vaisseau [6];
				GrilleManager grid = new GrilleManager();
				
				//Joueur initialisé
				joueurs[i] = new Joueur(nameJoueur, vaisseaux, grid);
				
				//Placement des bateaux
				for ( int j = 0; j < vaisseaux.length; j++ ) {
					switch(j) {
						case 0:
							vaisseaux[j] = new Corvette();
							placeNavire(grid, vaisseaux[j], "Corvette", sc);
							break;
						case 1:
						case 2:
							vaisseaux[j] = new Destroyer();
							placeNavire(grid, vaisseaux[j], "Destroyer", sc);
							break;
						case 3:
						case 4:
							vaisseaux[j] = new Croiseur();
							placeNavire(grid, vaisseaux[j], "Croiseur", sc);
							break;
						case 5:
							vaisseaux[j] = new PorteAvions();
							placeNavire(grid, vaisseaux[j], "Porte-avions", sc);
							break;
					}
				}
				sc.nextLine();
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}*/
		
		try {
			//Joueur 1
			Vaisseau [] vaisseauxJ1	= {
					new Corvette(),
					new Destroyer(),
					new Destroyer(),
					new Croiseur(),
					new Croiseur(),
					new PorteAvions(),
			};			
			joueurs.add(
					new Joueur( "Toto", vaisseauxJ1, new GrilleManager() )
				);
			
			joueurs.get(0).getGrid().placeVaisseau(joueurs.get(0).getVaisseaux()[0], 4, 4, true);
			joueurs.get(0).getGrid().placeVaisseau(joueurs.get(0).getVaisseaux()[1], 4, 12, false);
			joueurs.get(0).getGrid().placeVaisseau(joueurs.get(0).getVaisseaux()[2], 12, 8, true);
			joueurs.get(0).getGrid().placeVaisseau(joueurs.get(0).getVaisseaux()[3], 9, 3, false);
			joueurs.get(0).getGrid().placeVaisseau(joueurs.get(0).getVaisseaux()[4], 17, 13, true);
			joueurs.get(0).getGrid().placeVaisseau(joueurs.get(0).getVaisseaux()[5], 22, 8, false);
			
			//Joueur 2
			Vaisseau [] vaisseauxJ2	= {
					new Corvette(),
					new Destroyer(),
					new Destroyer(),
					new Croiseur(),
					new Croiseur(),
					new PorteAvions(),
			};			
			joueurs.add(
					new Joueur( "Titou", vaisseauxJ2, new GrilleManager() )
				);
			
			joueurs.get(1).getGrid().placeVaisseau(joueurs.get(1).getVaisseaux()[0], 1, 1, false);
			joueurs.get(1).getGrid().placeVaisseau(joueurs.get(1).getVaisseaux()[1], 21, 17, true);
			joueurs.get(1).getGrid().placeVaisseau(joueurs.get(1).getVaisseaux()[2], 21, 14, false);
			joueurs.get(1).getGrid().placeVaisseau(joueurs.get(1).getVaisseaux()[3], 10, 13, false);
			joueurs.get(1).getGrid().placeVaisseau(joueurs.get(1).getVaisseaux()[4], 17, 1, false);
			joueurs.get(1).getGrid().placeVaisseau(joueurs.get(1).getVaisseaux()[5], 1, 9, true);
			
		} catch (Exception e) {
			e.printStackTrace();
		};
		
		System.out.println(joueurs.get(0).getName());
		System.out.println(joueurs.get(0).getGrid());
		
		System.out.println(joueurs.get(1).getName());
		System.out.println(joueurs.get(1).getGrid());
		
		sc.close();
	}

}
