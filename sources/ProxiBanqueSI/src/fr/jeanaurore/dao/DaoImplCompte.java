package fr.jeanaurore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.jeanaurore.model.Compte;
import fr.jeanaurore.model.CompteCourant;
import fr.jeanaurore.model.CompteEpargne;

/**
 * Cette classe implémente la dao pour gérer la persistance des comptes
 * 
 * @author Aurore et Jean
 *
 */
public class DaoImplCompte {

	private static final DaoImplClient DAO_IMPL_CLIENT = new DaoImplClient();

	/**
	 * Permet de renvoyer un compte choisi par son ID
	 * @param idCompte
	 * @return le compte
	 */
	public Compte selectCompteById(int idCompte) {
		Connection cnx = Bdd.seConnecter();
		String sql = "SELECT * FROM Compte WHERE id_compte=" + idCompte;
		Statement stmt;
		Compte cpt = new Compte(idCompte);
		try {
			stmt = cnx.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			if (res.next()) {
				double solde = res.getDouble("solde");
				String dateOuverture = res.getString("date_crea");
				boolean isCourant = res.getBoolean("isCourant");
				int idClient = res.getInt("id_client");

				if (isCourant) {
					cpt = new CompteCourant(idCompte, solde, dateOuverture, DAO_IMPL_CLIENT.selectClientById(idClient));

				} else {
					cpt = new CompteEpargne(idCompte, solde, dateOuverture, DAO_IMPL_CLIENT.selectClientById(idClient));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Bdd.seDeconnecter(cnx);

		return cpt;
	}

	/**
	 * Permet de mettre à jour un compte dans la base de donnée.
	 * @param compte le Compte qui sera enregistré dans la base de donnée.
	 */
	public void updateCompte(Compte compte) {
		int id = compte.getId();
		double solde = compte.getSolde();
		Connection cnx = Bdd.seConnecter();

		String sql = "UPDATE Compte SET solde=" + solde + "WHERE id_compte=" + id;
		Statement stmt;

		try {
			stmt = cnx.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Bdd.seDeconnecter(cnx);

	}

}
