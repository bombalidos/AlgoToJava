/**
 * 
 */
package com.imie.algotojavatp.tp09;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */
public class Tournoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		Map<String, Integer> armures		= new HashMap<String, Integer>();	
		Map<String, Integer []> armes	= new HashMap<String, Integer []>();
		
		armures.put("Gilet bleu", 1);
		armures.put("Armure de cuir", 2);
		armures.put("Armure de plaque", 4);
		
		armes.put("Concasseur", new Integer [] {3, 4});
		armes.put("Pelle", new Integer [] {2, 1});
		armes.put("Gatling", new Integer [] {10, 6});
		armes.put("Batte de cricket", new Integer [] {1, 1});
		armes.put("Blaster", new Integer [] {6, 3});
		
		Scanner sc = new Scanner(System.in);
		
		String msgNbCombattants				= "Combien de combattants vont combattre dans l'arène ?";
		String msgDecrireCombattant			= "Décrire le combattant numéro %d.\n";
		String msgDecrireCombattantNom		= "\tSon nom :";
		String msgDecrireCombattantPa		= "\tSes points d'action :";
		String msgDecrireCombattantPdv		= "\tSes points de vie :";
		String msgDecrireCombattantArme		= "\tSon arme :";
		String msgDecrireCombattantArmure	= "\tSon armure :";
		
		/*
		 * Initialisation
		 */
		int nbCombattants = 0;
		while (nbCombattants < 2 ) {
			System.out.println(msgNbCombattants);
			nbCombattants = sc.nextInt();
		}
		
		Arene arene = new Arene(nbCombattants);
		String name, armure, arme;
		int pa, pdv;
		for (int i = 0; i < nbCombattants; i++) {
			System.out.printf(msgDecrireCombattant, i+1);
			
			sc.nextLine(); //récupère le caractère de fin du nextInt() précédent.
			System.out.println(msgDecrireCombattantNom);
			name = sc.nextLine();
			
			do {
				System.out.println(msgDecrireCombattantPa);
				pa = sc.nextInt();
			} while ( pa <= 0 );
			
			do {
				System.out.println(msgDecrireCombattantPdv);
				pdv = sc.nextInt();
			} while ( pdv <= 0 );
			
			do {
				sc.nextLine(); //récupère le caractère de fin du nextInt() précédent.
				System.out.println(msgDecrireCombattantArme);
				arme = sc.nextLine();
			} while ( ! armes.containsKey(arme) );
			
			do {
				//sc.nextLine(); //récupère le caractère de fin du nextInt() précédent.
				System.out.println(msgDecrireCombattantArmure);
				armure = sc.nextLine();
			} while ( ! armures.containsKey(armure) );
			
			arene.getCombattants()[i] = new Personnage(
											name, pdv, pa,
											new Armure(armure, armures.get(armure)),
											new Arme(arme, armes.get(arme)[0], armes.get(arme)[1])
										);
		}
		
		System.out.println("\nAu départ :\n\n" + arene);
		
		/*
		 * Combattez !
		 */
		
		int nbCombattantsAlive = arene.getCombattants().length;
		while (nbCombattantsAlive > 1) {
			//Selection attaquant
			for (int i = 0; nbCombattantsAlive > 1 && i < arene.getCombattants().length; i++) {
				Personnage attaquant = arene.getCombattants()[i];						
				Personnage adversaire = null;			
				
				if ( attaquant.getPdv() <= 0 )
					continue;
				else {
					//Selection adversaire
					if ( i == arene.getCombattants().length-1 ) {
						for (int j = 0; j < i; j++) {
							if ( arene.getCombattants()[j].getPdv() > 0 ) {
								adversaire = arene.getCombattants()[j];
								break;
							}
						}
					}
					else {
						for ( int j = i+1; j != i; j++ ) {
							if ( j == arene.getCombattants().length )
								j = 0;
							
							if ( arene.getCombattants()[j].getPdv() > 0 ) {
								adversaire = arene.getCombattants()[j];
								break;
							}
						}
					}
				}
				
				arene.attaque(attaquant, adversaire);
				System.out.println();
				
				if ( adversaire.getPdv() <= 0 ) {
					nbCombattantsAlive--;					
					System.out.println(attaquant.getNom() + " a gagné contre " + adversaire.getNom() + "\n");
				}
			}
		}
		
		System.out.println("\nAu final :\n\n" + arene);
		
		sc.close();
	}
}
