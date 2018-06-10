/**
 * 
 */
package com.imie.algotojavatp.tp09;

/**
 * @author Florian
 * @date 2018-06-04
 *
 */
public class Arene {
	private Personnage [] combattants;
	
	public Arene (int nbCombattants) {
		this.setCombattants( new Personnage [nbCombattants] );
	}
	
	public Personnage[] getCombattants() {
		return combattants;
	}
	public void setCombattants(Personnage[] combattants) {
		this.combattants = combattants;
	}
	
	public void attaque(Personnage attaquant, Personnage adversaire) {
		int attaque = attaquant.getArme().getAttaque();
		int paAttaquant = attaquant.getPa();
		
		String nameAttaquant	= attaquant.getNom();
		String nameAdversaire	= adversaire.getNom();
		
		String nameArmeAttaquant = attaquant.getArme().getNom();
		
		System.out.println("###### " + nameAttaquant + " VS " + nameAdversaire + " ######" );
		
		if ( ! attaquant.getArme().isEquipee() ) {
			attaquant.getArme().setEquipee(true);
			paAttaquant -= 1;
			System.out.println(
					nameAttaquant
					+ " a équipé son "
					+ nameArmeAttaquant
					+ " avec 1 point d'action."
			);
			System.out.println(nameAttaquant + " a encore " + paAttaquant + " point(s) d'action.");
		}
		
		//TODO Là je détruit l'armure puis le corps alors que l'armure devrait être indestructible
		// et ses points de défense soustrait aux points d'attaque.
		while ( paAttaquant >= attaquant.getArme().getPa() && adversaire.getPdv() > 0 ) {
			if ( ! adversaire.getArmure().isEquipee() || adversaire.getArmure().getDefense() <= 0 ) {				
				adversaire.setPdv( adversaire.getPdv() - attaque );
				System.out.println(
						nameAttaquant
						+ " attaque au corps à corps "
						+ nameAdversaire
						+ " avec son "
						+ nameArmeAttaquant
						+ " qui nécessiste "
						+ attaquant.getArme().getPa()
						+ " point(s) d'action."
				);
				System.out.println(nameAdversaire + " a maintenant " + adversaire.getPdv() + " point(s) de vie.");
			}
			else {
				adversaire.getArmure().setDefense( adversaire.getArmure().getDefense() - attaque );
				System.out.println(
						nameAttaquant
						+ " attaque l'armure de "
						+ nameAdversaire
						+ " avec son "
						+ nameArmeAttaquant
						+ " qui nécessiste "
						+ attaquant.getArme().getPa()
						+ " point(s) d'action."
				);
				System.out.println(
						nameAdversaire
							+ " a maintenant "
							+ adversaire.getArmure().getDefense()
							+ " point(s) de défense d'armure."
				);
			}
			
			paAttaquant -= attaquant.getArme().getPa();
			System.out.println(nameAttaquant + " a encore " + paAttaquant + " point(s) d'action.");
		}
		
		attaquant.getArme().setEquipee(false);
		System.out.println(nameAttaquant + " déséquipe son arme et laisse sa place.");
		System.out.println("#################################################");
	}
	
	public String toString() {
		StringBuilder arene = new StringBuilder();
		
		for (int i = 0; i < this.getCombattants().length; i++) {
			arene.append( this.getCombattants()[i] );
			arene.append("\n");
		}
		
		return arene.toString();
	}
}
