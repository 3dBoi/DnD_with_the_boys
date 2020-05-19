/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Janis
 */
public class FXMLCombatController implements Initializable {

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
    public static EnemyCard enemy = new EnemyCard(100,100,2,10,10,5,new ArrayList<>(Arrays.asList(1,2,1)));
    static boolean playerattack;
    public static int counter = 0;

    
    
    @Override public void initialize(URL url, ResourceBundle rb) {
        create(FXMLNameMenuController.player, enemy); }    

    @FXML void  handleCombatBtnAttack(ActionEvent event) {
        doPlayerMove(FXMLNameMenuController.player, enemy, CombatMoves.ATTACK);
        checkCounter(FXMLNameMenuController.player, enemy);
        combatUpdate(FXMLNameMenuController.player, enemy);
    }

    @FXML private void handleCombatBtnDefend(ActionEvent event) {
        doPlayerMove(FXMLNameMenuController.player, enemy, CombatMoves.DEFEND);
        checkCounter(FXMLNameMenuController.player, enemy);
        combatUpdate(FXMLNameMenuController.player, enemy);
    }

    @FXML private void handleCombatBtnItems(ActionEvent event) {}
    
    
    //Die Werte vom Spieler und der Enemy Karte werden hier übergeben und auf der Szene geupdated
    private void create(Player player, EnemyCard enemy){
        combatLabelPlayerHP.setText("HP: "+ Integer.toString(player.getHealth()));
        combatLabelPlayerAD.setText("AD: "+Integer.toString(player.getMaxattack()));
        combatLabelPlayerDEF.setText("DEF: "+Double.toString(player.getDefence()));
        combatLabelPlayerCRIT.setText("CRT: "+Integer.toString(player.getCrit()));
        combatLabelEnemyHP.setText("HP: "+Integer.toString(enemy.getHealth()));    
    }
    
        private void combatUpdate(Player player, EnemyCard enemy){
        combatLabelPlayerHP.setText("HP: "+ Integer.toString(player.getHealth()));
        combatLabelEnemyHP.setText("HP: "+Integer.toString(enemy.getHealth()));    
    }
  
    
    public static void doPlayerMove(Player player, EnemyCard enemy, CombatMoves playermove) {
        switch (playermove) {
            case ATTACK:
                playerattack = true;
                break;
            case DEFEND:
                enemy.setAttack((int) (enemy.getAttack()/player.performDefence()));
                break;
            default:
                break;
        }
    }
        
    public static void doEnemyMove(Player player, EnemyCard enemy, int enemymove) {	
            switch (enemymove) {
            case 1:
		player.setHealth(player.getHealth()-enemy.performAttack());
            case 2:
			player.setAttack((int) (player.getAttack()/enemy.performDefence()));
		}
	}
    
    public static void checkCounter(Player player, EnemyCard enemy){
    if(counter < enemy.getMoveset().size()) {
	int enemymove = enemy.getMoveset().get(counter);
	doEnemyMove(player, enemy, enemymove);
            }else {
		counter=0;
		int enemymove = enemy.getMoveset().get(counter);
		doEnemyMove(player, enemy, enemymove); }
	if(playerattack) {
            enemy.setHealth(enemy.getHealth()-player.performAttack()); 
        
       } 
    }
}

            
