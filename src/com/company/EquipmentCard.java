package com.company;

import java.util.*;

public class EquipmentCard extends ItemCard {

    private int attack;
    private double defence;
    private String name;
    private final int slot;

    public EquipmentCard(String name,int attack, double defence, int slot) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.slot = slot;
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


/*
    EquipmentCard Dagger = new EquipmentCard(5, 1);
    EquipmentCard Club = new EquipmentCard(8, 1);
    EquipmentCard Mace = new EquipmentCard(11, 1);
    EquipmentCard Sword = new EquipmentCard(14, 1);
    EquipmentCard Spear = new EquipmentCard(17,1);
    EquipmentCard Axe = new EquipmentCard(20, 1);
    EquipmentCard Warhammer = new EquipmentCard(24, 1);
    ArrayList<EquipmentCard> EquipmentList = new ArrayList<EquipmentCard>();
    Player player = new Player(100,100,2,10,10,5);
    */
    public void equip(EquipmentCard Weapon){







     //  com.company.Combat.player.setMaxattack(com.company.Combat.player.getMaxattack() + Weapon.getAttack());

    }

    public void unequip(EquipmentCard Weapon){

    }

}