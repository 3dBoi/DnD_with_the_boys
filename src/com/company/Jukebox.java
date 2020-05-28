/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.net.URISyntaxException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author Janis
 */

public class Jukebox { 
    MediaPlayer musicplayer;
    
    public static Jukebox main = new Jukebox();
    public static Jukebox gameOver = new Jukebox();
    public static Jukebox select = new Jukebox();
    public static Jukebox confirm = new Jukebox();
    public static Jukebox speech = new Jukebox();
    
    public static Jukebox templateMusic = new Jukebox();
    public static Jukebox templateSounds = new Jukebox();
    
    public static double volumeSounds = 0.5;
    public static double volumeMusic = 0.5;


    //Hier wird der Pfad gesetzt
    private void setMusic(String loc){
        
        Media sound = null;
        try {
            sound = new Media(getClass().getResource("/resources/music/" + loc).toURI().toString());
        } catch (URISyntaxException e) {
        }
    
        musicplayer = new MediaPlayer(sound);
    }     
    
   public MediaPlayer getMediaPlayer(){
     return this.musicplayer;
    }
    
   public void play(){
   musicplayer.seek(Duration.ZERO);
   musicplayer.play();
   }
   
    public void setMainTheme(){
     setMusic("MainTheme.wav");
    }
    
    public void setMainTheme2(){
     setMusic("Evan King - 20XX - 07 Quote.wav");
    }
    public void setGameOver(){
     setMusic("mudeth - Game Over.mp3");
    }
    
     public void setTypecast(){
     setMusic("11 Typecast.wav");
     }
     
     public void setBasement(){
     setMusic("mudeth - Basement.mp3");
     }
    
        
    public void setTextAdvance(){
     setMusic("text_advance_1.wav");
    }
    
     public void setSelect(){
     setMusic("select.wav");
    }
     
     public void setSuccess(){
     setMusic("45 jingle_success_3.wav");
    }
     
    public void setHighlight(){
     setMusic("menu_highlight_1.wav");
    }
    
      public void setConfirm1(){
     setMusic("81 menu_confirm_1_dry.wav");
    }
      
    public void setonfirm1Rev(){
     setMusic("81 menu_confirm_1_reverb.wav");
    }
    
    public void setSpeechHigh1(){
     setMusic("61 speech_high_1.wav");}

    
    public void playRandomSpeechFemale(){
        Calculator calculator = new Calculator();
        int i = (int)calculator.getRandomInt(1, 4);
        switch(i){
            case 1: setMusic("61 speech_high_1.wav");
                    musicplayer.setVolume(volumeSounds);
                    musicplayer.play();
                 break;
            case 2: setMusic("62 speech_high_2.wav");
                     musicplayer.setVolume(volumeSounds);
                    musicplayer.play();
                 break;
            case 3: setMusic("63 speech_high_3.wav");
                     musicplayer.setVolume(volumeSounds);
                    musicplayer.play();
                 break;
            case 4: setMusic("64 speech_high_4.wav");
                     musicplayer.setVolume(volumeSounds);
                    musicplayer.play();
                 break; 
        }
        }
    
     public void playRandomSpeechMale(){
        Calculator calculator = new Calculator();
        int i = (int)calculator.getRandomInt(1, 4);
        switch(i){
            case 1: setMusic("73 speech_lowmid_1.wav");
                     musicplayer.setVolume(volumeSounds);
                    musicplayer.play();
                 break;
            case 2: setMusic("74 speech_lowmid_2.wav");
                     musicplayer.setVolume(volumeSounds);
                    musicplayer.play();
                 break;
            case 3: setMusic("75 speech_lowmid_3.wav");
                     musicplayer.setVolume(volumeSounds);
                    musicplayer.play();
                 break;
            case 4: setMusic("76 speech_lowmid_4.wav");
                     musicplayer.setVolume(volumeSounds);
                    musicplayer.play();
                 break; 
        }
        }
     
     public static void setAllSoundBoxes(){
    select.getMediaPlayer().setVolume(volumeSounds);
    confirm.getMediaPlayer().setVolume(volumeSounds);
        }
          
    public static void setAllMusicBoxes(){
        main.getMediaPlayer().setVolume(volumeMusic);
        gameOver.getMediaPlayer().setVolume(volumeMusic);
        }
          
        }
  


