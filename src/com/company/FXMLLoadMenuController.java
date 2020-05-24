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
 * @author Janis
 */
public class FXMLLoadMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    //Szene wird deklariert
    @FXML private AnchorPane loadMenuPane;
    
    //Buttons auf der Szene werden deklariert
    @FXML private Button buttonSave1;
    @FXML private Button buttonSave2;
    @FXML private Button buttonSave3;
    @FXML private Button buttonSave4;
    @FXML private Button buttonSave5;
    @FXML private Button buttonSave6;
    @FXML private Button buttonBack;
    @FXML private Button buttonStart;
    
    //Elemente die übergeben werden werden initalisiert
    private HashMap<String,HashMap>  inUse;
    private HashMap<String,HashMap>  used;
    private HashMap<String,HashMap>  undiscovered;
    private Player player;
    private int current;
    boolean loadgame=false;
    
    
     @FXML private void handleButtonSave1Action(ActionEvent event) {
         loadgame = false;
         Storage save1 = new Storage("Save1");
         loadgame= save1.load();
         this.inUse = save1.getInUse();
         this.used = save1.getUsed();
         this.undiscovered = save1.getUndiscovered();
         this.player = save1.getPlayer();
         this.current = save1.getCurrent();
            
    }
     
     @FXML private void handleButtonSave2Action(ActionEvent event) {
         loadgame = false;
         Storage save2 = new Storage("Save2");
         loadgame= save2.load();
         this.inUse = save2.getInUse();
         this.used = save2.getUsed();
         this.undiscovered = save2.getUndiscovered();
         this.player = save2.getPlayer();
         this.current = save2.getCurrent();
        
    }
     
     @FXML private void handleButtonSave3Action(ActionEvent event) {
         loadgame = false;
         Storage save3 = new Storage("Save3");
         loadgame= save3.load();
         this.inUse = save3.getInUse();
         this.used = save3.getUsed();
         this.undiscovered = save3.getUndiscovered();
         this.player = save3.getPlayer();
         this.current = save3.getCurrent();
        
    }
     
     @FXML private void handleButtonSave4Action(ActionEvent event) {
         loadgame = false;
         Storage save4 = new Storage("Save4");
         loadgame= save4.load();
         this.inUse = save4.getInUse();
         this.used = save4.getUsed();
         this.undiscovered = save4.getUndiscovered();
         this.player = save4.getPlayer();
         this.current = save4.getCurrent();
        
    }
     
     @FXML private void handleButtonSave5Action(ActionEvent event) {
         loadgame = false;
         Storage save5 = new Storage("Save5");
         loadgame= save5.load();
         this.inUse = save5.getInUse();
         this.used = save5.getUsed();
         this.undiscovered = save5.getUndiscovered();
         this.player = save5.getPlayer();
         this.current = save5.getCurrent();
        
    }
     
     @FXML private void handleButtonSave6Action(ActionEvent event) {
         loadgame = false;

         Storage save6 = new Storage("Save6");
         loadgame= save6.load();
         this.inUse = save6.getInUse();
         this.used = save6.getUsed();
         this.undiscovered = save6.getUndiscovered();
         this.player = save6.getPlayer();
         this.current = save6.getCurrent();
        
    }
     
     @FXML private void handleButtonBackAction(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLMainMenu.fxml"));
        loadMenuPane.getChildren().setAll(pane);
    
    }
     
     @FXML private void handleButtonStartAction(ActionEvent event) throws IOException {
         if(loadgame){
//            Algorithm(inUse, used, undiscovered, player, current);
         }else{
            Jukebox.main.getMediaPlayer().setVolume(0.2);
            Jukebox.select.getMediaPlayer().play();
            StoryCard.linecounterMain = 1;
            //Hier wird die StoryCard Szene geladen    
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLNameMenu.fxml"));
            loadMenuPane.getChildren().setAll(pane);
         }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

