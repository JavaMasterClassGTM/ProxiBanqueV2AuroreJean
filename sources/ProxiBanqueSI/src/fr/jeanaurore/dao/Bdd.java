package fr.jeanaurore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cette classe gére la connexion à la base de données
 * Les éléments nécessaire à la connexion sont définis comme des constantes:
 * driver
 * URL
 * login
 * password
 * 
 * @author Aurore et Jean
 * 
 *
 *
 */
public class Bdd {
	private static Connection cnx;
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/proxibanque_db";
    private static String LOGIN = "root";
    private static String PASSWORD = "";
    
    
   /**
    * Méthode de connexion
    *     
    * @return la connexion
    */
    
    public static Connection seConnecter(){
        try {
            Class.forName(DRIVER);
            cnx =DriverManager.getConnection(URL,LOGIN,PASSWORD);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Le driver n'a pas pu être chargé.");
        } catch (SQLException ex) {
            Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("La connexion à la base de données à échouée.");
        }
        return cnx;
    }
    
    /**
     * Méthode de déconnexion
     * 
     * @param cnx
     */
    
    public static void seDeconnecter(Connection cnx){
        try {
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("La connexion n'a pas coupée.");
        }
    }

}
