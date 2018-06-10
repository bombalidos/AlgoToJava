/**
 * 
 */
package com.imie.algotojavatp;

import java.util.Scanner;

import com.imie.algotojavatp.tp01.TP1;
import com.imie.algotojavatp.tp02a5.TP2a5;
import com.imie.algotojavatp.tp07.DistributeurBoissons;

/**
 * @author Florian
 * @date 2018-06-01
 *
 */
public class AlgoToJavaTP {
	
	private static void tpUn(Scanner scanner) {
		tpUn(scanner, false);
	}
	private static void tpUn(Scanner scanner, boolean viewMolette) {
		StringBuilder victoire = new StringBuilder("\n");		
		victoire.append("##################\n");
		victoire.append("# C'est ouvert ! #\n");
		victoire.append("##################");
		
		TP1.setScanner(scanner);
		
		try {
			if ( viewMolette )
				TP1.decryptCode(true);
			else
				TP1.decryptCode();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println(victoire);		
	}
	
	private static void tp2a5 (Scanner scanner) {
		TP2a5.setScanner(scanner);		

		String messageInput = "Fournir deux entiers : ";
		StringBuilder messageOutput = new StringBuilder("Résultat : ");
		
		System.out.println(messageInput);		
		float result;
		
		try {
			result = TP2a5.operation();		
			System.out.println(messageOutput.append(Float.toString(result)));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static void tpSept (Scanner scanner) {
		tpSept(scanner, false);
	}	
	private static void tpSept (Scanner scanner, boolean initConsole) {
		String messageErrorCreateDistrib	= "Le distributeur n'a pu être initialisé.";
		String messageErrorSelOn			= "La sélection n'a pu être réalisée car l'erreur ci-dessous a été rencontrée.";
		String messageErrorStateDistrib		= "La machine était alors dans les états ci-dessous.";
		
		String messageDistribOff			= "Le distributeur est en cours d'arrêt, merci de patienter jusqu'à la fin de la phrase.";
		
		int initNbGobelets			= 100;
		int [] initContenanceBacs	= {442, 124, 82, 42};
		int [] initLifeConcasseur	= {42, 24};	
		
		try {
			//TP7 machine = new TP7(100, scanner);
			
			DistributeurBoissons machineUn;
			if ( initConsole )
				 machineUn = new DistributeurBoissons(scanner);
			else
				machineUn = new DistributeurBoissons(
									scanner,
									initNbGobelets,
									initContenanceBacs,
									initLifeConcasseur
								);
			
			//System.out.println(machineUn);
		
			try {
				machineUn.selectionOn();
				
				//Debug
				System.out.println(machineUn);
				
				System.out.println(messageDistribOff);
			} catch (Exception e) {
				StringBuilder messageError = new StringBuilder();
				messageError.append(messageErrorSelOn).append("\n");
				messageError.append(e.getMessage()).append("\n");
				messageError.append(e.getCause()).append("\n");
				messageError.append(messageErrorStateDistrib).append("\n");
				messageError.append(machineUn).append("\n");
								
				System.err.println(messageError);
			}
		}
		catch (Exception e) {
			StringBuilder messageError = new StringBuilder();
			messageError.append(messageErrorCreateDistrib).append("\n");
			messageError.append(e.getMessage()).append("\n");
			messageError.append(e.getCause()).append("\n");
			
			System.err.println(messageError);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		StringBuilder message = new StringBuilder("Choississez la méthode à éxécuter :\n");
		message.append("\t 0 : quitter\n");
		message.append("\t 1 : TP 01\n");
		message.append("\t 2 : TP 01 (avec molette apparente)\n");
		message.append("\t 3 : TPs 02 à 05\n");
		message.append("\t 4 : TP 07 (avec initialisation interne)\n");
		message.append("\t 5 : TP 07 (avec initialisation par console)");
		
		Scanner scannerMain		= new Scanner(System.in);
		Scanner scannerMethod	= new Scanner(System.in);

		boolean on = true;
		while (on) {
			System.out.println(message);
			switch (scannerMain.nextInt() ) {
				case 0:
					on = false;
				break;
				case 1:
					tpUn(scannerMethod);
				break;
				case 2:
					tpUn(scannerMethod, true);
				break;
				case 3:
					tp2a5(scannerMethod);
				break;
				case 4:
					tpSept(scannerMethod);
				break;
				case 5:
					tpSept(scannerMethod, true);
				break;
				
				default:
					System.out.println("Méthode inexistante.");
				break;
			}
		}
		
		scannerMain.close();
		scannerMethod.close();
	}

}
