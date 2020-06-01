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
public class Calculator {
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
    //In der Klasse befinden sich verschiedene Algorithmen, auf die mehrere Klassen zurückgreifen//
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    public double getRandomInt(int min, int max){
    return Math.random() * (max - min) + min;
    }
    
}
