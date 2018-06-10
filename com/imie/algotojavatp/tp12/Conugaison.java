/**
 * 
 */
package com.imie.algotojavatp.tp12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Florian
 * @date 2018-06-05
 *
 */
public class Conugaison {	
	
	public static String [] verbePremierGroupe(String verbe) {
		String [] conjugue = new String[6];
		
		String radical = verbe.substring(0, verbe.length()-2);
		String terminaison = "";
		
		for (int i = 0; i < conjugue.length; i++) {
			switch(i) {
				case 0 : case 2:
					terminaison = "e";
					break;
				case 1:
					terminaison = "es";
					break;
				case 3:
					if (radical.endsWith("g"))
						terminaison = "eons";
					else
						terminaison = "ons";
					break;
				case 4:
					terminaison = "ez";
					break;
				case 5:
					terminaison = "ent";
					break;
			}
			
			conjugue[i] = radical + terminaison;
		}
			
		return conjugue;
	}
	
	public static boolean isPremierGroupe(String verbe) {
		return ( verbe.endsWith("er") && ! verbe.toLowerCase().equals("aller") );
	}
	
	public static String lireVerbe(Scanner sc) {
		String verbe;
		
		System.out.println("Quelle verbe du premier groupe voulez-vous conjuguer ?");
		verbe = sc.nextLine();
		
		return verbe;
	}
	
	public static void ecrireConjugaison(String verbe) {
		String [] pronoms = {"Je", "Tu", "Il/Elle/On", "Nous", "Vous", "Ils/Elles"};
		Pattern p = Pattern.compile("^[aàeioôuyéèêëAÀEIOUYÉÈÊË]");
		Matcher m = p.matcher(verbe); 
		
		if ( isPremierGroupe(verbe) ) {
			String [] conjugaison = verbePremierGroupe(verbe);
			
			System.out.println(String.format("== Verbe %s ==", verbe));
			for (int i=0; i<conjugaison.length; i++) {
				if ( i == 0 && m.find() )
					System.out.println(String.format("  J'%s", conjugaison[i]));
				else
					System.out.println(String.format("  %s %s", pronoms[i], conjugaison[i]));
			}
		}
		else {
			System.out.println("Le verbe n'est pas du premier groupe.");
		}
	}

}
