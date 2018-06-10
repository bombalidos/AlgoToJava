/**
 * 
 */
package com.imie.algotojavatp.tp13a15.utils;

import java.util.regex.Pattern;

/**
 * @author Florian
 * @date 2018-06-06
 *
 */
public class StringUtils {
	
	//private static final String RECHERCHEE	= "et|eT|Et|ET";
	private static final String RECHERCHEE	= "\\set\\s|\\seT\\s|\\sEt\\s|\\sET\\s";
	private static final String REMPLACEE	= " 00 ";
	
	private static final Pattern PATTERN = Pattern.compile(RECHERCHEE);
	
	public static boolean hasET(String chaine) {		
		return PATTERN.matcher(chaine).find();
	}
	
	public static String remplaceET (String chaine) {		
		return chaine.replaceAll(PATTERN.pattern(), REMPLACEE);
	}
	
	public static String remplaceET (String chaine, boolean flag) {
		String chaineRemplacee = ""; 
		
		if ( chaine.equals(RECHERCHEE) )
			chaineRemplacee = REMPLACEE;
		else {
			chaineRemplacee = String.join(REMPLACEE, chaine.split(PATTERN.pattern()));
			
			if ( chaine.endsWith(RECHERCHEE) ) {
				chaineRemplacee = chaineRemplacee.concat(REMPLACEE);
			}
		}
		
		return chaineRemplacee;
	}
	
	public static int nbRemplaceET(String chaine) {
		int pas;
		int nb = 0;

		if ( chaine.equals(RECHERCHEE) )
			nb = 1;
		else {
			if (chaine.endsWith(RECHERCHEE))
				pas = 0;
			else
				pas = 1;
			
			nb = chaine.split(PATTERN.pattern()).length-pas;
		}
		
		return nb;
	}

}
