/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncommercial;

import Models.Article;
import Models.Categorie;
import Models.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import metiers.Service;

/**
 * FXML Controller class
 *
 * @author Djiby
 */
public class ArticleController implements Initializable {
private Service metier;
ObservableList<Article> obArticle;
 
    @FXML
    private TextField textRef;
    @FXML
    private TextField textLibelle;
    @FXML
    private TextField textStock;
    @FXML
    private TextField textPrix;
     
    @FXML
    private TableColumn<Article, String> tblcRef;
    @FXML
    private TableColumn<Article, String> tblcLibelle;
    @FXML
    private TableColumn<Article, String> tblcStock;
    @FXML
    private TableColumn<Article, String> tblcPrix;
    
    @FXML
    private TableView<Article> tblvArticle;
    
 
     

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          metier=new Service();
    Article article = new Article();
     
     
        obArticle=FXCollections.observableArrayList(metier.listerArticle(article));
        loadTAble();
    }    

    

    @FXML
    private void handleEnregistrerArticle(ActionEvent event) {
        String reference=textRef.getText();
         int stock=Integer.parseInt(textStock.getText());
         int prix=Integer.parseInt(textPrix.getText());
          String libelle=textLibelle.getText();
         
     
        Article article=new Article(reference,stock,prix,libelle) ;
       if (metier.ajouterArticle(article)){
           Alert alert=new Alert(Alert.AlertType.INFORMATION);
           alert.setContentText("Article ajoutée avec succès");
           alert.setTitle("Information");
           alert.show();
           obArticle.add(article);
       }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setContentText("Erreur d'insertion");
           alert.setTitle("Erreur");
           alert.show();
           
       }
       }private void loadTAble() {
          
          tblcRef.setCellValueFactory(new PropertyValueFactory<>("reference"));
           tblcStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
             
             tblcPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
              tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tblvArticle.setItems(obArticle);
    }
    }
   
    

