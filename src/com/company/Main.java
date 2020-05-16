/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.*;


public class Main extends Application {


    File data= new File("Datenbank.txt");
    Scanner S = new Scanner(data);
    String Data;
    Scanner Sc = new Scanner(Data);
    public static HashMap<String,EquipmentCard> Equipment = new HashMap<String, EquipmentCard>();
    //HashMap in der Ausrüstungsgegenstände, mit dem Namen Als Schlüssel aus einem Text Dokumet eingescannt und erstellt werden
    public Main() throws FileNotFoundException {
        while(S.hasNextLine()){
            Data=S.nextLine();
            Equipment.put(Sc.next(),new EquipmentCard(S.nextInt(),S.nextDouble()));

        }
    }


    @Override
    public void start(Stage stage) throws Exception {
   
        //Ein neues Fenster mit einer Scene wird erstellt
        Parent root;
        root = FXMLLoader.load(getClass().getResource("FXMLMenueMain.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //custom Font wird hier geladen
        
        
    }
    
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
    musicplayer.setVolume(0.6);
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    

    
}
