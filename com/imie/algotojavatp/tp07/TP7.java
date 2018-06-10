/**
 * 
 */
package com.imie.algotojavatp.tp07;

import java.util.Scanner;

/**
 * @author Florian
 * @date 2018-06-01
 *
 */
public class TP7 {
	int nbGobelets = 0;
	int [] bac = new int[4]; //TODO contenance
	int [] concasseur = new int[2]; //TODO utilisation
	
	//TODO permet de faire le liens entre les éléments
	int [][] lienSelGrainBacConca = {
			{10, 1, 1},
			{25, 1, 1},
			{10, 1, 1},
			{10, 1, 1},
			{25, 2, 1},
			{10, 2, 1},
			{25, 3, 2},
			{12, 4, 0}
	};
	
	Scanner scanner = null;	
	
	/**
	 * Constructor
	 * @throws Exception 
	 */
	public TP7(int nbGobelets, Scanner scanner) throws Exception {
		if ( nbGobelets < 0 ) {
			throw new Exception("Il est impossible d'enlever plus de gobelets que la machine en contient.");
		}
		
		this.setScanner(scanner);
		
		initBacs();
		initConcasseur();
	}
	
	//TODO 
	public void ouvrirSelection() throws Exception {
		String message = "Quelle est votre sélection ? (9 pour quitter)";
		int selection = 0;
		
		do {
			System.out.println(message);
			selection = scanner.nextInt();
			
			setBac(lienSelGrainBacConca[selection-1][1], getBac(lienSelGrainBacConca[selection-1][1])-lienSelGrainBacConca[selection-1][0]);
			setConcasseur(lienSelGrainBacConca[selection-1][2], getConcasseur(lienSelGrainBacConca[selection-1][2]-1));
			
		} while (selection < 9 && selection > 0);
	}
	
	/*
	 * Publics
	 */
	
	public Scanner getScanner(Scanner scanner) {
		return this.scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	/*
	 * Privées
	 */
	
	/*
	 * Inialiser le contenu des bacs au démarrage de la machine
	 */
	private void initBacs() throws Exception {
		StringBuilder message = new StringBuilder("Initialiser le bac ");
		
		for ( int i = 0; i < this.bac.length; i++ ) {
			message.append(Integer.toString(i)).append(" : ");
			System.out.println(message);
			
			this.setBac(i, scanner.nextInt());
		}
	}
	
	/*
	 * Contenu d'un bac
	 */
	private int getBac(int pos) throws Exception {
		if ( pos < 0 || pos >= this.bac.length ) {
			throw new Exception("Ce bac n'existe pas.");
		}
		
		return this.bac[pos];		
	}
	
	/*
	 * Changer le contenu d'un bac
	 */
	private void setBac(int pos, int value) throws Exception {
		if ( pos < 0 || pos >= this.bac.length ) {
			throw new Exception("Ce bac n'existe pas.");
		}
		
		if ( value < 0 ) {
			throw new Exception("Le bac ne peut avoir une valeur négative.");
		}
		
		this.bac[pos] = value;
	}
	
	private void initConcasseur() throws Exception {
		StringBuilder message = new StringBuilder("Fournir le nombre d'utilisation des concasseurs ");
		
		for (int i = 0; i < this.concasseur.length; i++) {
			System.out.println(message.append(Integer.toString(i)).append(" : "));
			
			this.setConcasseur(i, scanner.nextInt());
		}
	}
	
	private int getConcasseur(int pos) throws Exception {
		if ( pos < 0 || pos >= this.concasseur.length) {
			throw new Exception("Ce concasseur n'existe pas !!");
		}
		
		return this.concasseur[pos];
	}
	
	private void setConcasseur(int pos, int value) throws Exception {
		if ( pos < 0 || pos >= this.concasseur.length) {
			throw new Exception("Ce concasseur n'existe pas !!");
		}
		
		if ( value < 0 ) {
			throw new Exception("Le concasseur ne peut avoir de dettes.");
		}
		
		this.concasseur[pos] = value;
		
	}
}
