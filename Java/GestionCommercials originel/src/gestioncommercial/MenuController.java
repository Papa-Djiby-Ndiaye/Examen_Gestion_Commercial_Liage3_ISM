/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncommercial;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MenuController implements Initializable {

    @FXML
    private AnchorPane AnchorContent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AnchorPane view;
        try {
            loadView("Iusers");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleLoadViewUser(MouseEvent event) throws IOException {
         loadView("Iusers");
    }
    public void loadView(String view) throws IOException{
         AnchorPane viewLoading=  FXMLLoader.load(getClass().getResource(view+".fxml"));
      AnchorContent.getChildren().add(viewLoading);
    }

    @FXML
    private void handleLoadViewArticle(MouseEvent event) throws IOException {
        loadView("Iarticle");
 
    }

    @FXML
    private void handleLoadViewClatégorie(MouseEvent event) {
    }

    @FXML
    private void handleLoadViewCommande(MouseEvent event) throws IOException {
        loadView("IClientCommande");
    }
 
     
    }
 