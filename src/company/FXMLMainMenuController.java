/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Janis
 */
public class FXMLMainMenuController implements Initializable {
   
    // Hier wird ein ein Objekt der Jukebox Klasse für die Musik angelegt
   public static boolean firstPlayed = true;
    
    // die Szene
   @FXML private AnchorPane mainMenuPane;
   
    // Die labels, die im Menü benutzt wurden
    @FXML private Label label;
    @FXML private Label labelHeadline;
    @FXML private Label labelSubline;
    
    @FXML private ImageView imgNewGame;
    Sprites sprites = new Sprites();
    @FXML private ImageView imgLoadGame;
    @FXML private ImageView imgSettings;
    @FXML private ImageView imgExitGame;

    
    
    //Hier werden die Buttons initialisiert//
    
        //Das Event für den 'New' Game Button
    @FXML private void handleButtonStartAction() throws IOException, URISyntaxException {
        imgNewGame.setImage(sprites.displayMainMenuBtnNewGamePressed());
        Jukebox.select.play();
    }
    
    @FXML private void handleButtonStartActionReleased() throws IOException, URISyntaxException{
        Jukebox.main.getMediaPlayer().setVolume(Jukebox.main.getMediaPlayer().getVolume() / 2);
        //Hier wird die StoryCard Szene geladen    
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLNameMenu.fxml"));
        mainMenuPane.getChildren().setAll(pane);
    }
    
    
    
        //Das Event für den Load Button
   @FXML
    private void handleButtonLoadAction() throws URISyntaxException{
        imgLoadGame.setImage(sprites.displayMainMenuBtnLoadGamePressed());
         Jukebox.select.play();
    }


    @FXML private void handleButtonLoadActionReleased() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLLoadMenu.fxml"));
        mainMenuPane.getChildren().setAll(pane);
        System.out.println("Load Game Button pressed");
        label.setText("Load Game");
    }
    
    //Das Event für den Settings Button
   @FXML
    private void handleButtonSettingsAction() throws URISyntaxException{
         Jukebox.select.play();
         imgSettings.setImage(sprites.displayMainMenuBtnSettingsPressed());
    }

    @FXML private void handleButtonSettingsActionReleased() throws IOException {
        System.out.println("Settings Button pressed");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLSettingsMenu.fxml"));
        mainMenuPane.getChildren().setAll(pane);
        label.setText("Options");
    }
    
    
        //Das Event für den Exit Button
   @FXML
    private void handleButtonExitAction() throws URISyntaxException {
        imgExitGame.setImage(sprites.displayMainMenuBtnExitGamePressed());
        Jukebox.select.play();

    }

    @FXML private void handleButtonExitActionReleased() {
        System.out.println("Exit Button pressed");
        Stage stage = (Stage) imgExitGame.getScene().getWindow();
        stage.close();
    }
    
    
 @Override
    public void initialize(URL url, ResourceBundle rb)  {
        

//        sprites = new Sprites();
//       try {
//           buttonNewGame.setGraphic(new ImageView(sprites.displayMainMenuBtnSettings()));
//       } catch (URISyntaxException ex) {
//           Logger.getLogger(FXMLMainMenuController.class.getName()).log(Level.SEVERE, null, ex);
//       }

        
        }

}

