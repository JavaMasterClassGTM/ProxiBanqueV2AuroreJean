package fr.jeanaurore.model;

/**
 * Cette classe est responsable de la modélisation des clients
 * 
 * 
 * @author Aurore et Jean
 *
 */
public class Client extends Personne{
	
	private String email;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private CompteCourant comptecourant;
	private CompteEpargne compteEpargne;
	private boolean isEntreprise;
	
	
	public Client(String nom, String prenom, int id, boolean isEntreprise) {
		super(nom, prenom, id);
		this.isEntreprise = isEntreprise;
	}
	
	public Client(int id) {
		super("", "", id);
		
	}
	


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public CompteCourant getComptecourant() {
		return comptecourant;
	}


	public void setComptecourant(CompteCourant comptecourant) {
		this.comptecourant = comptecourant;
	}


	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}


	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}


	public boolean isEntreprise() {
		return isEntreprise;
	}


	public void setEntreprise(boolean isEntreprise) {
		this.isEntreprise = isEntreprise;
	}


	
}
