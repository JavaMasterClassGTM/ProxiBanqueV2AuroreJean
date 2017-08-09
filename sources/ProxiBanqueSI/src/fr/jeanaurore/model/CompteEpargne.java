package fr.jeanaurore.model;
/**
 * Cette classe est responsable de la modélisation des comptes épargne
 * 
 * @author Aurore et Jean
 *
 */
public class CompteEpargne extends Compte {
	
	private double tauxRemuneration = 0.03;

	public CompteEpargne(int id, double solde, String dateOuverture, Client client) {
		super(id, solde, dateOuverture, client);
	}
	
	public CompteEpargne(int id) {
		super(id);
	}

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	
	

}
