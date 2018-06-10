/**
 * 
 */
package com.imie.algotojavatp.tp02a5;

import java.util.Scanner;

/**
 * @author Florian
 * @date 2018-06-01
 *
 */
public class TP2a5 {	
	private static Scanner scanner = null;
	
	public static void setScanner(Scanner scanner) {
		TP2a5.scanner = scanner;
	}
	
	public static float operation() throws Exception {
		float a = scanner.nextFloat();
		float b = scanner.nextFloat();
		float op = 0;
		
		if ( a == b) {
			op = a+b;
		}
		else if ( a < 0 && b >= 0 ) {
			op = a*b;
		}
		else if ( a*b >= 0 && (Math.abs(a) > 10 || Math.abs(b) > 10) ) {
			if ( b == 0 )
				throw new Exception("Division par zéro !");
			
			op = a / b;
		}
		
		return op;
	}
}
