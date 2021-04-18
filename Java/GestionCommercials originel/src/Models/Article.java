/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Djiby
 */
public class Article {
 private int id ;
 private String reference;
 private int stock;
 private int prix;
 private String libelle;
 
    
 public Article() {
    }

    public Article(String reference, int stock, int prix, String libelle) {
        this.reference = reference;
        this.stock = stock;
        this.prix = prix;
        this.libelle=libelle;
    }

    public Article(int id, String reference, int stock, int prix, String libelle) {
        this.id = id;
        this.reference = reference;
        this.stock = stock;
        this.prix = prix;
        this.libelle=libelle;
        
    }

    public Article(String reference, String libelle) {
        this.reference = reference;
        this.libelle = libelle;
    }

    public Article(int stock, String libelle) {
        this.stock = stock;
        this.libelle = libelle;
    }

     

    

    

     

    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
            return "Article{"+"id"+id+",reference="+reference+",libelle="+libelle+",stock="+stock+",prix="+prix+'}';
    }
 
    

    

    
   
 
    
}
