/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Janis
 */
public class FXMLMainMenuController implements Initializable {
   
    // Hier wird ein ein Objekt der Jukebox Klasse für die Musik angelegt
    public static Jukebox jukeboxMain = new Jukebox();
    Jukebox jukeboxSounds = new Jukebox();
    
    // die Szene
   @FXML private AnchorPane mainMenuPane;
   
    // Die labels, die im Menü benutzt wurden
    @FXML private Label label;
    @FXML private Label labelHeadline;
    @FXML private Label labelSubline;
    
    //Die Buttons, die im Menü benutzt werden
    @FXML private Button buttonNewGame;
    @FXML private Button buttonSettings;
    @FXML private Button buttonExit;
    @FXML private Button buttonLoadGame;

    
    
    //Hier werden die Buttons initialisiert//
    
        //Das Event für den 'New' Game Button
    @FXML private void handleButtonStartAction(ActionEvent event) throws IOException {
        jukeboxMain.setVolume(0.2);
        StoryCard.linecounterMain = 1;
        //Hier wird die StoryCard Szene geladen    
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLNameMenu.fxml"));
        mainMenuPane.getChildren().setAll(pane);
        //Die Jukebox Sounds werden hier geregelt
        jukeboxSounds.playSelect();
    }
    
        //Das Event für den Load Button
    @FXML private void handleButtonLoadAction(ActionEvent event) {
        System.out.println("Load Game Button pressed");
        label.setText("Load Game");
        jukeboxSounds.playSelect();
    }
    
    //Das Event für den Settings Button
    @FXML private void handleButtonSettingsAction(ActionEvent event) {
        System.out.println("Settings Button pressed");
        label.setText("Options");
        jukeboxSounds.playSelect();
    }
    
    
        //Das Event für den Exit Button
    @FXML private void handleButtonExitAction(ActionEvent event) {
        System.out.println("Exit Button pressed");
        jukeboxSounds.playSelect();
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();
        oldStage.close();
    }
    
    
 @Override
    public void initialize(URL url, ResourceBundle rb) {

       
        
    }    
    
}
