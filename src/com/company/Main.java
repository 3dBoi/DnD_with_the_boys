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

    public static HashMap<String, MainStoryCard> MainStoryCardsHashMap;
    public static HashMap<String, EnemyCard> EnemyCardsHashMap;
    public static HashMap<String, ItemCard> ItemCardsHashMap;
 

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
        
        ItemCardsHashMap = new HashMap<>();
        EnemyCardsHashMap = new HashMap<>();
        MainStoryCardsHashMap = new HashMap<>();      
        try {
            JSONTokener storyCardTokener = new JSONTokener(new FileReader("./src/resources/MainStoryCards.json"));
            JSONObject storyCardObject = new JSONObject(storyCardTokener);
            JSONArray items = storyCardObject.getJSONArray("StoryCards");
            for (Object o: items) {
                JSONObject json = (JSONObject) o;
                MainStoryCardsHashMap.put((String) json.get("id"), new MainStoryCard((String) json.get("id"), (String) json.get("name"), (String) json.get("main"), (String) json.get("sub"), (String) json.get("optA"), (String) json.get("optB")));
            }
        } catch (FileNotFoundException f) {
            System.out.println("FileNotFound: " + f.getLocalizedMessage());
        } catch (JSONException e) {
            System.out.println("JSONException: " + e.getLocalizedMessage());
        }

        
        //Jukeboxes werden geladen, für Musik
        Jukebox.main.setBasement();
        Jukebox.gameOver.setGameOver();
        Jukebox.select.setSelect();
        Jukebox.confirm.setConfirm1();
        Jukebox.main.getMediaPlayer().play();
        Jukebox.main.getMediaPlayer().setVolume(Jukebox.volumeMusic);

        System.out.println(Jukebox.main.musicplayer.getVolume());

        
        //custom Font wird hier geladen
        
        //Alle MediaPlayer werden hier geladen
        
        
        
    }
    
    public static void main(String[] args) {
                launch(args);
                
    }
    

    
}
