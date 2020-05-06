package com.company;
import java.util.*;

public class Combat {

	
	public static void main(String[] args) {
		
		ArrayList<Integer> moveset = new ArrayList<Integer>(Arrays.asList(1,2,1));
		Player player = new Player(100,100,2,10,10,5);
		EnemyCard enemy = new EnemyCard(100,100,2,10,10,5,moveset);
		comabtSequence(player, enemy, moveset);
	}
	
	public static void comabtSequence(Player player, EnemyCard enemy, ArrayList<Integer> moveset) {
		
		Scanner s = new Scanner(System.in);
		int counter = 0;
		boolean playerattack = false;
		
		while(player.getHealth()>0 && enemy.getHealth()>0) {
			
			System.out.println("1. attack \n2. defend \n3. Item");
			int playermove = s.nextInt();
			
			if(doPlayerMove(player, enemy, playermove)>0) {
				playerattack = true;
			}
			
			if(counter < moveset.size()) {
				int enemymove = moveset.get(counter);
				doEnemyMove(player, enemy, enemymove);
			}else {
				counter=0;
				int enemymove = moveset.get(counter);
				doEnemyMove(player, enemy, enemymove);			
			}
			
			if(playerattack) {
				enemy.setHealth(enemy.getHealth()-player.performAttack());
			}
			
			System.out.println("Player Health: "+player.getHealth());
			System.out.println("Enemy Health: "+enemy.getHealth());
			
			player.resetAttack();
			enemy.resetAttack();
			playerattack=false;
			counter++;
		}
	}
	
	//Aktion des Gegners 1 ist Angriff 2 ist verteidigen
	public static void doEnemyMove(Player player, EnemyCard enemy, int enemymove) {
		
		if(enemymove==1) {
			player.setHealth(player.getHealth()-enemy.performAttack());
		}else {
			player.setAttack((int) (player.getAttack()/enemy.performDefence()));
		}
	}
	//Aktion des Spielers 1 ist Angriff 2 ist verteidigen 3 ist Gegenstand
	public static int doPlayerMove(Player player, EnemyCard enemy, int playermove) {
		
		if(playermove==1) {
			return 1;
		}else if(playermove==2){
			enemy.setAttack((int) (enemy.getAttack()/player.performDefence()));
			return 0;
		}else {
			return 0;
		}
	}
	

}
