package com.company;





public class MainStoryCard extends Card {
    
    String main = null;
    String sub = null;
    String optA = null;
    String optB = null;
    
    //Konstruktor
     public MainStoryCard(String id, String name, String main, String sub, String optA, String optB) {
        super(id, name);
        this.main = main;
        this.sub=sub;
        this.optA =optA;
        this.optB = optB;
//    create();
    }

        
    public String getMain() {
        return main;
    }

    public String getSub() {
        return sub;
    }

    public String getOptA() {
        return optA;
    }

    public String getOptB() {
        return optB;
    }

    
    @Override
    public String toString(){
    return "ID: " + getId() + "\n"+
            "Main Text: " + getMain() + "\n"+
            "Sub Text: " + getSub() + "\n"+
            "Option A: " + getOptA() + "\n"+
            "Option B: " + getOptB();
    }
    

       
    
}
