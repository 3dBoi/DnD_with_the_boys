/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


public class Main extends Application {

public static Player player;

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
        Player player = new Player(100,100,2,10,10,5, "Peter");
              //  FXMLMainMenuController.jukeboxMain.playTypecast();
             //   FXMLMainMenuController.jukeboxMain.setVolume(0.5);
                launch(args);


        HashMap<String, EquipmentCard> equipmentCardHashMap = new HashMap<>();
        try {
            JSONTokener tokener = new JSONTokener(new FileReader("./src/resources/Datenbank.json"));
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
