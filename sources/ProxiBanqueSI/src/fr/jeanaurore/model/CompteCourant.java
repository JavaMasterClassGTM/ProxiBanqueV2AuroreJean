package fr.jeanaurore.model;
/**
 * Cette classe est responsable de la modélisation des comptes courant
 * 
 * 
 * @author Aurore et Jean
 *
 */
public class CompteCourant extends Compte {
	
	private double limiteDecouvert = 1000;

	public CompteCourant(int id, double solde, String dateOuverture, Client client) {
		super(id, solde, dateOuverture, client);
	}
	
	public CompteCourant(int id) {
		super(id);
	}

	public double getLimiteDecouvert() {
		return limiteDecouvert;
	}

	public void setLimiteDecouvert(double limiteDecouvert) {
		this.limiteDecouvert = limiteDecouvert;
	}



}
