package fr.jeanaurore.model;

import java.util.ArrayList;
/**
 * Cette classe est responsable de la modélisation des comptes
 * 
 * @author Aurore et Jean
 *
 */
public class Compte {

	private int id;
	private double solde;
	private String dateOuverture;
	private Client client;
	private ArrayList<Virement> listeVirement = new ArrayList<>();

	public Compte(int id, double solde, String dateOuverture, Client client) {
		super();
		this.id = id;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.client = client;
	}

	public Compte(int id) {
		this.id = id;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public ArrayList<Virement> getListeVirement() {
		return listeVirement;
	}
}
