/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.InputStream;
import java.net.URISyntaxException;
import javafx.scene.image.Image;


/**
 *
 * @author Janis
 */
public class Sprites {
    
            Image image;
            
                   
            public Image displayImage(String loc){   
            InputStream input= getClass().getResourceAsStream("/resources/textures/MenuSprites/"+loc);
            image = new Image(input);
            return image;
            }
            
//            public Image displayImage(String loc) throws URISyntaxException{
//            image = new Image(getClass().getResource("/resources/textures/MenuSprites/"+loc).toURI().toString());
//            return image;
//            }
            
            public Image displayMainMenuBtnNewGame() throws URISyntaxException{
                return displayImage("MainMenuBtnNewGame.png");
            }
            
            public Image displayMainMenuBtnNewGamePressed() throws URISyntaxException{
                return displayImage("MainMenuBtnNewGame_pressed.png");
            }
            
             public Image displayMainMenuBtnLoadGame() throws URISyntaxException{
                return displayImage("MainMenuBtnLoadGame.png");
            }
             
            public Image displayBlankButton() throws URISyntaxException{
                return displayImage("ButtonBlank.png");
            }
            
            public Image displayBlankButtonPressed() throws URISyntaxException{
                return displayImage("ButtonBlank_pressed.png");
            }
             
             public Image displayMainMenuBtnLoadGamePressed() throws URISyntaxException{
                return displayImage("MainMenuBtnLoadGame_pressed.png");
            }
             
             public Image displayMainMenuBtnSettings() throws URISyntaxException{
                return  image = displayImage("MainMenuBtnSettings.png");
            }
             
             public Image displayMainMenuBtnSettingsPressed() throws URISyntaxException{
                return image = displayImage("MainMenuBtnSettings_pressed.png");
            }
             
            public Image displayMainMenuBtnExitGame() throws URISyntaxException{
                return   image = displayImage("MainMenuBtnExitGame.png");
            }
            
             public Image displayMainMenuBtnExitGamePressed() throws URISyntaxException{
               return  image = displayImage("MainMenuBtnExitGame_pressed.png");
            }
            

}
