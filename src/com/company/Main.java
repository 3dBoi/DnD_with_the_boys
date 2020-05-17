/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.*;
import org.json.*;
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

        HashMap<String,EquipmentCard> Equipment = new HashMap<>();
        try {
            JSONTokener tokener = new JSONTokener(new FileReader("./src/com/resources/Datenbank.json")); //verwandelt Dokument in einen Json Token
            JSONObject obj = new JSONObject(tokener);                                              // erstellt Onjekte aus der Textdatei
            JSONArray arr = obj.getJSONArray("Items");                                      // Packt die Objekte in ein Json Array
            for (Object o : arr) {
                JSONObject json = (JSONObject) o;
                Equipment.put((String)json.get("name"), new EquipmentCard((String)json.get("name"),(int)json.get("attack"),(double)json.get("defence")));
                System.out.print("Weapon name: " + json.get("name") + ", attack: " + json.get("attack") + ", defence: " + json.get("defence") + "\n");
            }
        } catch (FileNotFoundException f) {
            System.out.println("FileNotFoundException: " + f.getLocalizedMessage() +"\n");
        } catch (JSONException j) {
            System.out.println("JSONException: " + j.getLocalizedMessage());
        }
    }
    

    
}
