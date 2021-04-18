/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metiers;

import DAO.DaoArticle;
 
import DAO.DaoCommande;
import DAO.DaoPersonne;
import Models.Article;
import Models.Client;
import Models.Commande;
import Models.Personne;
import Models.Users;
import java.util.List;

/**
 *
 * @author Djiby
 */
public class Service {
    private DaoPersonne daoPersonne;
    private DaoCommande daoCommande;
    private DaoArticle daoArticle;
     
    public Service() {
        daoCommande=new DaoCommande();
        daoPersonne=new DaoPersonne();
        daoArticle=new DaoArticle();
      
    }
      public Personne seConnecter(String login, String mdp){
        return daoPersonne.findUserConnect(login, mdp);
    }
       public boolean creerPersonne(Personne pers){
         int nbreLigne=daoPersonne.insert(pers);
         return nbreLigne !=0;
    }
       
           public List<Users> listerUsers(Users user){
         
        return daoPersonne.findUser(user);
    }
            public boolean ajouterArticle(Article article){
         int nbreLigne=daoArticle.insert(article);
         return nbreLigne !=0;
    }
            
             public List<Article> listerArticle(Article article){
         
        return daoArticle.findArticle(article);
    }
                public List<Article> listerArticleRef(Article article){
         
        return daoArticle.findArticleRef(article);
    }
            public List<Client> listerClient(Client client){
         
        return daoPersonne.findClient(client);
    } 
         public List<Commande> listerCommande(Commande commande){
         
        return daoCommande.findCommande(commande);
    }
          public boolean ajouterCommande(Commande commande){
         int nbreLigne=daoCommande.insert(commande);
         return nbreLigne !=0;
    }
}
