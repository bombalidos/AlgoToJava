package com.imie.algotojavatp.tp07;

import java.util.Scanner;

/**
 * @author Florian
 * @date 2018-06-02
 * TODO Fournir la possibilité de réapprovisionner la machine sans l'arrêter
 */
public class DistributeurBoissons {
	private Scanner scanner = null;
	
	private static final String strErrorSel			= "Cette sélection n'existe pas...";
	private static final String strErrorConcasseur	= "Ce concasseur n'existe pas !!";
	private static final String strErrorValue		= "Les dettes sont impossibles ici.";
	private static final String strErrorHS			= "La machine n'est pas en état de fonctionner.";
	private static final String strErrorTooData		= "Il y a trop de données !";
	private static final String strErrorBac			= "Ce bac n'existe pas.";
	
	
	private int nbGobelets			= 0;
	private int [] contennanceBacs	= new int[4];
	private int [] lifeConcasseurs	= new int[2];
	
	private static final int [][] lienSelGrainsBacsConcas = {
			{10, 1, 1},
			{25, 1, 1},
			{10, 1, 1},
			{10, 1, 1},
			{25, 2, 1},
			{10, 2, 1},
			{25, 3, 2},
			{12, 4, 0}
	}; //permet de faire le liens entre les éléments
	
	/**
	 * Constructor
	 * @throws Exception 
	 */
	public DistributeurBoissons(Scanner scanner) throws Exception {		
		this.setScanner(scanner);
		this.initNbGobelets();
		this.initContennanceBacs();
		this.initLifeConcasseur();
	}	
	public DistributeurBoissons(Scanner scanner, int nbGobelets, int [] contennanceBacs, int [] lifeConcasseurs) throws Exception {
		this.setScanner(scanner);
		this.initNbGobelets(nbGobelets);
		this.initContennanceBacs(contennanceBacs);
		this.initLifeConcasseur(lifeConcasseurs);
	}

	/*
	 * Gestion du scanner
	 */
	public Scanner getScanner() {
		return this.scanner;
	}
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	/*
	 * Gestion des gobelets
	 */
	public void initNbGobelets() throws Exception {
		String message = "Saisir le nombre initial de gobelets :";
		
		System.out.println(message);		
		this.setNbGobelets(this.getScanner().nextInt());
	}
	public void initNbGobelets(int nbGobelets) throws Exception {
		this.setNbGobelets(nbGobelets);
	}
	public boolean hasGobelets() {
		return ( this.getNbGobelets() > 0 );
	}
	public int getNbGobelets() {
		return this.nbGobelets;
	}	
	public void setNbGobelets(int nbGobelets) throws Exception {
		if ( nbGobelets < 0 )
			throw new Exception(strErrorValue);
	
		this.nbGobelets = nbGobelets;
	}
	
	/*
	 * Gestion des bacs à grains
	 */
	public void initContennanceBacs() throws Exception {
		String message = "Initialiser le bac ";
		
		for ( int i = 0; i < this.contennanceBacs.length; i++ ) {
			System.out.println(message + (i+1) + " :");			
			this.setContennanceBac(i, this.getScanner().nextInt());
		}
	}	
	public void initContennanceBacs(int [] contennanceBacs) throws Exception {
		if ( contennanceBacs.length > this.getNbBacs() )
			throw new Exception(strErrorTooData);
		
		int value;
		for (int i = 0; i < this.getNbBacs(); i++ ) {			
			if (i < contennanceBacs.length)
				value = contennanceBacs[i];
			else
				value = 0;
			
			this.setContennanceBac(i, value);
		}
			
	}
	public boolean isValidBac(int bac) {
		return ( bac >= 0 && bac < this.getNbBacs() );
	}
	public boolean hasContennanceBac() throws Exception {
		boolean hasContennance = false;
		
		for (int i = 0; i < this.contennanceBacs.length; i++) {
			if ( this.hasContennanceBac(i) ) {
				hasContennance = true;
				break;
			}
		}
		
		return hasContennance;
	}
	public boolean hasContennanceBac(int bac) throws Exception {
		if ( ! this.isValidBac(bac) )
			throw new Exception(strErrorBac);
		
		return ( this.getContennanceBac(bac) >= this.getNbGrainAUtiliserParBac(bac) );
	}
	public int getContennanceBac(int bac) throws Exception {
		if ( ! this.isValidBac(bac) )
			throw new Exception(strErrorBac);
		
		return this.contennanceBacs[bac];		
	}
	public void setContennanceBac(int bac, int value) throws Exception {
		if ( ! this.isValidBac(bac) )
			throw new Exception(strErrorBac);
		if ( value < 0 )
			throw new Exception(strErrorValue);
		
		this.contennanceBacs[bac] = value;
	}	
	public int getNbBacs() {
		return this.contennanceBacs.length;
	}

