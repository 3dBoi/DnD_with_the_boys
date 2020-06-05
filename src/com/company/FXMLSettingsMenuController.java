/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import static com.company.Main.MainStoryCardsHashMap;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Janis
 */
public class FXMLSettingsMenuController implements Initializable {

    @FXML private AnchorPane settingsMenuPane;
    @FXML private Slider sliderMusic;
    @FXML private Slider sliderSounds;
    @FXML private Slider sliderGeneral;
    @FXML private Button settingsMenuBtnReturn;
    @FXML private Button btnButton;

    
    
        @FXML private void handleSettingsMenuBtnReturn(ActionEvent event) throws IOException {
        Jukebox.select.play();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLMainMenu.fxml"));
        settingsMenuPane.getChildren().setAll(pane);    
        
    }
        
             @FXML
            private void handleButton(ActionEvent event) {
                Jukebox.select.play();
                MainStoryCard card = MainStoryCardsHashMap.get("s1");
                int i = Integer.parseInt(card.getId().substring(1));
                System.out.println(card.getId());
                System.out.println(i);
                
    }
    
        
        
        /* Die Slider werden mit den globalen doubles "sliderMusic" und "sliderSounds" verbunden,
        danach werden die einzelnen Jukeboxes geupdated */
    @Override public void initialize(URL url, ResourceBundle rb) {
       sliderMusic.setValue(Jukebox.volumeMusic * 100);
       sliderSounds.setValue(Jukebox.volumeSounds* 100);
       
       sliderMusic.valueProperty().addListener(new InvalidationListener() {
           @Override public void invalidated(Observable observable) {
             Jukebox.volumeMusic = sliderMusic.getValue() / 100;
             Jukebox.setAllMusicBoxes();
           }
       });
       
       sliderSounds.valueProperty().addListener(new InvalidationListener() {
           @Override public void invalidated(Observable observable) {
             Jukebox.volumeSounds = sliderSounds.getValue() / 100;
             Jukebox.setAllSoundBoxes();
           }
       });
    }    




    
}
