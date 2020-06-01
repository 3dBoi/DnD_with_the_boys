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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Janis
 */
public class FXMLEndMenuController implements Initializable {

    //Szene wird deklariert
    @FXML private AnchorPane endMenuPane;
    
    //Buttons auf der Szene werden deklariert
    @FXML private Button buttonContinue;
    @FXML private Button buttonQuit;
    @FXML private Button buttonMainMenu;
 
    //Hier soll das Spiel vom letzten Speicherpunkt gestartet werden (?)
    @FXML private void handleButtonContinue(ActionEvent event) {
    }

    
    //Das Main Menu soll hier aufgerufen werden
    @FXML private void handleButtonMainMenu(ActionEvent event) throws IOException {
        Jukebox.gameOver.getMediaPlayer().pause();
        Jukebox.main.getMediaPlayer().play();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLMainMenu.fxml"));
        endMenuPane.getChildren().setAll(pane);
    }
    
    //Das Programm soll geschlossen werden
    @FXML private void handleButtonQuit(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();
        oldStage.close();
    }

    
    @Override public void initialize(URL url, ResourceBundle rb) {
        Jukebox.gameOver.getMediaPlayer().play();
        // TODO
    }    
    
}