	/*
	 * Gestion des concasseurs
	 */
	public void initLifeConcasseur() throws Exception {
		String message = "Fournir le nombre d'utilisation des concasseurs ";
		
		for (int i = 0; i < this.lifeConcasseurs.length; i++) {
			System.out.println(message + (i+1) + " :");			
			this.setLifeConcasseur(i, this.getScanner().nextInt());
		}
	}
	public void initLifeConcasseur(int [] lifeConcasseurs) throws Exception {
		if ( lifeConcasseurs.length > this.getNbBacs() )
			throw new Exception(strErrorTooData);
		
		int value = 0;
		for (int i = 0; i < this.getNbConcasseurs(); i++) {
			if ( i < lifeConcasseurs.length )
				value = lifeConcasseurs[i];
			else
				value = 0;
			
			this.setLifeConcasseur(i, value);
		}
	}
	public boolean isValidConcasseur(int concasseur) {
		return ( concasseur >= 0 && concasseur < this.getNbConcasseurs() );
	}
	public boolean hasLifeConcasseur() throws Exception {
		int sum = 0;
		for (int i = 0; i < this.lifeConcasseurs.length; i++) {
			sum += this.getLifeConcasseur(i);
		}
		return ( sum > 0) ;
	}
	public boolean hasLifeConcasseur(int concasseur) throws Exception {
		if ( ! this.isValidConcasseur(concasseur) )
			throw new Exception(strErrorConcasseur);
		
		return ( this.getLifeConcasseur(concasseur) > 0 );
	}
	public int getLifeConcasseur(int concasseur) throws Exception {
		if ( ! this.isValidConcasseur(concasseur) )
			throw new Exception(strErrorConcasseur);
		
		return this.lifeConcasseurs[concasseur];
	}
	public void setLifeConcasseur(int concasseur, int value) throws Exception {
		if ( ! this.isValidConcasseur(concasseur) )
			throw new Exception(strErrorConcasseur);		
		if ( value < 0 )
			throw new Exception(strErrorValue);
		
		this.lifeConcasseurs[concasseur] = value;		
	}	
	public int getNbConcasseurs() {
		return this.lifeConcasseurs.length;
	}

	/*
	 * Gestion des liens entre la sélection, le nombre de grains,
	 * les bacs et les concasseurs.
	 */
	public int [][] getLiensGrainsBacsConcasseurs() {
		return lienSelGrainsBacsConcas;
	}
	public boolean isValidSel(int sel) {
		return ( sel > 0 && sel <= this.getLiensGrainsBacsConcasseurs().length );
	}
	public boolean hasNbGrainAUtiliser(int sel) throws Exception {
		if ( ! this.isValidSel(sel) )
			throw new Exception(strErrorSel);
		
		return ( this.getNbGrainAUtiliser(sel) > 0 );
	}
	public int getNbGrainAUtiliser(int sel) throws Exception {
		if ( ! this.isValidSel(sel) )
			throw new Exception(strErrorSel);
		
		return this.getLiensGrainsBacsConcasseurs()[sel-1][0];
	}
	public int getNbGrainAUtiliserParBac(int bac) throws Exception {
		int result = 0;
		for (int i = 1; i <= this.getLiensGrainsBacsConcasseurs().length; i++) {
			if ( this.getBacAUtiliser(i) == bac ) {
				if ( this.getNbGrainAUtiliser(i) > result )
					result = this.getNbGrainAUtiliser(i);
			}
		}
		return result;
	}
	public boolean hasBacAUtiliser(int sel) throws Exception {
		if ( ! this.isValidSel(sel) )
			throw new Exception(strErrorSel);
		
		return ( this.getBacAUtiliser(sel) >= 0 && this.getBacAUtiliser(sel) <= this.getNbBacs() );
	}
	public int getBacAUtiliser(int sel) throws Exception {
		if ( ! this.isValidSel(sel) )
			throw new Exception(strErrorSel);
		
		return ( this.getLiensGrainsBacsConcasseurs()[sel-1][1] - 1 );
	}
	public boolean hasConcasseurAUtiliser(int sel) throws Exception {
		if ( ! this.isValidSel(sel) )
			throw new Exception(strErrorSel);
		
		return ( this.getConcasseurAUtiliser(sel) >= 0 && this.getConcasseurAUtiliser(sel) <= this.getNbConcasseurs() );
	}
	public int getConcasseurAUtiliser(int sel) throws Exception {
		if ( ! this.isValidSel(sel) )
			throw new Exception(strErrorSel);
		
		return ( this.getLiensGrainsBacsConcasseurs()[sel-1][2] - 1 );
	}
	
