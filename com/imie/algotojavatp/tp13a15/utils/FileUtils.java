/**
 * 
 */
package com.imie.algotojavatp.tp13a15.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Florian
 * @date 2018-06-06
 *
 */
public class FileUtils {
	
	public static String lireFichier(String nameFile) throws IOException {
		StringBuilder contenuFichier = new StringBuilder();
		
		File file = new File(nameFile);
		FileReader filereader = null;
		
		try {
			int i = 0;
			filereader = new FileReader(file);
			while((i = filereader.read()) != -1)
		        contenuFichier.append((char)i);
		} catch (FileNotFoundException ef) {
			System.err.println(ef.getMessage());
			ef.printStackTrace();
		} finally {
			if ( filereader != null )
				filereader.close();
		}
		
		return contenuFichier.toString();
	}
	
	public static String lireFichier2(String name) {
		StringBuilder contentFile = new StringBuilder();
		
		try {
			for (String ligne : Files.readAllLines(Paths.get(name))) {
				contentFile.append(ligne);
				contentFile.append("\n");
			}
		}
		catch (FileNotFoundException ef) {
			System.err.println(ef.getMessage());
			ef.printStackTrace();
		}
		catch (IOException eIO) {
			System.err.println(eIO.getMessage());
			eIO.printStackTrace();
		}
		
		return contentFile.toString();
	}
	
	public static void ecrireFichier(String name, String content) {
		File file = new File(name);
		FileWriter filewriter;
		
		try {
			filewriter = new FileWriter(file);
			filewriter.write(content);
			filewriter.close();
		}
		catch (IOException eIO) {
			System.err.println(eIO.getMessage());
			eIO.printStackTrace();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void ecrireFichier2(String name, String content) {
		try {
			Files.write(Paths.get(name), content.getBytes());
		}
		catch (IOException eIO) {
			System.err.println(eIO.getMessage());
			eIO.printStackTrace();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
