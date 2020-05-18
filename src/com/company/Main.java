/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class Main extends Application {
    

    @Override
    public void start(Stage stage) throws Exception {
   
        //Ein neues Fenster mit einer Scene wird erstellt
        Parent root;
        root = FXMLLoader.load(getClass().getResource("FXMLMainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //custom Font wird hier geladen
        
        
    }
    
    /*
    //Play Main Music
     public static MediaPlayer musicplayer; {
    Media mainTheme = null;
        try {
            mainTheme = new Media(getClass().getResource("/resources/music/MainTheme.wav").toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    musicplayer = new MediaPlayer(mainTheme);
    musicplayer.setAutoPlay(true);
    musicplayer.setVolume(0.5);
}
*/
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                FXMLMainMenuController.jukeboxMain.playTypecast();
        launch(args);
    }
    

    
}
