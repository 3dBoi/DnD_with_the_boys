package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Storage implements Serializable {

	private static ArrayList inUse;
	private static ArrayList used;
	private static ArrayList undiscovered;
	private static Player player;
	
	public Storage() {
	}
	
	public void save(ArrayList inUse, ArrayList used, ArrayList undiscovered) {
		
		this.inUse=inUse;
		this.used=used;
		this.undiscovered=undiscovered;
		
		try {
			FileOutputStream fos1 = new FileOutputStream ("inUse.save");
			ObjectOutputStream oos1 = new ObjectOutputStream (fos1);
			oos1.writeObject (inUse);
			
			FileOutputStream fos2 = new FileOutputStream ("used.save");
			ObjectOutputStream oos2 = new ObjectOutputStream (fos2);
			oos2.writeObject (used);
		
			FileOutputStream fos3 = new FileOutputStream ("undiscovered.save");
			ObjectOutputStream oos3 = new ObjectOutputStream (fos3);
			oos3.writeObject (undiscovered);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public void load() {
		try {
			FileInputStream fis1 = new FileInputStream ("inUse.save");
			ObjectInputStream ois1 = new ObjectInputStream (fis1);
			this.inUse= (ArrayList) ois1.readObject ();
			
			FileInputStream fis2 = new FileInputStream ("used.save");
			ObjectInputStream ois2 = new ObjectInputStream (fis2);
			this.used= (ArrayList) ois2.readObject ();
			
			FileInputStream fis3 = new FileInputStream ("undiscovered.save");
			ObjectInputStream ois3 = new ObjectInputStream (fis3);
			this.undiscovered= (ArrayList) ois3.readObject ();
			
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setStorage(ArrayList inUse, ArrayList used, ArrayList undiscovered) {
		this.inUse=inUse;
		this.used=used;
		this.undiscovered=undiscovered;
	}

	public  static ArrayList getInUse() {
		return inUse;
	}

	public static ArrayList getUsed() {
		return used;
	}

	public static ArrayList getUndiscovered() {
		return undiscovered;
	}

}
