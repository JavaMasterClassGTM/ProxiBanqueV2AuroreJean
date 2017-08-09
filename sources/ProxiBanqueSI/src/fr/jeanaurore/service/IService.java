package fr.jeanaurore.service;

import java.util.ArrayList;

import fr.jeanaurore.model.Client;
import fr.jeanaurore.model.Compte;

/**
 * Cette Interface définit les méthodes de la couche Service.
 * @author Aurore et Jean
 *
 */
public interface IService {

	/**
	 * Méthode retournant une liste de clients
	 * 
	 * @return liste clients
	 */
	public ArrayList<Client> getAllClient();
	
	/**
	 * Récupère un client par son ID
	 * 
	 * @param idClient
	 * @return le Client
	 */
	public Client getClientById(int idClient);
	
	/**
	 * Cette méthode renvoie tous les comptes d'un client
	 * 
	 * @param idClient
	 *            l'id du Client
	 * @return Une ArrayList de comptes.
	 */
	public ArrayList<Compte> getAllCompteByIdClient(int idClient) ;
	
	/**
	 * Cette méthode permet de réaliser un virement d'un montant donné depuis un
	 * compte Source vers un compte destinataire.
	 * 
	 * @param compteSource
	 * @param compteDest
	 * @param montant
	 */
	public void faireVirement(Compte compteSource, Compte compteDest, double montant);
	
	/**
	 * Permet de renvoyer un compte choisi par son ID
	 * @param id L'ID du compte
	 * @return le compte
	 */
	public Compte getCompteById(int id);
	
	/**
	 * Permet de mettre à jour un compte dans la couche persistance.
	 * @param compte le Compte qui sera mise à jour.
	 */
	public void updateCompte(Compte compte);
}
