/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncommercial;

import Models.Client;
import Models.Commande;
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
 * @author Djiby
 */
public class CcController implements Initializable {
private Service metier;
ObservableList <Client> obClient;
ObservableList <Commande> obCommande;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtAdd;
    
    
    @FXML
    private TableColumn<Client, String> tblcNomComplet;
    @FXML
    private TableColumn<Client, String> tblcAdresse;
    @FXML
    private TableColumn<Client, String> tblcTel;
    @FXML
    private TableView<Client> tblvClient;
    @FXML
    private TextField txtNum;
    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtMontant;
    @FXML
    private TextField txtQuant;
    @FXML
    private TableView<Commande> tblvCommande;
    @FXML
    private TableColumn<Commande, String> tblcNum;
    @FXML
    private TableColumn<Commande, String> tblcDate;
    @FXML
    private TableColumn<Commande, String> tblcMontant;
    @FXML
    private TableColumn<Commande, String> tblcQuantite;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
              metier=new Service();
    Client client = new Client();
     
             obClient=FXCollections.observableArrayList(metier.listerClient(client));
    Commande commande= new Commande();
             obCommande=FXCollections.observableArrayList(metier.listerCommande(commande));
        loadTAble(); 
    }    

    @FXML
    private void handleEnregistrerClient(ActionEvent event) {
        String nomComplet =txtNom.getText() + txtPrenom.getText();
        int telephone = Integer.parseInt(txtTel.getText());
        String adresse= txtAdd.getText();
        Client clt = new Client(nomComplet,adresse,telephone);
        if (metier.creerPersonne(clt)){
           Alert alert=new Alert(Alert.AlertType.INFORMATION);
           alert.setContentText("Client ajoutée avec succès");
           alert.setTitle("Information");
           alert.show();
              obClient.add(clt);
            
       }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setContentText("Erreur d'insertion");
           alert.setTitle("Erreur");
           alert.show(); 

    }
    }

    
    

  

    @FXML
    private void handleEnregistrerCommande(ActionEvent event) {
        int numCommande= Integer.parseInt(txtNum.getText());
        
        int montantCommande= Integer.parseInt(txtMontant.getText());
        int qteCommande= Integer.parseInt(txtQuant.getText());
        String dateCommande= txtDate.getText();
        Commande com = new Commande(numCommande,dateCommande,montantCommande,qteCommande);
        if (metier.ajouterCommande(com)){
           Alert alert=new Alert(Alert.AlertType.INFORMATION);
           alert.setContentText("Commande validée");
           alert.setTitle("Information");
           alert.show();
              obCommande.add(com);
            
       }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setContentText("Erreur d'insertion");
           alert.setTitle("Erreur");
           alert.show(); 

    }
        
    }

      private void loadTAble() {
        tblcNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        tblcAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
tblcTel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
tblvClient.setItems(obClient);
 tblcNum.setCellValueFactory(new PropertyValueFactory<>("numCommande"));
        tblcDate.setCellValueFactory(new PropertyValueFactory<>("dateCommande"));
        tblcMontant.setCellValueFactory(new PropertyValueFactory<>("montantCommande"));
tblcQuantite.setCellValueFactory(new PropertyValueFactory<>("qteCommande"));
tblvCommande.setItems(obCommande);
    }
}
