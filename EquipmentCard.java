package com.company;

public class EquipmentCard extends ItemCard {

    private int attack;
    private double defence;

    public EquipmentCard(int attack, double defence){
        this.attack=attack;
        this.defence=defence;
    }

    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) { this.attack = attack; }

    public double getDefence() {
        return defence;
    }
    public void setDefence(double defence) {
        this.defence = defence;
    }

}
