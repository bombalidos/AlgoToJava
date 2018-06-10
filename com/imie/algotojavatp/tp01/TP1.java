/**
 * 
 */
package com.imie.algotojavatp.tp01;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Florian
 * @date 2018-06-01
 * @enonce
 * - On souhaite déverrouiller un cadenas à code numérique disposant d’une
 *   molette numéroté
 * - On représentera notre doigts comme étant un curseur permettant de
 *   saisir les chiffres nécessaires à l’ouverture du cadenas
 * - La séquence à réaliser pour ouvrir le cadenas est « 12 : 9 : 14 : 8 »
 *
 */
public class TP1 {
	private static int[] code = {12,9,14,8};
	private static int[] molette = new int[4];
	private static Scanner scanner = null;
	
	/*
	 * Méthodes publics
	 */
	
	/*
	 * A initialiser avant de lancer "decryptCode()"
	 */
	public static void setScanner(Scanner scanner) {
		TP1.scanner = scanner;
	}
	
	public static void decryptCode() throws Exception {
		decryptCode(false);
	}
	
	public static void decryptCode(boolean afficherMolette) throws Exception {
		if ( hasScanner() ) {
			initMolette();
			
			for (int i = 0; i < code.length; i++) {
				if ( !decryptCran(i, afficherMolette) ) {
					initMolette();
					i = -1;
				}
			}
		}
		else {
			throw new Exception("Pas de scanner");
		}
	}
	
	/*
	 * Méthodes privées
	 */
	
	private static boolean hasScanner() {
		return scanner != null;
	}
	
	private static void initMolette() {
		Random rand = new Random();
		molette[0] = rand.nextInt(20);
	}
	
	@SuppressWarnings("unused")
	private static void setMolette(int pos, int val) {
		if ( pos > 0 && pos < molette.length ) {
			molette[pos] = val;
		}
	}
	
	private static int LireConsoleEntier () {		
		int saisie = scanner.nextInt();
		
		return saisie;
	}
	
	/*
	 * Je suppose ici que "pos" est toujours correct
	 */
	private static boolean isMoletteEqualCode (int pos) {
		return molette[pos] == code[pos];
	}
	
	private static void AfficheMolette(int limit) {
		StringBuilder strMolette = new StringBuilder("Molette : ");
		
		if ( limit >= molette.length ) {
			limit = molette.length;
		}
		
		for (int i=0; i < limit; i++) {
			strMolette.append( Integer.toString(molette[i]) );
			if (i < limit-1) {
				strMolette.append(" : ");
			}
		}
		
		System.out.println(strMolette);
	}
	
	private static boolean isRightMove(int move) {
		return move == 1;
	}
	
	private static boolean isLeftMove(int move) {
		return move == 0;
	}
	
	private static boolean incrementMolette(int pos, int move) {
		boolean goodMove = true;
		
		if ( pos >= 0 && pos < molette.length ) {			
			if ( isRightMove(move) ) {
				molette[pos]++;
				if (pos > 0 && molette[pos] > molette[pos-1] && molette[pos-1] > code[pos] ) {
					goodMove = false;
				}
			}
			else if ( isLeftMove(move) ) {
				molette[pos]--;
				if (pos > 0 && molette[pos] < molette[pos-1] && molette[pos-1] < code[pos] ) {
					goodMove = false;
				}
			}
			else {
				goodMove = false;
			}
		}
		else {
			goodMove = false;
		}
		
		return goodMove;
	}
	
	private static boolean decryptCran(int pos, boolean afficherMolette) {
		boolean goodMove = true;
		String message = "Dans quel sens tournez-vous la molette ?\n" +
						 "0 : à gauche\n" +
						 "1 : à droite";
		
		do {
			if ( afficherMolette ) {
				AfficheMolette(pos+1);
			}
			
			System.out.println(message);
			int move = LireConsoleEntier();
			
			goodMove = incrementMolette(pos, move);
		} while (!isMoletteEqualCode(pos) && goodMove);
		
		if ( goodMove && pos < molette.length-1 && pos >= 0 ) {
			molette[pos+1] = molette[pos];
		}
		
		return goodMove;
	}
	
}