	/*
	 * La machine peut-elle fonctionner ?
	 */
	public boolean isAlive() throws Exception {
		return ( this.hasGobelets() && this.hasLifeConcasseur() && this.hasContennanceBac() );
	}
	
	/*
	 * Mise à disposition de la sélection à l'utilisateur
	 */
	public void selectionOn() throws Exception {
		if (! this.isAlive() )
			throw new Exception(strErrorHS);
		
		String messageSelection			= "Quelle est votre sélection ? (0 pour quitter)";
		String messageBoissonServie		= "Votre boisson est servie. Bonne dégustation.";
		String messageReapproDistrib	= "Le distributeur doit être réapprovisionné pour fonctionner.";
		
		int selection = 0;
		int bacAUtiliser;
		int concasseurAUtiliser;
		
		String messageErrorInvalidSelection = "Cette sélection est n'est pas disponible.";
		String messageErrorEmptyBac			= "Le nombre de grains dans le bac est insuffisant.";
		String messageErrorConcasseurDead	= "Le concasseur associé est hors service.";
		
		/*
		 * La boucle s'arrête lorsqu'il n'y a plus de gobelets,
		 * ou que tous les concasseurs sont morts,
		 * ou que tous les bacs sont incapables de répondre au besoin,
		 * ou si la machine est éteinte.
		 */
		while( this.isAlive() ) {
			System.out.println(messageSelection);
			selection = this.getScanner().nextInt();
			
			//Traitement de la sélection
			if ( selection == 0 )
				break;
			else if ( selection > 0 && selection <= 8) {				
				if ( this.hasBacAUtiliser(selection) ) {
					bacAUtiliser = this.getBacAUtiliser(selection);
					
					if ( this.hasConcasseurAUtiliser(selection) && ! this.hasLifeConcasseur(this.getConcasseurAUtiliser(selection)) ) {
						System.out.println(
								messageErrorInvalidSelection
									+ "\n\t"
									+ messageErrorConcasseurDead
						);
						continue;
					}
					else {
						if ( this.hasContennanceBac(bacAUtiliser) ) {
							this.setContennanceBac(
									bacAUtiliser,
									this.getContennanceBac(bacAUtiliser)
										- this.getNbGrainAUtiliser(selection)
							);
							//System.out.println("bac utilisé");
						}
						else {
							System.out.println(
									messageErrorInvalidSelection
										+ "\n\t"
										+ messageErrorEmptyBac
							);
							continue;
						}
					}
				}
				
				if ( this.hasConcasseurAUtiliser(selection) ) {
					concasseurAUtiliser = this.getConcasseurAUtiliser(selection);
					
					if ( this.hasLifeConcasseur(concasseurAUtiliser) ) {
						this.setLifeConcasseur(
								concasseurAUtiliser,
								this.getLifeConcasseur(concasseurAUtiliser) - 1
						);
						//System.out.println("concasseur utilisé");
					}
					else {
						System.out.println(
								messageErrorInvalidSelection
									+ "\n\t"
									+ messageErrorConcasseurDead
						);
						continue;
					}
				}
				
				this.setNbGobelets( this.getNbGobelets() - 1 );
				
				System.out.println(messageBoissonServie);
			}			
		}
		
		if ( selection != 0 )
			System.out.println(messageReapproDistrib);
	}

	/*
	 * Surcharge de toString pour afficher l'état du distributeur
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder message = new StringBuilder();
		message.append("#####################################################\n");
		
		try {
			message.append("# Il y a ")
				   .append(this.getNbGobelets())
				   .append(" gobelet(s) dans le distributeur.\n");
			
			message.append("# Les bacs de grains en contiennent :\n");
			for (int i = 0; i < this.getNbBacs(); i++ ) {
				message.append("#\tbac ")
					   .append(i+1)
					   .append(" : ")
					   .append(this.getContennanceBac(i))
					   .append("\n");
			}
			
			message.append("# Nombre d'utilisations restantes des concasseurs :\n");
			for (int i = 0; i < this.getNbConcasseurs(); i++ ) {
				message.append("#\tconcasseur ")
					   .append(i+1)
					   .append(" : ")
					   .append(this.getLifeConcasseur(i))
					   .append("\n");
			}
		}
		catch (Exception e) {
			message.append("Il a été impossible de récupérer toutes les données pour la raison suivante :\n");
			message.append("\t").append(e.toString());
		}

		message.append("#####################################################");
		
		return message.toString();
	}
}