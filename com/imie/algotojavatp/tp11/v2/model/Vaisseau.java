/**
 * 
 */
package com.imie.algotojavatp.tp11.v2.model;

import java.util.List;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */

//TODO en faire une vraie classe "abstract", donc instancier les classes filles avec "super();" puis les setters
public class Vaisseau {
	private int id;
	private int lenght;
	private String typeVaisseau;
	private List<Case> casesVaisseau;
		
	
	public Vaisseau(int id, int lenght) {
		this(id, lenght, null);
	}
	public Vaisseau(int id, int lenght, String typeVaisseau) {
		super();
		this.setId(id);
		this.setLenght(lenght);
		this.setTypeVaisseau(typeVaisseau);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getLenght() {
		return lenght;
	}
	public void setLenght(int lenght) {
		if ( lenght <= 0)
			this.lenght = 1;
		else
			this.lenght = lenght;
	}
	
	public String getTypeVaisseau() {
		return typeVaisseau;
	}
	public void setTypeVaisseau(String typeVaisseau) {			
			this.typeVaisseau = typeVaisseau;
	}
	
	public List<Case> getCasesVaisseau() {
		return this.casesVaisseau;
	}
	public void setCasesVaisseau(List<Case> casesVaisseau) {
		this.casesVaisseau = casesVaisseau;
	}
	
	public String toString() {
		return String.format(
				"%s a pour id, %d, et de longueur %d.",
				this.getTypeVaisseau(),
				this.getId(),
				this.getLenght()
				);
	}
}
