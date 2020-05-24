/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLSaveMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private AnchorPane saveMenuPane;
    
    @FXML private Button buttonSave1;
    @FXML private Button buttonSave2;
    @FXML private Button buttonSave3;
    @FXML private Button buttonSave4;
    @FXML private Button buttonSave5;
    @FXML private Button buttonSave6;
    @FXML private Button buttonBack;

    private HashMap<String,HashMap>  inUse;
    private HashMap<String,HashMap>  used;
    private HashMap<String,HashMap>  undiscovered;
    private Player player;
    private int current;
    
    @FXML private void handleButtonSave1Action(ActionEvent event) {
        
         Storage save1 = new Storage("Save1");
         save1.save(inUse, used, undiscovered, player);
            
    }
    
    @FXML private void handleButtonSave2Action(ActionEvent event) {
        
         Storage save2 = new Storage("Save2");
         save2.save(inUse, used, undiscovered, player);
            
    }
    
    @FXML private void handleButtonSave3Action(ActionEvent event) {
        
         Storage save3 = new Storage("Save3");
         save3.save(inUse, used, undiscovered, player);
            
    }
    
    @FXML private void handleButtonSave4Action(ActionEvent event) {
        
         Storage save4 = new Storage("Save4");
         save4.save(inUse, used, undiscovered, player);
            
    }
    
    @FXML private void handleButtonSave5Action(ActionEvent event) {
        
         Storage save5 = new Storage("Save5");
         save5.save(inUse, used, undiscovered, player);
            
    }
    
    @FXML private void handleButtonSave6Action(ActionEvent event) {
        
         Storage save6 = new Storage("Save6");
         save6.save(inUse, used, undiscovered, player);
            
    }
    
    //NOCH NICHT FERTIG
    @FXML private void handleButtonBackAction(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLMainMenu.fxml"));
        saveMenuPane.getChildren().setAll(pane);
    
    }

    
    //NOCH NICHT FERTIG
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //this.inUse = Algorithm.getInUse;
        //this.used = Algorithm.getUsed;
        //this.undiscovered = Algorithm.getUndiscovered;
        //this.player = Algorithm.getPlayer;
        //this.current = Algorithm.getCurrent;
    }    
    
}
