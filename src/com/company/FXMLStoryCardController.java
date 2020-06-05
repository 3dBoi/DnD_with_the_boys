/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Janis
 */
public class FXMLStoryCardController implements Initializable {
    


    //Die Haupt-Szene
    @FXML public Pane storyCardPane;
    
    // Die labels, die auf der Szene liegen
    @FXML public Label labelStoryCardMain;
    @FXML public Label labelStoryCardSub;
    @FXML public Label labelStoryCardID;
    @FXML public Label labelPlayerName;
    
    //Die Buttons, die im Menü benutzt werden
    @FXML public Button buttonStoryCardOptA;
    @FXML public Button buttonStoryCardOptB;
    @FXML public Button buttonStoryCardBack;
    
    //Enthält die ID der aktuellen Karte, wichtig für Algorithmen
    public static int currentID; 
    
    
    //////Später löschen///////////
    @FXML private Button weaponA;
    @FXML private Button weaponB;
    
    
    
    
    //Die Szene wird geupdated
    @FXML private void handleButtonOptA(ActionEvent event) throws FileNotFoundException, IOException {
    switch (checkEventsA()){
        
        case STORYCARD:
                //Hier wird später aus der Queue entnommen
                MainStoryCard newCard = new MainStoryCard(null, null, null, null, null, null);
                update(newCard);
                break;
                
        case ENCOUNTERCARD:
                AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLCombat.fxml"));
                storyCardPane.getChildren().setAll(pane);
                break;
            
        case EQUIPMENTCARD:
                break;
    }
    
    }
    
    //Der Button "Back" wird initialisiert und das Hauptmenü wird geladen
    @FXML private void handleButtonBack(ActionEvent event) throws IOException{
    
    //Hier wird die MainMenue Szene geladen    
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLMainMenu.fxml"));
    storyCardPane.getChildren().setAll(pane);

    }
    
    //Option B wird initialisiert
    @FXML private void handleButtonOptB(ActionEvent event) throws FileNotFoundException {
    MainStoryCard newCard = new MainStoryCard(null, null, null, null, null, null);
    update(newCard);
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Die Paramter des erstellen Objekts "MainStoryCard" werden übergeben, um die Labels und Buttons upzudaten//
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void update(MainStoryCard card){
        this.labelStoryCardMain.setText(card.getMain());
        this.labelStoryCardSub.setText(card.getSub());
        this.buttonStoryCardOptA.setText(card.getOptA());
        this.buttonStoryCardOptB.setText(card.getOptB());
        this.labelStoryCardID.setText(card.getId());
        currentID = Integer.parseInt(card.getId().substring(1));
    }
    
   
    
    //Die Events für die jeweiligen IDs der Karten werden hier gehandelt
    //Es wird geguckt, welcher Typ von Karte nach der jetzigen folgt
    public CardsE checkEventsA() throws IOException{ 
        CardsE nextCard = CardsE.STORYCARD; 
        switch(currentID){
            case 1:
                System.out.println(Integer.toString(currentID));
                return nextIsEncounter(nextCard);
            case 2:
                System.out.println(Integer.toString(currentID));
                return nextIsStory(nextCard);
            case 3: 
                System.out.println(Integer.toString(currentID));
                return nextIsEncounter(nextCard);

            default: return nextCard;
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////
    //Die Algorithmen der Story Karten sollten vielleicht in die Story Karte Klasse verlagert werden//
    /////////////////////////////////////////////////////////////////////////////////////////////////
    public CardsE nextIsStory(CardsE nextCard){
        return nextCard = CardsE.STORYCARD;
    }
    
    public CardsE nextIsEncounter(CardsE nextCard){
        return nextCard = CardsE.ENCOUNTERCARD;
    }
    
    public CardsE nextIsItem(CardsE nextCard){
        return nextCard = CardsE.EQUIPMENTCARD;
    }
    
     public void checkEventsB() throws IOException{
    
        switch(currentID){
            case 2: System.out.println("Id: 2");
            break;
        }
    
    }
    
     
     ////////////////////////////////////////////////
     //Das passiert, wenn die Szene aufgerufen wird//
     /////Es wird eine neue Story Karte geladen//////
     ////////////////////////////////////////////////
 @Override public void initialize(URL url, ResourceBundle rb) {
        
        //Eine neue Karte wird erstellt
        MainStoryCard newCard = Main.MainStoryCardsHashMap.get("s1");
        //Die ID der Karte wird gespeichert
        currentID = Integer.parseInt(newCard.getId().substring(1));
        //Die Szenen-Elemente werden mit der neuen Karte aktualisiert
        update(newCard);
        //Für Dokumentation - wird später entfernt (?)
        labelPlayerName.setText(FXMLNameMenuController.player.getName());

    }    

  
    
}
