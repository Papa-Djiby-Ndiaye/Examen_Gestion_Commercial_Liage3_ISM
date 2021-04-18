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
public class Commande {
    private int id;
    private int numCommande;
    private String dateCommande;
    private int montantCommande;
    private int qteCommande;

    public Commande() {
    }

    public Commande(int numCommande, String dateCommande, int montantCommande, int qteCommande) {
        this.numCommande = numCommande;
        this.dateCommande = dateCommande;
        this.montantCommande = montantCommande;
        this.qteCommande = qteCommande;
    }

    public Commande(int id, int numCommande, String dateCommande, int montantCommande, int qteCommande) {
        this.id = id;
        this.numCommande = numCommande;
        this.dateCommande = dateCommande;
        this.montantCommande = montantCommande;
        this.qteCommande = qteCommande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(int montantCommande) {
        this.montantCommande = montantCommande;
    }

    public int getQteCommande() {
        return qteCommande;
    }

    public void setQteCommande(int qteCommande) {
        this.qteCommande = qteCommande;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", numCommande=" + numCommande + ", dateCommande=" + dateCommande + ", montantCommande=" + montantCommande + ", qteCommande=" + qteCommande + '}';
    }

     
    
    
}
