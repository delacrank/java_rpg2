package rpgGame2.worlds;

import rpgGame2.character.Entity;
import rpgGame2.character.Player;
import rpgGame2.character.Toad;
import rpgGame2.character.Bat;
import rpgGame2.Battle;
import rpgGame2.WorldMap;
import java.util.Random;

public class Forest extends World {

    private char[][] array = map.FOREST;
    private double stepCounter;
    private double encounterRate;
    
    public Forest() {
	stepCounter = .1;	
    }

    private Entity monsterGen() {
    	Random rand = new Random();
    	encounterRate = rand.nextDouble();
    	if(encounterRate > .5) {
    	    Entity monster = new Toad();
    	    return monster;
    	}
    	Entity monster = new Bat();
    	return monster;
	 
    }

    private void randomEncounter(Player p) {
    	stepCounter += .1;
    	Random rand = new Random();
    	encounterRate = rand.nextDouble();
    	if(stepCounter > encounterRate - .2) {
    	    stepCounter = 0;
    	    Entity m = monsterGen();
    	    Battle battle = new Battle(p, m);
    	    battle.battleMenu();
    	}
    }
    
    
    public void west(Player p) {
    	if(array[y][x] == 'p') {
	    if(array[y][x-1] == '.') {
		array[y][x] = '.';
		array[y][--x] = 'p';
		randomEncounter(p);
	    }
	    if(array[y][x-1] == '<') {
		System.out.println("Your back in town");
		p.setLocation("Town");
		p.setPos(7, 8);
		setPos(7,8);
	    }
	}
    }

    public void south(Player p) {
    	if(array[y][x] == 'p' && array[y+1][x] == '.') {
    	    array[y][x] = '.';
    	    array[++y][x] = 'p';
	    randomEncounter(p);
    	} 	 
    }

    public void east(Player p) {
    	if(array[y][x] == 'p' && array[y][x+1] == '.') {
    	    array[y][x] = '.';
    	    array[y][++x] = 'p';
	    randomEncounter(p);
    	} 
    }

    public void north(Player p) {
    	if(array[y][x] == 'p') {
	    if(array[y-1][x] == '.') {
		array[y][x] = '.';
		array[--y][x] = 'p';
		randomEncounter(p);
	    }
	    if(array[y][x] == 'p' && array[y][x+1] == '<') {
		System.out.println("Your back in town");
		p.setLocation("Town");
		p.setPos(7, 8);
		setPos(7, 8);
	    }
	}
    }
}
