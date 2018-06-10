/**
 * 
 */
package com.imie.algotojavatp.tp12;

import java.util.Scanner;

/**
 * @author Florian
 * @date 2018-06-05
 *
 */
public class TP12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		String verbe;		
		do {
			do {
				verbe = Conugaison.lireVerbe(sc);
			} while ( ! Conugaison.isPremierGroupe(verbe) );
			
			System.out.println();
			Conugaison.ecrireConjugaison(verbe.toLowerCase());
			System.out.println();
		} while (! verbe.equals("Exit"));

		sc.close();
	}

}
