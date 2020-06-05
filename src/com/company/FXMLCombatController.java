/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Janis
 */
public class FXMLCombatController implements Initializable {

    @FXML private Pane combatPane;
    @FXML private Button combatButnAttack;
    @FXML private Button combatBtnDefend;
    @FXML private Button combatBtnItems;
    @FXML private Label labelCombatUpdates;
    @FXML private Label combatLabelPlayerHP;
    @FXML private Label combatLabelPlayerAD;
    @FXML private Label combatLabelPlayerDEF;
    @FXML private Label combatLabelPlayerCRIT;
    @FXML private Label combatLabelEnemyHP;
    @FXML private Label combatLabelEnemyName;
    public static EnemyCard enemy = new EnemyCard("E1", "Slime", 100,100,2,10,10,5);
    static CombatMovesE playermove;
    public static int counter = 0;
    
    //Nodes für den DevMode
    @FXML private TableView<EquipmentCard> godmodeTableview;
    @FXML private TableColumn<EquipmentCard, String> objectIdColumn;
    @FXML private TableColumn<EquipmentCard, String> objectNameColumn;
    @FXML private TableColumn<EquipmentCard, SlotsE> objectSlotColumn;
    @FXML private TableColumn<EquipmentCard, Integer> objectAdColumn;
    @FXML private TableColumn<EquipmentCard, Integer> objectDefColumn;
    @FXML private Button devmodeEquip;
    @FXML private Button devmodeUnequip;
    @FXML private ImageView enemySprite;
    @FXML private ImageView enemyCardTemplate;

    
    ////////////////////////////////////
    //Die Buttons werden initialisiert//
    ////////////////////////////////////
    

    @FXML void  handleCombatBtnAttack(ActionEvent event) throws IOException {
        playermove = CombatMovesE.ATTACK;
        combat(FXMLNameMenuController.player, enemy);
        combatUpdate(FXMLNameMenuController.player, enemy);
    }

    @FXML private void handleCombatBtnDefend(ActionEvent event) throws IOException {
        playermove = CombatMovesE.DEFEND;
        enemy.setAttack((int) (enemy.getAttack()/FXMLNameMenuController.player.performDefence()));
        combat(FXMLNameMenuController.player, enemy);
        combatUpdate(FXMLNameMenuController.player, enemy);
    }
    
    @FXML private void handleCombatBtnItems(ActionEvent event) {}
    

    public void updateAllStats(){
        Player player = FXMLNameMenuController.player;
        combatLabelPlayerHP.setText("HP: "+ Integer.toString(player.getHealth()));
        combatLabelPlayerAD.setText("AD: "+Integer.toString(player.getMaxattack()));
        combatLabelPlayerDEF.setText("DEF: "+Double.toString(player.getDefence()));
        combatLabelPlayerCRIT.setText("CRT: "+Integer.toString(player.getCrit()));
        combatLabelEnemyHP.setText(Integer.toString(enemy.getHealth()));    
    }
 
    
    //Die Werte vom Spieler und der Enemy Karte werden hier übergeben und auf der Szene geupdated
    private void create(Player player, EnemyCard enemy){
        combatLabelPlayerHP.setText("HP: "+ Integer.toString(player.getHealth()));
        combatLabelPlayerAD.setText("AD: "+Integer.toString(player.getMaxattack()));
        combatLabelPlayerDEF.setText("DEF: "+Double.toString(player.getDefence()));
        combatLabelPlayerCRIT.setText("CRT: "+Integer.toString(player.getCrit()));
        combatLabelEnemyHP.setText((Integer.toString(enemy.getHealth())));    
        combatLabelEnemyName.setText(enemy.getName());
        enemySprite.setImage(enemy.getImage());
    }
    
    
    
