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
public class Client extends Personne {
    

    public Client() {
         
        type="Client";
    }

    public Client(String nomComplet, String adresse, int telephone) {
        super(nomComplet, adresse, telephone);
        type="Client";
    }

    public Client(int telephone) {
        super(telephone);
        type="Client";
    }

    

    

}

   