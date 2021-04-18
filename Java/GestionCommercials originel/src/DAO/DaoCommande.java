/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Article;
import Models.Commande;
import Models.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Djiby
 */
public class DaoCommande implements IDao<Commande> {
     public final String SQL_INSERT="INSERT INTO `commande`(`date_commande`, `numero_commande`, `montant_commande`,`qte_commande` ) VALUES (?,?,?,?);";
     public final String SQL_SELECT_COMMANDE="select * from commande";
     private DaoMysql mysql;
     public DaoCommande() {
        mysql=new DaoMysql();
    }
      public List<Commande> findCommande(Commande commande){
        List<Commande> lCommande= new ArrayList();
         try {
           mysql.ouvrirConnexionBd();
            //3 preparation de la requete
            mysql.preparerRequete(SQL_SELECT_COMMANDE);
              
                ResultSet rs=mysql.executeSelect();
         
            while (rs.next()) {
                    Commande com= new Commande();
                com.setId(rs.getInt("id"));
                com.setNumCommande(rs.getInt("numero_commande"));
               com.setDateCommande(rs.getString("date_commande"));
               com.setMontantCommande(rs.getInt("montant_commande"));
               com.setQteCommande(rs.getInt("qte_commande"));
                lCommande.add(com);
            } } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
                return lCommande;
            } 
  
     @Override
    public int insert(Commande commande) {
              int nbreLigne=0;
             Commande comm=new Commande();
             
         
      try {
            //insertion et retrn nbre de ligne
           mysql.ouvrirConnexionBd();
            //3 preparation de la requete
            mysql.preparerRequete(SQL_INSERT);
        
            //remplacer le var de la requete par les valeurs
            mysql.getPs().setString(1, commande.getDateCommande());
       
           mysql.getPs().setInt(2, commande.getNumCommande());
           mysql.getPs().setInt(3, commande.getMontantCommande());
           mysql.getPs().setInt(4, commande.getQteCommande());
           
            //executer la requete
             nbreLigne=mysql.executeMiseAJour();
        
         } catch (SQLException ex) {
            Logger.getLogger(DaoArticle.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
          mysql.CloseConnexion();
      }
        return nbreLigne;
    }
}
