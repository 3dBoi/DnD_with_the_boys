package com.company;

public class Card {
    
    private String id;
    private String name;
    
    public Card(String id, String name){
    this.id = id;
    this.name = name;
    }
    
    public String getId(){
    return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(String id){
    this.id = id;}
   
    
    
    }
