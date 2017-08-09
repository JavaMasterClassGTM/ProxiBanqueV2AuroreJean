package fr.jeanaurore.model;
/**
 * Cette classe est responsable de la modélisation d'une personne
 * 
 * @author Aurore et Jean
 *
 *
 */
public class Personne {

	private String nom;
	private String prenom;
	private int id;

	public Personne(String nom, String prenom, int id) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}
}
