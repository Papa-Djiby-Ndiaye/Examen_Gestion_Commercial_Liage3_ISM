/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Client;
import Models.Personne;
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
public class DaoPersonne implements IDao<Personne> {
    public final String SQL_INSERT="INSERT INTO `personne` (`nom_complet`, `type`, `login`, `password`, `tel`, `adresse` ) VALUES(?,?,?,?,?,?);";
   private final String SQL_SELECT_CONNECT="select * from personne where login=? and password=?";
    private final String SQL_SELECT_ALL_USERS="select * from personne where type='User'";
    private final String SQL_SELECT_CLIENT="select * from personne where type='Client'";
    private DaoMysql mysql;
     public DaoPersonne() {
        mysql=new DaoMysql();
    }
     public List<Users> findUser(Users user){
        List<Users> lUsers= new ArrayList();
         try {
           mysql.ouvrirConnexionBd();
            //3 preparation de la requete
            mysql.preparerRequete(SQL_SELECT_ALL_USERS);
            //mysql.getPs().setString(1,professeur.getType());
                ResultSet rs=mysql.executeSelect();
         
            while (rs.next()) {
                    Users usr= new Users();
                usr.setId(rs.getInt("id"));
                usr.setNomComplet(rs.getString("nom_complet"));
               
                lUsers.add(usr);
            } } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
                return lUsers;
            } 
     public List<Client> findClient(Client Client){
        List<Client> lClient= new ArrayList();
         try {
           mysql.ouvrirConnexionBd();
            //3 preparation de la requete
            mysql.preparerRequete(SQL_SELECT_CLIENT);
            //mysql.getPs().setInt(1,personne.getTelephone());
                ResultSet rs=mysql.executeSelect();
         
            while (rs.next()) {
                
                    Client clt= new Client();
                clt.setId(rs.getInt("id"));
                clt.setNomComplet(rs.getString("nom_complet"));
               clt.setAdresse(rs.getString("adresse"));
               clt.setTelephone(rs.getInt("tel"));
                lClient.add(clt);
            } } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
                return lClient;
            } 
     
  public Personne findUserConnect(String login, String password){
        Personne pers=null;
         try {
        mysql.ouvrirConnexionBd();
        mysql.preparerRequete(SQL_SELECT_CONNECT);
        
       
            mysql.getPs().setString(1, login);
        
            mysql.getPs().setString(2, password);
            
            ResultSet rs=mysql.executeSelect();
            if(rs.next()){
            if(rs.getString("type").trim().compareTo("User")==0){
                pers=new Users();
            }
             pers.setId(rs.getInt("id"));
                pers.setNomComplet(rs.getString("nom_complet"));
                pers.setLogin(rs.getString("login"));
                pers.setPassword(rs.getString("password"));
            }
            } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pers;
  }
    @Override
    public int insert(Personne pers) {
         int nbreLigne=0;
       Client clt=new Client();
       Users users=new Users();
       try {
         mysql.ouvrirConnexionBd();
            //3 preparation de la requete
            mysql.preparerRequete(SQL_INSERT);
       
            mysql.getPs().setString(1, pers.getNomComplet());
             mysql.getPs().setString(2, pers.getType());
              mysql.getPs().setString(3, pers.getLogin());
              mysql.getPs().setString(4, pers.getPassword());
               mysql.getPs().setInt(5, pers.getTelephone());
                mysql.getPs().setString(6, pers.getAdresse());
               
                nbreLigne=mysql.executeMiseAJour();
            
              
        
    }   catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
       return nbreLigne;
}
}