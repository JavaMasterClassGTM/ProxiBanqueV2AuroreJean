package fr.jeanaurore.service;

import java.util.ArrayList;

import fr.jeanaurore.dao.DaoImplClient;
import fr.jeanaurore.dao.DaoImplCompte;
import fr.jeanaurore.model.Client;
import fr.jeanaurore.model.Compte;

/**
 * Cette classe implémente les services
 * 
 * @author Aurore et Jean
 *
 */
public class ServiceImpl implements IService {

	private static DaoImplClient daoClient = new DaoImplClient();
	private static DaoImplCompte daoCompte = new DaoImplCompte();

	/**
	 * Méthode retournant une liste de clients
	 * 
	 * @return liste clients
	 */
	public ArrayList<Client> getAllClient() {
		ArrayList<Client> liste = daoClient.selectAllClient();
		return liste;
	}

	/**
	 * Récupère un client par son ID
	 * 
	 * @param idClient
	 * @return le Client
	 */
	public Client getClientById(int idClient) {
		Client client = daoClient.selectClientById(idClient);
		return client;
	}

	/**
	 * Cette méthode renvoie tous les comptes d'un client
	 * 
	 * @param idClient
	 *            l'id du Client
	 * @return Une ArrayList de comptes.
	 */
	public ArrayList<Compte> getAllCompteByIdClient(int idClient) {
		ArrayList<Compte> liste = daoClient.selectAllComptesByIdClient(idClient);
		return liste;
	}

	/**
	 * Cette méthode permet de réaliser un virement d'un montant donné depuis un
	 * compte Source vers un compte destinataire.
	 * 
	 * @param compteSource
	 * @param compteDest
	 * @param montant
	 */
	public void faireVirement(Compte compteSource, Compte compteDest, double montant) {
		double resteSource = compteSource.getSolde() - montant;
		double resteDest = compteDest.getSolde() + montant;
		compteSource.setSolde(resteSource);
		compteDest.setSolde(resteDest);
		updateCompte(compteSource);
		updateCompte(compteDest);
	}

	/**
	 * Permet de renvoyer un compte choisi par son ID
	 * @param id L'ID du compte
	 * @return le compte
	 */
	public Compte getCompteById(int id) {
		Compte compte = daoCompte.selectCompteById(id);
		return compte;
	}

	/**
	 * Permet de mettre à jour un compte dans la couche persistance.
	 * @param compte le Compte qui sera mise à jour.
	 */
	public void updateCompte(Compte compte) {
		daoCompte.updateCompte(compte);
	}
}
