/**
 * 
 */
package com.imie.algotojavatp.tp11.v1;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */
public class Vaisseau {
	private int id;
	private int lenght;
	private TypeVaisseau typeVaisseau;
		
	/**
	 * @param id
	 * @param lenght
	 * @param typeVaisseau
	 */
	public Vaisseau(int id, int lenght, TypeVaisseau typeVaisseau) {
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
	
	public TypeVaisseau getTypeVaisseau() {
		return typeVaisseau;
	}
	public void setTypeVaisseau(TypeVaisseau typeVaisseau) {			
			this.typeVaisseau = typeVaisseau;
	}

}
