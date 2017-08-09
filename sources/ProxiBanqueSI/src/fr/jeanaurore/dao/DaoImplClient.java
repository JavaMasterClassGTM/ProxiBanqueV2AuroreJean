package fr.jeanaurore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.jeanaurore.model.Client;
import fr.jeanaurore.model.Compte;
import fr.jeanaurore.model.CompteCourant;
import fr.jeanaurore.model.CompteEpargne;

/**
 * Cette classe implémente la dao pour gérer la persistance des clients
 * 
 * @author Aurore et Jean
 *
 */
public class DaoImplClient {

	/**
	 * Methode qui renvoie une liste de tous les clients
	 * 
	 * @return liste clients
	 */

	public ArrayList<Client> selectAllClient() {
		Connection cnx = Bdd.seConnecter();

		String sql = "SELECT * FROM client";
		ArrayList<Client> liste = new ArrayList<>();
		Statement stmt;
		try {
			stmt = cnx.createStatement();
			ResultSet res = stmt.executeQuery(sql);

			while (res.next()) {
				int id = res.getInt("id_client");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				boolean isEntreprise = res.getBoolean("isEntreprise");

				Client client = new Client(nom, prenom, id, isEntreprise);
				liste.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Bdd.seDeconnecter(cnx);
		return liste;
	}

	/**
	 * Cette méthode permet de retrouver un client en Base de données par son ID.
	 * @param idClient
	 * @return le Client
	 */
	public Client selectClientById(int idClient) {
		Connection cnx = Bdd.seConnecter();
		String sql = "SELECT * FROM Client WHERE id_client=" + idClient;
		Statement stmt;
		Client client = new Client(idClient);
		try {
			stmt = cnx.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			if (res.next()) {

				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				boolean isEntreprise = res.getBoolean("isEntreprise");

				client.setNom(nom);
				client.setPrenom(prenom);
				client.setEntreprise(isEntreprise);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		Bdd.seDeconnecter(cnx);

		return client;
	}

	/**
	 * Cette méthode renvoie tous les comptes d'un client
	 * @param idClient l'id du Client
	 * @return Une ArrayList de comptes.
	 */
	public ArrayList<Compte> selectAllComptesByIdClient(int idClient) {
		Connection cnx = Bdd.seConnecter();
		String sql = "SELECT * FROM compte WHERE id_client=" + idClient;

		ArrayList<Compte> liste = new ArrayList<>();
		Statement stmt;
		try {
			stmt = cnx.createStatement();
			ResultSet res = stmt.executeQuery(sql);

			while (res.next()) {
				int id = res.getInt("id_compte");
				double solde = res.getDouble("solde");
				String dateOuverture = res.getString("date_crea");
				boolean isCourant = res.getBoolean("isCourant");

				Compte cpt;
				if (isCourant) {
					cpt = new CompteCourant(id, solde, dateOuverture, selectClientById(idClient));

				} else {
					cpt = new CompteEpargne(id, solde, dateOuverture, selectClientById(idClient));
				}
				liste.add(cpt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Bdd.seDeconnecter(cnx);
		return liste;
	}

}
