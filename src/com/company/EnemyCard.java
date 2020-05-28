package com.company;

import java.util.ArrayList;

public class EnemyCard extends Card implements Character{
	
    
	private int health;
	private int maxhealth;
	private double defence;
	private int attack;
	private int maxattack;
	private int crit;
	private ArrayList<Integer> moveset = new ArrayList<>();
	
	public EnemyCard(String id, String name, int health, int maxhealth, double defence, int attack, int maxattack, int crit, ArrayList<Integer> moveset) {

                super(id, name);
		this.health = health;
		this.maxhealth = maxhealth;
		this.defence = defence;
		this.attack = attack;
		this.maxattack = maxattack;
		this.crit = crit;
		this.moveset = generateMoveset();
	}
	
	@Override public double performDefence() {
		return defence;
	}
	
	@Override public int performAttack() {
		
		int threshold = (int) (Math.random()*100);
		if(threshold<crit) {
			System.out.println("Enemycrit!");
			return attack*2;
		}else {
			return attack;
		}
	}
	
	@Override public void resetAttack() {
		attack = maxattack;
	}
        
        //Das Moveset für den Gegner wird hier erstellt
        //Muss aber noch überarbeitet werden!
        public static  ArrayList<Integer> generateMoveset(){
        Calculator calculator = new Calculator();
        ArrayList<Integer> generatedMoveset = new ArrayList<>();
        
        //Hier wird die Größe des Movesets von 1-10 bestimmt
        int size = (int)calculator.getRandomInt(1, 10);
        
        for(int i = 0; i<size; i++){
            int randomNum = (int)calculator.getRandomInt(1, 3);
            generatedMoveset.add(randomNum);
        }
        
        return generatedMoveset;
        }
	
	
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxhealth() {
		return maxhealth;
	}

	public void setMaxhealth(int maxhealth) {
		this.maxhealth = maxhealth;
	}

	public double getDefence() {
		return defence;
	}

	public void setDefence(double defence) {
		this.defence = defence;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getMaxattack() {
		return maxattack;
	}

	public void setMaxattack(int maxattack) {
		this.maxattack = maxattack;
	}
	
	public int getCrit() {
		return crit;
	}

	public void setCrit(int crit) {
		this.crit = crit;
	}

	public ArrayList<Integer> getMoveset() {
		return moveset;
	}

	public void setMoveset(ArrayList<Integer> moveset) {
		this.moveset = moveset;
	}
	
	
}