package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Storage implements Serializable {

	private static ArrayList<Card>  inUse;
	private static ArrayList<Card>  used;
	private static ArrayList<Card>  undiscovered;
	private static Player player;
	
	public Storage() {

	}
	
	public void save(ArrayList<Card> inUse, ArrayList<Card> used, ArrayList<Card> undiscovered) {
		
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
			
			fos1.close();
			fos2.close();
			fos3.close();
			oos1.close();
			oos2.close();
			oos3.close();
		
		} catch (IOException e) {
		}
			
	}
	
	public void load() {
		try {
			FileInputStream fis1 = new FileInputStream ("inUse.save");
			ObjectInputStream ois1 = new ObjectInputStream (fis1);
			this.inUse= (ArrayList <Card>) ois1.readObject ();
			
			FileInputStream fis2 = new FileInputStream ("used.save");
			ObjectInputStream ois2 = new ObjectInputStream (fis2);
			this.used= (ArrayList <Card>) ois2.readObject ();
			
			FileInputStream fis3 = new FileInputStream ("undiscovered.save");
			ObjectInputStream ois3 = new ObjectInputStream (fis3);
			this.undiscovered= (ArrayList <Card>) ois3.readObject ();
			
			fis1.close();
			fis2.close();
			fis3.close();
			ois1.close();
			ois2.close();
			ois3.close();
			
		} catch(IOException | ClassNotFoundException e) {
		}
	}
	
	public void setStorage(ArrayList <Card> inUse, ArrayList <Card> used, ArrayList <Card> undiscovered) {
		this.inUse=inUse;
		this.used=used;
		this.undiscovered=undiscovered;
	}

	public  static ArrayList <Card> getInUse() {
		return inUse;
	}

	public static ArrayList <Card> getUsed() {
		return used;
	}

	public static ArrayList <Card> getUndiscovered() {
		return undiscovered;
	}

}

