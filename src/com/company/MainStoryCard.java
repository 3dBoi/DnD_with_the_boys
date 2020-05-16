package com.company;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MainStoryCard extends ProgressCard {
    
    String main = null;
    String sub = null;
    String optA = null;
    String optB = null;
    String id = null;
    
    public MainStoryCard() throws FileNotFoundException{
    create();
    }
    

    
    //Die Story Karten werden eingelesen 
    public final void create() throws FileNotFoundException{

        String count = Integer.toString(StoryCard.linecounterMain);
       InputStream stream = MainStoryCard.class.getResourceAsStream("/resources/pools/main/"+count+".txt");
        try (Scanner sc = new Scanner(new InputStreamReader(stream))) {
            this.main = sc.nextLine();
            this.sub = sc.nextLine();
            this.optA = sc.nextLine();
            this.optB = sc.nextLine();
            this.id = sc.nextLine();
            sc.close();
            StoryCard.linecounterMain++;
        }
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

    public String getId() {
        return id;
    }
    
    

       
    
}
