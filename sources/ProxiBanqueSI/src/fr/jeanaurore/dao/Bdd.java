package fr.jeanaurore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cette classe g�re la connexion � la base de donn�es
 * Les �l�ments n�cessaire � la connexion sont d�finis comme des constantes:
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
    * M�thode de connexion
    *     
    * @return la connexion
    */
    
    public static Connection seConnecter(){
        try {
            Class.forName(DRIVER);
            cnx =DriverManager.getConnection(URL,LOGIN,PASSWORD);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Le driver n'a pas pu �tre charg�.");
        } catch (SQLException ex) {
            Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("La connexion � la base de donn�es � �chou�e.");
        }
        return cnx;
    }
    
    /**
     * M�thode de d�connexion
     * 
     * @param cnx
     */
    
    public static void seDeconnecter(Connection cnx){
        try {
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("La connexion n'a pas coup�e.");
        }
    }

}
