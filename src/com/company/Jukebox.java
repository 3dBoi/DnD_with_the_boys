/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import static com.company.Main.musicplayer;
import java.net.URISyntaxException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Janis
 */
public class Jukebox {
    
     public static MediaPlayer musicplayer;
    
    public void changeMusic(String loc){
        
        Media sound = null;
        try {
            sound = new Media(getClass().getResource("/resources/music/" + loc).toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    
        musicplayer = new MediaPlayer(sound);
        musicplayer.play();
                
    
    }
    public void setVolume(double volume){
    Main.musicplayer.setVolume(volume);
    }
    
    public void setAutoPlay(){
    Main.musicplayer.setAutoPlay(true);
    }
    
    public void playMainTheme(){
    changeMusic("MainTheme");
    }
    
        public void playMainTheme2(){
    changeMusic("Evan King - 20XX - 07 Quote.wav");
    }
    
    public void playTextAdvance(){
    changeMusic("text_advance_1.wav");
    }
    
     public void playSelect(){
    changeMusic("select.wav");
    }
     
    public void playHighlight(){
    changeMusic("menu_highlight_1.wav");
    }
    
      public void playConfirm1(){
    changeMusic("81 menu_confirm_1_dry.wav");
    }
      
            public void playConfirm1Rev(){
    changeMusic("81 menu_confirm_1_reverb.wav");
    }
    
    
    
}
