package com.company;
import java.util.*;

public class Combat {
	static boolean playerattack;

	
	public static void main(String[] args) {
		
		//Player player = new Player(100,100,2,10,10,5, "Peter");
		EnemyCard enemy = new EnemyCard(100,100,2,10,10,5,new ArrayList<>(Arrays.asList(1,2,1)));
		comabtSequence(Main.player, enemy);
	}
	
	public static void comabtSequence(Player player, EnemyCard enemy) {
		
		Scanner s = new Scanner(System.in);
		int counter = 0;
		playerattack = false;
		
		while(player.getHealth()>0 && enemy.getHealth()>0) {
			
			System.out.println("1. attack \n2. defend \n3. Item");
			int playermove = s.nextInt();
			
			doPlayerMove(player, enemy, playermove);
						
			if(counter < enemy.getMoveset().size()) {
				int enemymove = enemy.getMoveset().get(counter);
				doEnemyMove(player, enemy, enemymove);
			}else {
				counter=0;
				int enemymove = enemy.getMoveset().get(counter);
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
	public static void doPlayerMove(Player player, EnemyCard enemy, int playermove) {
		
		if(playermove==1) {
			playerattack = true;
		}else if(playermove==2){
			enemy.setAttack((int) (enemy.getAttack()/player.performDefence()));
		}
	}
	

}