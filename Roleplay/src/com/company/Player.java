package com.company;

public class Player implements Character{
	
	private int health;
	private int maxhealth;
	private double defence;
	private int attack;
	private int maxattack;
	private int crit;
	
	public Player(int health, int maxhealth, double defence, int attack, int maxattack, int crit) {
		this.health = health;
		this.maxhealth = maxhealth;
		this.defence = defence;
		this.attack = attack;
		this.maxattack = maxattack;
		this.crit = crit;
	}
	
	@Override
	public double performDefence() {
		return defence;
	}
	
	@Override
	public int performAttack() {
		
		int threshold = (int) (Math.random()*100);
		if(threshold<crit) {
			System.out.println("Playercrit!");
			return attack*2;
		}else {
			return attack;
		}
	}
	
	@Override
	public void resetAttack() {
		attack = maxattack;
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
	
	

}
