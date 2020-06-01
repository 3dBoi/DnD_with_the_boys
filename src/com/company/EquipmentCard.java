package com.company;

import java.util.*;

public class EquipmentCard extends ItemCard {

    private final int slot;
    private int attack;
    private double defence;
    private int critAdd;

    public EquipmentCard(String name,String id,int attack, double defence, int slot, int critAdd) {
        super(id,name);
        this.attack = attack;
        this.defence = defence;
        this.slot = slot;
        this.critAdd= critAdd;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public double getDefence() {
        return defence;
    }


        public void setDefence ( double defence){
            this.defence = defence;

        }


        public int getSlot () {
            return slot;
        }

        public int getCrit () {
            return critAdd;
        }

        public void setCritAdd ( int critAdd){
            this.critAdd = critAdd;
        }

        public void equip (EquipmentCard Weapon){
            if (FXMLNameMenuController.player.Equiped[Weapon.getSlot()] != null) {
                unequip(FXMLNameMenuController.player.Equiped[Weapon.getSlot()]);
            }
            FXMLNameMenuController.player.Equiped[Weapon.getSlot()] = Weapon;
            FXMLNameMenuController.player.setMaxattack(FXMLNameMenuController.player.getMaxattack() + Weapon.getAttack());
            FXMLNameMenuController.player.setDefence(FXMLNameMenuController.player.getDefence() - Weapon.getDefence());
            FXMLNameMenuController.player.setCrit(FXMLNameMenuController.player.getCrit() + Weapon.getCrit());
        }

        public void unequip (EquipmentCard Weapon){
            if (FXMLNameMenuController.player.Equiped[Weapon.getSlot()] != null) {
                FXMLNameMenuController.player.setMaxattack(FXMLNameMenuController.player.getMaxattack() - Weapon.getAttack());
                FXMLNameMenuController.player.setDefence(FXMLNameMenuController.player.getDefence() + Weapon.getDefence());
                FXMLNameMenuController.player.setCrit(FXMLNameMenuController.player.getCrit() - Weapon.getCrit());
                FXMLNameMenuController.player.Equiped[Weapon.getSlot()] = null;
            }


        }
    }

