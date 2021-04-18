/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Article;
import Models.Categorie;
import Models.Convert;
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
public class DaoArticle implements IDao<Article> {
     public final String SQL_INSERT="INSERT INTO `article` (`libelle`, `reference`, `stock`, `prix`  ) VALUES (?,?,?,?);";
private final String SQL_SELECT_ALL_ARTICLE="select * from article";
private final String SQL_SELECT_ARTICLE="select libelle, stock from article where reference=?";
private DaoMysql mysql;

    public DaoArticle() {
        mysql=new DaoMysql();
    }

     public List<Article> findArticle(Article article){
        List<Article> lArticle= new ArrayList();
         try {
           mysql.ouvrirConnexionBd();
            //3 preparation de la requete
            mysql.preparerRequete(SQL_SELECT_ALL_ARTICLE);
            //mysql.getPs().setString(1,professeur.getType());
                ResultSet rs=mysql.executeSelect();
         
            while (rs.next()) {
                    Article art= new Article();
                art.setId(rs.getInt("id"));
                art.setLibelle(rs.getString("libelle"));
                art.setReference(rs.getString("reference"));
                art.setStock(rs.getInt("stock"));
                art.setPrix(rs.getInt("prix"));
                 
              
               
                lArticle.add(art);
            } } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
                return lArticle;
            } 
       public List<Article> findArticleRef(Article article){
        List<Article> lArticle= new ArrayList();
         try {
           mysql.ouvrirConnexionBd();
            //3 preparation de la requete
            mysql.preparerRequete(SQL_SELECT_ARTICLE);
            //mysql.getPs().setString(1,professeur.getType());
                ResultSet rs=mysql.executeSelect();
         
            while (rs.next()) {
                    Article art= new Article();
                art.setLibelle(rs.getString("libelle"));
                art.setStock(rs.getInt("stock"));
                
                 
              
               
                lArticle.add(art);
            } } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
                return lArticle;
            }
     
    @Override
    public int insert(Article articles) {
              int nbreLigne=0;
             Article art=new Article();
             
         
      try {
            //insertion et retrn nbre de ligne
           mysql.ouvrirConnexionBd();
            //3 preparation de la requete
            mysql.preparerRequete(SQL_INSERT);
        
            //remplacer le var de la requete par les valeurs
            mysql.getPs().setString(1, articles.getLibelle());
       
           mysql.getPs().setString(2, articles.getReference());
           mysql.getPs().setInt(3, articles.getStock());
           mysql.getPs().setInt(4, articles.getPrix());
           
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
