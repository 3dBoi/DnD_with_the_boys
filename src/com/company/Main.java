/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


public class Main extends Application {
    
        /////////////////////////////////////////////////////////////////////////////////////////   
        //Die drei HashMaps sollten vielleicht in eine eigene Loading-Klasse verschoben werden?//
        /////////////////////////////////////////////////////////////////////////////////////////
    
         public static HashMap<String, MainStoryCard> MainStoryCardsHashMap;
         public static HashMap<String, EnemyCard> EnemyCardsHashMap;
         public static HashMap<String, EquipmentCard> EquipmentCardsHashMap;
 

    @Override
    public void start(Stage stage) throws Exception {
   
        ///////////////////////////////////////////////////
        //Ein neues Fenster mit einer Scene wird erstellt//
        ///////////////////////////////////////////////////
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMainMenu.fxml"));
        Parent root;
        root = FXMLLoader.load(getClass().getResource("FXMLMainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
        ///////////////////////////////////////////////////////////////////////
        //Alle Story Karten, Enemy Karten und Item Karten werden hier geladen//
        ///////////////////////////////////////////////////////////////////////
             //Später in NameMenuController verschieben! Bzw. laden!//
             /////////////////////////////////////////////////////////
        
        EnemyCardsHashMap = new HashMap<>();
        MainStoryCardsHashMap = new HashMap<>();  
        EquipmentCardsHashMap = new HashMap<>();
        
        try {
            JSONTokener storyCardTokener = new JSONTokener(new FileReader("./src/resources/Datenbank.json"));
            JSONObject storyCardObject = new JSONObject(storyCardTokener);
            JSONArray storyCards = storyCardObject.getJSONArray("StoryCards");
            
            //Hier werden die StoryKarten eingelesen
            for (Object o: storyCards) {
                JSONObject json = (JSONObject) o;
                MainStoryCardsHashMap.put((String) json.get("id"), new MainStoryCard((String) json.get("id"), (String) json.get("name"), (String) json.get("main"), (String) json.get("sub"), (String) json.get("optA"), (String) json.get("optB")));
            }
            
            //Hier werden die EnemyKarten eingelesen
             JSONArray enemies = storyCardObject.getJSONArray("EnemyCards");
            for (Object o: enemies) {
                JSONObject json = (JSONObject) o;
                EnemyCardsHashMap.put((String) json.get("id"), new EnemyCard((String) json.get("id"), (String) json.get("name"), (int) json.get("health"), (int) json.get("maxhealth"), (double) json.get("defence"), (int) json.get("attack"), (int) json.get("maxattack"), (int) json.get("crit")));
            }
            
            //Hier werden die EquipmentCards eingelesen
             JSONArray equipment = storyCardObject.getJSONArray("Items");
            for (Object o: equipment) {
                JSONObject json = (JSONObject) o;
                EquipmentCardsHashMap.put((String) json.get("id"), new EquipmentCard((String) json.get("name"), (String)json.get ("id"), (int) json.get("attack"), (double) json.get("defence"), SlotsE.valueOf((String) json.get("slot")), (int) json.get("critAdd")));
            }
            
            
        } catch (FileNotFoundException f) {
            System.out.println("FileNotFound: " + f.getLocalizedMessage());
        } catch (JSONException e) {
            System.out.println("JSONException: " + e.getLocalizedMessage());
        }
        


        
        //Jukeboxes werden geladen, für Musik
        Jukebox.main.setMainTheme();
        Jukebox.gameOver.setGameOver();
        Jukebox.select.setSelect();
        Jukebox.confirm.setConfirm1();
        Jukebox.main.getMediaPlayer().play();
        Jukebox.main.getMediaPlayer().setVolume(Jukebox.volumeMusic);

    }
    
    public static void main(String[] args) {
                launch(args);
         
                
    }
    

    
}
