/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 *
 * @author Janis
 */
public class Inventory {
    
    /////////////////////////////////////////////////////////////////////////////
    //Das Inventar besteht aus einer Liste von allen Items, die der Spieler hat//
    //////und einer Liste von Gegenständen, die der Spieler ausgerüstet hat//////
    /////////////////////////////////////////////////////////////////////////////
    
    private ArrayList<ItemCard> inventoryContent;
    private EnumMap<SlotsE, EquipmentCard> equiped = new EnumMap<>(SlotsE.class);
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Mit der Equip Methode können Ausrüstungsgegenstände übergeben werden, die die Werte des Spielers verändern//
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void equip (EquipmentCard Weapon){
        
            //Falls im Inventar bereits etwas an dem Slot ausgerüstet ist, wird dieser unequiped
             if(FXMLNameMenuController.player.getInventory().equiped.containsKey(Weapon.getSlot())) {
                 System.out.println("Das Feld ist nicht leer!");
                unequip(FXMLNameMenuController.player.getInventory().getEquiped().get(Weapon.getSlot()));
                }
            //Ansonsten wird das Item ausgerüstet
            FXMLNameMenuController.player.getInventory().getEquiped().put(Weapon.getSlot(), Weapon);
            FXMLNameMenuController.player.setMaxattack(FXMLNameMenuController.player.getMaxattack() + Weapon.getAttack());
            FXMLNameMenuController.player.setDefence(FXMLNameMenuController.player.getDefence() + Weapon.getDefence());
            FXMLNameMenuController.player.setCrit(FXMLNameMenuController.player.getCrit() + Weapon.getCrit());
            System.out.println(Weapon.getName() + " ausgerüstet!");
        }
    
    
    
    //Hier werden die Ausrüstungsgegenstände abgelegt, und die Werte des Spoielers verändert
    public void unequip (EquipmentCard Weapon){
            //Falls sich im Equipment Menü das Item befindet, wird es abgelegt
            if  (FXMLNameMenuController.player.getInventory().getEquiped().containsValue(Weapon)) {
                System.out.println(FXMLNameMenuController.player.getInventory().getEquiped().remove(Weapon.getSlot()).getName() + " abgelegt!");
                FXMLNameMenuController.player.getInventory().getEquiped().remove(Weapon.getSlot());
            
                //Anschließend werden die Player Stats geupdated
                FXMLNameMenuController.player.setMaxattack(FXMLNameMenuController.player.getMaxattack() - Weapon.getAttack());
                //Warum hast du ursprünglich hier + gerechnet, Munir? Bei der Verteidigung?
                FXMLNameMenuController.player.setDefence(FXMLNameMenuController.player.getDefence() - Weapon.getDefence());
                FXMLNameMenuController.player.setCrit(FXMLNameMenuController.player.getCrit() - Weapon.getCrit());
            }
            }
    
    
    
    
    
     public ArrayList<ItemCard> getInventoryContent() {
        return inventoryContent;}

    public void setInventoryContent(ArrayList<ItemCard> inventoryContent) {
        this.inventoryContent = inventoryContent;}

    public EnumMap<SlotsE, EquipmentCard> getEquiped() {
        return equiped;}

    public void setEquiped(EnumMap<SlotsE, EquipmentCard> equiped) {
        this.equiped = equiped;}

    
    
    
    
    

    
    

    
   
    
}
