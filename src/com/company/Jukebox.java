/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import static java.lang.Integer.max;
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
    musicplayer.setVolume(volume);
    }
    
    public void setAutoPlay(){
    musicplayer.setAutoPlay(true);
    }
    
    public void pause(){
    musicplayer.pause();
    }
   
    
    
    public void dispose(){
    musicplayer.dispose();}
    
    public void play(){
    musicplayer.play();}
    
    public void stop(){
    musicplayer.stop();}
    
    public MediaPlayer getMediaPlayer() {
        return musicplayer;
	}
    
    public void playMainTheme(){
    changeMusic("MainTheme.wav");
    }
    
        public void playMainTheme2(){
    changeMusic("Evan King - 20XX - 07 Quote.wav");
    }
    
     public void playTypecast(){
    changeMusic("11 Typecast.wav");
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
    
    public void playSpeechHigh1(){
    changeMusic("61 speech_high_1.wav");}
    
    
    
    public void playRandomSpeechFemale(){
        int i = (int)getRandomInt(1,4);
        switch(i){
            case 1: changeMusic("61 speech_high_1.wav");
                 break;
            case 2: changeMusic("62 speech_high_2.wav");
                 break;
            case 3: changeMusic("63 speech_high_3.wav");
                 break;
            case 4: changeMusic("64 speech_high_4.wav");
                 break; 
        }
        }
    
     public void playRandomSpeechMale(){
        int i = (int)getRandomInt(1,4);
        switch(i){
            case 1: changeMusic("73 speech_lowmid_1.wav");
                 break;
            case 2: changeMusic("74 speech_lowmid_2.wav");
                 break;
            case 3: changeMusic("75 speech_lowmid_3.wav");
                 break;
            case 4: changeMusic("76 speech_lowmid_4.wav");
                 break; 
        }
        }
  
    public double getRandomInt(int min, int max){
    return Math.random() * (max - min) + min;
    }

}
