package com.company;

import java.util.*;



public class EquipmentCard extends ItemCard {

    private int attack;
    private double defence;
    private int critAdd;
    private final SlotsE slot;

    public EquipmentCard(String name,String id,int attack, double defence, SlotsE slot, int critAdd) {
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


        public SlotsE getSlot () {
            return slot;
        }

        public int getCrit () {
            return critAdd;
        }

        public void setCritAdd ( int critAdd){
            this.critAdd = critAdd;
        }
        
    @Override
    public String toString(){
    return "ID: " + getId() + "\n"+
            "Name: " + getName() + "\n"+
            "Slot: " + getSlot() + "\n";
    }





        }
    