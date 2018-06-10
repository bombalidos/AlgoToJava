/**
 * 
 */
package com.imie.algotojavatp.tp16;

import java.io.IOException;
import java.util.TreeSet;
import java.util.regex.Pattern;

import com.imie.algotojavatp.tp16.utils.FileUtils;

/**
 * @author Florian
 * @date 2018-06-06
 *
 */
public class TP16 {
	
	public static boolean search(String [] contentFile, String password , int pos, String research) {
		boolean flag = false;
		
		if (research.equals(password))
			flag = true;
		else {
			
		}
		
		return flag;
	}
	
	public static Integer[] searchPassword(String password, String nameFile, int nbCombi) throws IOException, Exception {
		String contentFile = FileUtils.lireFichier2(nameFile);
		TreeSet<Integer> wordsFilePassword = new TreeSet<Integer>();
		boolean trouve = false;
		
		if ( nbCombi <= 0 ) {
			throw new Exception("Pas de recherche possible.");
		}
		else {
			//contentFile = contentFile.replaceAll( Pattern.compile(".|,|;|:").pattern(), "" );
			String [] tabContentFile = contentFile.split(Pattern.compile(" ").pattern());
			
			if ( nbCombi == 1 ) {
				for (int i = 0; i < tabContentFile.length; i++) {
					if ( tabContentFile[i].equals(password) ) {
						wordsFilePassword.add(i+1);
						trouve = true;
						break;
					}
				}
			}
			else {
				
			}
		}
		
		if ( ! trouve ) {
			wordsFilePassword.add(-1);
		}
		
		return wordsFilePassword.toArray(new Integer[wordsFilePassword.size()]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			 Integer [] result = TP16.searchPassword("toto", "brute.txt", 1);
			 for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
