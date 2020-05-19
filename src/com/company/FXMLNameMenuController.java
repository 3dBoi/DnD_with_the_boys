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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Janis
 */


public class FXMLNameMenuController implements Initializable {

    @FXML private AnchorPane nameMenuPane;
   
    @FXML private Label nameMenuLabelMain;
    @FXML private Label labelError;
    @FXML private TextField nameMenuName;
    @FXML private Button nameMenuBtnAccept;
    @FXML private Button nameMenuBtnReturn;

    Jukebox jukebox = new Jukebox();
    Jukebox jukeboxSpeech = new Jukebox();
    
    //Hier wird der Player für das Spiel erstellt
    public static Player player = new Player(100,100,2,10,10,5, "<InsertPlayerName>");
    

    //Hier wird der "Accept" Button initialisiert
    @FXML private void handleNameMenuBtnAccept(ActionEvent event) throws IOException {
        //Der Name des Spielers darf nicht leer sein!
                if((nameMenuName.getText().isEmpty() || nameMenuName.getText() == null)){
                    jukebox.playSelect();
            labelError.setText("Everybody has a name.");
        }
        else{ 
            if(nameMenuName.getText().equals("Mii")){
            jukebox.playSelect();
            labelError.setText("TaKe Me tO cHUrcH");
            }
            else{
                
        //Die erste StoryCard wird geladen   
        FXMLMainMenuController.jukeboxMain.getMediaPlayer().pause();
        player.setName(nameMenuName.getText());
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLStoryCard.fxml"));
        nameMenuPane.getChildren().setAll(pane);
        
        //Die Jukebox Sounds werden hier geregelt
        
        jukebox.playConfirm1();
            }
    }
    }
    
    //Damit das Textfield auch mit Enter funktioniert
    @FXML private void onEnter(KeyEvent keyevent) throws IOException {
        ActionEvent event = null;
        if(!(keyevent.getCode().equals(KeyCode.SPACE) || keyevent.getCode().equals(KeyCode.SHIFT) || keyevent.getCode().equals(KeyCode.BACK_SPACE)|| keyevent.getCode().equals(KeyCode.CONTROL))){   
            jukeboxSpeech.playRandomSpeechMale();
        }
        if(keyevent.getCode().equals(KeyCode.ENTER)){
        handleNameMenuBtnAccept(event);
        }   
    }

   

    //Hier wird der "Return" Button initialisiert
    @FXML private void handleNameMenuBtnReturn(ActionEvent event) throws IOException {
        FXMLMainMenuController.jukeboxMain.dispose();
        //Hier wird die MainMenu Szene geladen    
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLMainMenu.fxml"));
        nameMenuPane.getChildren().setAll(pane);
        //Die Jukebox Sounds werden hier geregelt
        jukebox.playSelect();        
    }
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


}
 
