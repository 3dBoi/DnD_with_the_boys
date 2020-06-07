/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Janis
 */
public class FXMLItemCardController implements Initializable {

    private ItemCard itemcard;
    @FXML private AnchorPane itemCardPane;
    @FXML private StackPane itemCardStackPane;
    @FXML private Text textOpener;
    @FXML private Label textItem;
    @FXML private Button buttonEquip;
    @FXML private Button buttonAddInventory;
    @FXML private Tooltip itemTooltip;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override public void initialize(URL url, ResourceBundle rb) {
        itemcard = Main.EquipmentCardsHashMap.get("i1");
        create(Main.EquipmentCardsHashMap.get("i1"));
        // TODO
    }    
    
    public void create(ItemCard card){
    textItem.setText(card.getName());
    if(card instanceof EquipmentCard){
    itemTooltip.setText("AD: "+ ((EquipmentCard) card).getAttack() + " , DEF: " + ((EquipmentCard) card).getDefence());
    }
    else{
    buttonEquip.setVisible(false);
    buttonEquip.setDisable(true);
    }
    }

    @FXML private void handleButtonEquip(ActionEvent event) {
        FXMLNameMenuController.player.getInventory().equip((EquipmentCard)itemcard);
    }

    @FXML
    private void handleButtonAddToInv(ActionEvent event) {
        FXMLNameMenuController.player.getInventory().getInventoryContent().add(itemcard);
    }
    
}
