/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author USER
 */
public abstract class Personne {
    protected int id;
    
    protected String nomComplet;
     protected String type;
     protected String login;
     protected String password;
     protected String adresse;
     protected int telephone;
    public Personne(){
        
    }

    public Personne(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public Personne(int id, String nomComplet) {
        this.id = id;
        this.nomComplet = nomComplet;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public Personne(String nomComplet, String login, String password) {
        this.nomComplet = nomComplet;
        this.login = login;
        this.password = password;
    }

    public Personne(int telephone) {
        this.telephone = telephone;
    }

    public Personne(String nomComplet, String adresse, int telephone) {
        this.nomComplet = nomComplet;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public Personne(int id, String nomComplet, String adresse, int telephone) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    

     

     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nomComplet=" + nomComplet + '}';
    }

     

    

    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
