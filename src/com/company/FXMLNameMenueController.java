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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Janis
 */
public class FXMLNameMenueController implements Initializable {

    @FXML private AnchorPane nameMenuePane;
    @FXML private Label nameMenueLabelMain;
    @FXML private TextField nameMenueName;
    @FXML private Button nameMenueBtnAccept;
    @FXML private Button nameMenueBtnReturn;

    Jukebox jukebox = new Jukebox();
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML private void handleNameMenueName(ActionEvent event) {
    }

    @FXML private void handleNameMenueBtnAccept(ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLStoryCard.fxml"));
        nameMenuePane.getChildren().setAll(pane);
        //Die Jukebox Sounds werden hier geregelt
        jukebox.playConfirm1();
        Main.musicplayer.pause(); 
    }

    @FXML private void handleNameMenueBtnReturn(ActionEvent event) throws IOException {
        
        //Hier wird die MainMenue Szene geladen    
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLMenueMain.fxml"));
        nameMenuePane.getChildren().setAll(pane);
        //Die Jukebox Sounds werden hier geregelt
        jukebox.playSelect();
        Main.musicplayer.setVolume(0.5); 
        
    }
    
}
