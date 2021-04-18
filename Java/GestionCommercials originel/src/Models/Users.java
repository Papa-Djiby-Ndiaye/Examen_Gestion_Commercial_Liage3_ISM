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
public class Users extends Personne {

    public Users() {
        type="User";
    }

    public Users(String nomComplet, String login, String password) {
         super(nomComplet,login,password); 
type=("User");//To change body of generated methods, choose Tools | Templates.
    }

    
    
}
