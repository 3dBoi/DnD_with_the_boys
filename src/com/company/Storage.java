package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Storage implements Serializable {
    
        private String location;
        
	private static HashMap<String,HashMap>  inUse;
	private static HashMap<String,HashMap>  used;
	private static HashMap<String,HashMap>  undiscovered;
	private static Player player;
        private static int current;
	
	public Storage(String location) {
            this.location = location;
	}
	
	public boolean save(HashMap<String,HashMap> inUse, HashMap<String,HashMap> used, HashMap<String,HashMap> undiscovered, Player player) {
		
		this.inUse=inUse;
		this.used=used;
		this.undiscovered=undiscovered;
                this.player=player;
                this.current=current;
		
		try {
			FileOutputStream fos1 = new FileOutputStream ("src/resources/savefiles/"+location+"/inUse.save");
			ObjectOutputStream oos1 = new ObjectOutputStream (fos1);
			oos1.writeObject (inUse);
			
			FileOutputStream fos2 = new FileOutputStream ("src/resources/savefiles/"+location+"/used.save");
			ObjectOutputStream oos2 = new ObjectOutputStream (fos2);
			oos2.writeObject (used);
		
			FileOutputStream fos3 = new FileOutputStream ("src/resources/savefiles/"+location+"/undiscovered.save");
			ObjectOutputStream oos3 = new ObjectOutputStream (fos3);
			oos3.writeObject (undiscovered);
                        
                        FileOutputStream fos4 = new FileOutputStream ("src/resources/savefiles/"+location+"/player.save");
			ObjectOutputStream oos4 = new ObjectOutputStream (fos4);
			oos4.writeObject (player);
                        
                        //FileOutputStream fos5 = new FileOutputStream ("src/resources/savefiles/"+location+"/current.save");
			//ObjectOutputStream oos5 = new ObjectOutputStream (fos5);
			//oos5.writeObject (current);
			
			fos1.close();
			fos2.close();
			fos3.close();
                        fos4.close();
                       // fos5.close();
			oos1.close();
			oos2.close();
			oos3.close();
                        oos4.close();
                        //oos5.close();
                        return true;
		
		} catch (IOException e) {
                    return false;
		}
			
	}
	
	public boolean load() {
		try {
			FileInputStream fis1 = new FileInputStream ("src/resources/savefiles/"+location+"/inUse.save");
			ObjectInputStream ois1 = new ObjectInputStream (fis1);
			this.inUse= (HashMap<String,HashMap>) ois1.readObject ();
			
			FileInputStream fis2 = new FileInputStream ("src/resources/savefiles/"+location+"/used.save");
			ObjectInputStream ois2 = new ObjectInputStream (fis2);
			this.used= (HashMap<String,HashMap>) ois2.readObject ();
			
			FileInputStream fis3 = new FileInputStream ("src/resources/savefiles/"+location+"/undiscovered.save");
			ObjectInputStream ois3 = new ObjectInputStream (fis3);
			this.undiscovered= (HashMap<String,HashMap>) ois3.readObject ();
                        
                        FileInputStream fis4 = new FileInputStream ("src/resources/savefiles/"+location+"/player.save");
			ObjectInputStream ois4 = new ObjectInputStream (fis4);
			this.player= (Player) ois4.readObject ();
                        
                        //FileInputStream fis5 = new FileInputStream ("src/resources/savefiles/"+location+"/current.save");
			//ObjectInputStream ois5 = new ObjectInputStream (fis5);
			//this.current= (int) ois5.readObject ();
			
			fis1.close();
			fis2.close();
			fis3.close();
                        fis4.close();
                        //fis5.close();
			ois1.close();
			ois2.close();
			ois3.close();
                        ois4.close();
                        //ois5.close();
                        return true;
			
		} catch(IOException | ClassNotFoundException e) {
                    return false;
		}
	}
	
	public void setStorage(HashMap<String,HashMap> inUse, HashMap<String,HashMap> used, HashMap<String,HashMap> undiscovered, Player player) {
		this.inUse=inUse;
		this.used=used;
		this.undiscovered=undiscovered;
                this.player=player;
	}

	public  static HashMap<String,HashMap> getInUse() {
		return inUse;
	}

	public static HashMap<String,HashMap> getUsed() {
		return used;
	}

	public static HashMap<String,HashMap> getUndiscovered() {
		return undiscovered;
	}
        
        public static Player getPlayer() {
		return player;
	}
        
        public static int getCurrent() {
		return current;
	}

}
