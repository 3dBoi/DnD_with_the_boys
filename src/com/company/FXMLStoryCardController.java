/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Janis
 */
public class FXMLStoryCardController implements Initializable {
    
    Jukebox jukebox = new Jukebox();

    //Die Haupt-Szene
    @FXML public Pane storyCardPane;
    
    // Die labels, die auf der Szene liegen
    @FXML public Label labelStoryCardMain;
    @FXML public Label labelStoryCardSub;
    @FXML public Label labelStoryCardID;
    @FXML public Label labelPlayerName;
    
    //Die Buttons, die im Menü benutzt werden
    @FXML public Button buttonStoryCardOptA;
    @FXML public Button buttonStoryCardOptB;
    @FXML public Button buttonStoryCardBack;
    
    
    //Die Szene wird geupdated
    @FXML private void handleButtonOptA(ActionEvent event) throws FileNotFoundException {
    MainStoryCard newCard = new MainStoryCard();
    jukebox.playSelect();
    update(newCard);
    }
    
    //Der Button "Back" wird initialisiert und das Hauptmenü wird geladen
    @FXML private void handleButtonBack(ActionEvent event) throws IOException{
    jukebox.playSelect();
    
    //Hier wird die MainMenue Szene geladen    
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLMainMenu.fxml"));
    storyCardPane.getChildren().setAll(pane);

    }
    
    //Option B wird initialisiert
    @FXML private void handleButtonOptB(ActionEvent event) throws FileNotFoundException {
    MainStoryCard newCard = new MainStoryCard();
    jukebox.playSelect();
    update(newCard);
    }
    
    //Die Paramter des erstellen Objekts "MainStoryCard" werden übergeben, um die Labels und Buttons upzudaten
    @FXML
    public void update(MainStoryCard card){
        this.labelStoryCardMain.setText(card.getMain());
        this.labelStoryCardSub.setText(card.getSub());
        this.buttonStoryCardOptA.setText(card.getOptA());
        this.buttonStoryCardOptB.setText(card.getOptB());
        this.labelStoryCardID.setText(card.getId());
    }
    
    @FXML @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            MainStoryCard newCard = new MainStoryCard();
            update(newCard);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLStoryCardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        labelPlayerName.setText(FXMLNameMenuController.player.getName());

    }    
    
}
