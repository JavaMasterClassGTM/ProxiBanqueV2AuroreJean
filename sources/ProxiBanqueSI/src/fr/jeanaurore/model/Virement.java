package fr.jeanaurore.model;

/**
 * Cette classe est responsable de la modélisation des virements
 * 
 * @author Aurore et Jean
 *
 */

public class Virement {

	private int id;
	private Compte compteSource;
	private Compte compteDest;
	private String dateVirement;
	private double montant;

	public Virement(int id, Compte compteSource, Compte compteDest, double montant) {
		super();
		this.id = id;
		this.compteSource = compteSource;
		this.compteDest = compteDest;
		this.montant = montant;
		// TODO : implémenter la date au moment de la création
		this.dateVirement = "Date du moment";
	}
	


	public int getId() {
		return id;
	}

	public Compte getCompteSource() {
		return compteSource;
	}

	public void setCompteSource(Compte compteSource) {
		this.compteSource = compteSource;
	}

	public Compte getCompteDest() {
		return compteDest;
	}

	public void setCompteDest(Compte compteDest) {
		this.compteDest = compteDest;
	}

	public String getDateVirement() {
		return dateVirement;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

}
