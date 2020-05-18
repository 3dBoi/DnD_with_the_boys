/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;


/**
 *
 * @author Janis
 */
public abstract class StoryCard {
    
    //Ausgangspunkt - Alle Karten sind auf 1
    public static int linecounterMain = 1;
    public static int linecounterSide1 = 1;
    public static int linecounterSide2 = 1;
    public static int linecounterSide3 = 1;
    
    //Die Karten werden zurückgesetzt
    public void reset(){
    linecounterMain = 1;
    linecounterSide1 = 1;
    linecounterSide2 = 1;
    linecounterSide3 = 1;
    }
    
    //Karten werden geladen
    public void load(int main, int side1, int side2, int side3){
    linecounterMain = main;
    linecounterSide1 = side1;
    linecounterSide2 = side2;
    linecounterSide3 = side3;
    }
    
    
}
