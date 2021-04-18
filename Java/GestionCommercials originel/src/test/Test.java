/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.DaoArticle;
import DAO.DaoPersonne;
import Models.Article;
import Models.Personne;
import Models.Users;

/**
 *
 * @author USER
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       DaoArticle daoArticle = new DaoArticle();
{
          daoArticle.findArticle(new Article()).forEach(System.out::println);
           
    }
        //daoPersonne.findAll().forEach((classe)->{
        //System.out.println(classe);
        //});
    }

    
    
}
