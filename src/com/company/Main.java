/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


public class Main extends Application {
    

    @Override
    public void start(Stage stage) throws Exception {
   
        //Ein neues Fenster mit einer Scene wird erstellt
        Parent root;
        root = FXMLLoader.load(getClass().getResource("FXMLMainMenue.fxml"));
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
        //launch(args);

        HashMap<String, EquipmentCard> equipmentCardHashMap = new HashMap<>();
        try {
            JSONTokener tokener = new JSONTokener(new FileReader("./src/com/resources/Datenbank.json"));
            JSONObject object = new JSONObject(tokener);
            JSONArray items = object.getJSONArray("Items");
            for (Object o: items) {
                JSONObject json = (JSONObject) o;       //Schlüssel durch Card id ersetzen
                equipmentCardHashMap.put((String) json.get("name"), new EquipmentCard((String) json.get("name"), (int) json.get("attack"), (double)(Integer) json.get("defence"), (int) json.get("slot"), (int)json.get("critAdd")));
             //   equipmentCardHashMap.put((String) json.get("name"), new EquipmentCard((String) json.get("name"), (int) json.get("attack"), (double) json.get("defence"), (int) json.get("slot")));
            }
        } catch (FileNotFoundException f) {
            System.out.println("FileNotFound: " + f.getLocalizedMessage());
        } catch (JSONException e) {
            System.out.println("JSONException: " + e.getLocalizedMessage());
        }
    }
    

    
}
