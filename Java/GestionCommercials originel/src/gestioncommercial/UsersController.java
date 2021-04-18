/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncommercial;

import Models.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import metiers.Service;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class UsersController implements Initializable {
private Service metier;
ObservableList<Users> obUsers;
    @FXML
    private TableView<Users> tblvUsers;
    @FXML
    private TableColumn<Users, String> tblcUsers;
    @FXML
    private TextField textLogin;
    @FXML
    private TextField textPassword;
    @FXML
    private TextField textNom;
    @FXML
    private TextField textPrenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         metier=new Service();
    Users users = new Users();
     
        obUsers=FXCollections.observableArrayList(metier.listerUsers(users));
        loadTAble();
    }    

    @FXML
    private void handleEnregistrerUser(ActionEvent event) {
         String nomComplet=textNom.getText()+ textPrenom.getText();
         String login=textLogin.getText();
         String password=textPassword.getText();
     
        Users users=new Users(nomComplet,login,password );
       if (metier.creerPersonne(users)){
           Alert alert=new Alert(Alert.AlertType.INFORMATION);
           alert.setContentText("User ajoutée avec succès");
           alert.setTitle("Information");
           alert.show();
           obUsers.add(users);
       }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setContentText("Erreur d'insertion");
           alert.setTitle("Erreur");
           alert.show();
           
       }
    }

    private void loadTAble() {
          tblcUsers.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
         
        tblvUsers.setItems(obUsers); //To change body of generated methods, choose Tools | Templates.
    }
    
}