        private void combatUpdate(Player player, EnemyCard enemy) throws IOException{
        combatLabelPlayerHP.setText("HP: "+ Integer.toString(player.getHealth()));
        combatLabelEnemyHP.setText(Integer.toString(enemy.getHealth()));   
            //Falls die Lebenspunkte des Spielers auf 0 fallen - Game Over Menü
            if(player.getHealth() <= 0){
                Jukebox.main.getMediaPlayer().pause();
                AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLEndMenu.fxml"));
                combatPane.getChildren().setAll(pane);
            }
            //Gewinnt der Spieler den Kampf, so wird die nächste Story Card geladen -> In Zukunft Loot und weiteres Fenster (?)
            if(enemy.getHealth() <= 0){
            labelCombatUpdates.setText("VICTORY");
                AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLCard.fxml"));
                combatPane.getChildren().setAll(pane);}
        //Die Angrifftswerte werden für die nächste Runde zurückgesetzt
        enemy.setAttack(enemy.getMaxattack());
        player.setAttack(player.getMaxattack());
    }
        
        
        
    public void createDevmode(){
        //Das Tableview und die Buttons werden angezeigt
        godmodeTableview.setDisable(false);
        godmodeTableview.setVisible(true);
        devmodeEquip.setDisable(false);
        devmodeEquip.setVisible(true);
        devmodeUnequip.setDisable(false);
        devmodeUnequip.setVisible(true);
        //Die Spalten beziehen sich jeweils auf die Attribute der Story Karte
        objectIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        objectNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        objectSlotColumn.setCellValueFactory(new PropertyValueFactory<>("slot"));
        objectAdColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        objectDefColumn.setCellValueFactory(new PropertyValueFactory<>("defence"));
        
        //Für die Visualisierung der Objekte werden die Items aus der HashMap in eine Observable List transferiert
        ObservableList<EquipmentCard> items = FXCollections.observableArrayList();
        //Hier wird durch die EquipmentCard Map iterated und jedes Item der Observable List hinzugefügt
        Main.EquipmentCardsHashMap.values().forEach((i) -> {
            items.add(i);
        });
      godmodeTableview.setItems(items);
    }
    
    
    
    @FXML public void equipDevomode(){
    FXMLNameMenuController.player.getInventory().equip(godmodeTableview.getSelectionModel().getSelectedItem());
    updateAllStats();
    }
    
    @FXML private void unequipDevmode(ActionEvent event) {
    FXMLNameMenuController.player.getInventory().unequip(godmodeTableview.getSelectionModel().getSelectedItem());
     updateAllStats();
    }
  
   
    public  void doEnemyMove(Player player, EnemyCard enemy, int enemymove) {	
            switch (enemymove) {
                //Gegner greift an
            case 1:
		player.setHealth(player.getHealth()-enemy.performAttack());
                labelCombatUpdates.setText("Enemy attacked!");
                break;
                //Gegner verteidigt
            case 2:
			player.setAttack((int) (player.getAttack()/enemy.performDefence()));
                        labelCombatUpdates.setText("Enemy defends!!");
                        break;
		}
	}
    
    //Die Methoden berechnet die Algorithmen der Gegner KI
    public  void combat(Player player, EnemyCard enemy){
        
    if(counter < enemy.getMoveset().size()) { 
        //Es wird mit dem Runden Counter verglichen und geschaut, ob der Gegner angreift, oder verteidigt
	int enemymove = enemy.getMoveset().get(counter);
	doEnemyMove(player, enemy, enemymove);
        
             //der Counter wird aktualisiert, sobald das Moveset vom Gegner einen Run hatte
            }else {
		counter=0;
		int enemymove = enemy.getMoveset().get(counter);
		doEnemyMove(player, enemy, enemymove); }
    
	if(playermove.equals(CombatMovesE.ATTACK)) {
            enemy.setHealth(enemy.getHealth()-player.performAttack()); 
           
       } 
        counter++;
    }
    
        @Override public void initialize(URL url, ResourceBundle rb) {
        //Die Szene wird mit Werten vom Spieler und des Gegners aktualisiert
        create(FXMLNameMenuController.player, enemy);
        if(FXMLNameMenuController.player.getName().equals("withTheBoys")){
            createDevmode();
        }
        }
}
