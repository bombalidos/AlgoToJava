/**
 * 
 */
package com.imie.algotojavatp.tp13a15;

import java.io.IOException;
import java.util.Scanner;

import com.imie.algotojavatp.tp13a15.utils.FileUtils;
import com.imie.algotojavatp.tp13a15.utils.StringUtils;

/**
 * @author Florian
 * @date 2018-06-06
 *
 */
public class TP13a15 {
	
	private static final Scanner SC = new Scanner(System.in);
	
	private static final String CMD		= "Fournir une chaîne à transformer :";
	private static final String RETOUR1 = "Votre chaîne était : ";
	private static final String RETOUR2 = "Votre chaîne est   : ";
	private static final String RETOUR3 = "Votre chaîne a été modifiée %d fois.";
		
	public static void transformChaine() {
		String chaine;
		do {
			System.out.println(CMD);
			chaine = SC.nextLine();
			
			if ( ! chaine.equals("exit") && StringUtils.hasET(chaine) ) {
				System.out.println(RETOUR1 + chaine);
				System.out.println(RETOUR2 + StringUtils.remplaceET(chaine));
				System.out.println(RETOUR2 + StringUtils.remplaceET(chaine, true));
				System.out.println(String.format(RETOUR3, StringUtils.nbRemplaceET(chaine)));
			}
		}
		while (! chaine.equals("exit"));
	}
	
	public static void transformChaineInFile(String nameFile, String nameFileResult) throws IOException {
		String contentFile  = FileUtils.lireFichier(nameFile);
		String contentFile2 = FileUtils.lireFichier2(nameFile);
		String contentFileReplaced = StringUtils.remplaceET(contentFile);
		
		System.out.println(contentFile);
		System.out.println();
		System.out.println(contentFile2);
		System.out.println();
		
		FileUtils.ecrireFichier(nameFileResult, contentFileReplaced);
		FileUtils.ecrireFichier2(nameFileResult.replace(".", "2."), contentFileReplaced);
		System.out.println(contentFileReplaced);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//TP13a15.transformChaine();
			TP13a15 .transformChaineInFile("tp15.txt", "tp15result.txt");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		SC.close();
	}

}
