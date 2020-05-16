/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Janis
 */
public class FXMLStoryCardController implements Initializable {
    
    Jukebox jukebox = new Jukebox();

    // Die labels, die im Menü benutzt wurden
    @FXML public Label labelStoryCardMain;
    @FXML public Label labelStoryCardSub;
    @FXML public Label labelStoryCardID;
    
    //Die Buttons, die im Menü benutzt werden
    @FXML public Button buttonStoryCardOptA;
    @FXML public Button buttonStoryCardOptB;
    
    
    //Die Szene wird geupdated
    @FXML private void handleButtonOptA(ActionEvent event) throws FileNotFoundException {
    MainStoryCard newCard = new MainStoryCard();
    jukebox.playSelect();
    update(newCard);
    }
    
    //Die Szene wird geupdated
    @FXML private void handleButtonOptB(ActionEvent event) throws FileNotFoundException {
    MainStoryCard newCard = new MainStoryCard();
    jukebox.playSelect();
    update(newCard);
    }
    
    //Die Paramter des erstellen Objekts "MainStoryCard" werden übergeben, um die Labels und Buttons upzudaten
    @FXML
    public void update(MainStoryCard card){
        this.labelStoryCardMain.setText(card.getMain());
        this.labelStoryCardSub.setText(card.getSub());
        this.buttonStoryCardOptA.setText(card.getOptA());
        this.buttonStoryCardOptB.setText(card.getOptB());
        this.labelStoryCardID.setText(card.getId());
    }
    
    @FXML @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    
        
    }    
    
}
