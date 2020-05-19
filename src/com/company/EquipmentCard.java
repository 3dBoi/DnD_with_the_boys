package com.company;

import java.util.*;

public class EquipmentCard extends ItemCard {

    private final int slot;
    public EquipmentCard[] Equiped = new EquipmentCard[10];
    private int attack;
    private double defence;
    private String name;
    private int critAdd;

    public EquipmentCard(String name,int attack, double defence, int slot, int critAdd) {
        this.name = name;
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

    public void setDefence(double defence) {
        this.defence = defence;

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getSlot(){
        return slot;
    }

    public int getCrit(){
        return critAdd;
    }

    public void setCritAdd(int critAdd) {
        this.critAdd = critAdd;
    }

    public void equip(EquipmentCard Weapon) {
        if (Equiped[Weapon.getSlot()] != null){
            unequip(Equiped[Weapon.getSlot()]);
        }
        Equiped[Weapon.getSlot()] = Weapon;
        Main.player.setMaxattack(Main.player.getMaxattack() + Weapon.getAttack());
        Main.player.setDefence(Main.player.getDefence() - Weapon.getDefence());
        Main.player.setCrit(Main.player.getCrit()+Weapon.getCrit());
    }

    public void unequip(EquipmentCard Weapon){
        if (Equiped[Weapon.getSlot()] != null){
            Main.player.setMaxattack(Main.player.getMaxattack() - Weapon.getAttack());
            Main.player.setDefence(Main.player.getDefence() + Weapon.getDefence());
            Main.player.setCrit(Main.player.getCrit() - Weapon.getCrit());
            Equiped[Weapon.getSlot()] =null;
        }

    }

}
