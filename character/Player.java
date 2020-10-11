package rpgGame2.character;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import rpgGame2.item.Item;
import rpgGame2.item.Potion;
import rpgGame2.item.SmallSword;

public class Player extends Entity {
    private double atkRating;
    private double crit;
    public static int x;
    public static int y;
    private String location;
    public HashMap<String, Item> inv;    
    public HashMap<String, Integer> showInv;
    public List<String> equipped = new ArrayList<String>();
    
    public Player(String name, int lvl, int hp, int maxHp, int gp, 
	   double atkRating, double crit, int dmg, int xp) {
	this.lvl = lvl;
	this.name = name;
	this.hp = hp;
	this.maxHp = maxHp;
	this.crit = crit;
	this.atkRating = atkRating;
	this.gp = gp;
	this.dmg = dmg;
	this.xp = xp;
	showInv = new HashMap<String, Integer>();
	inv = new HashMap<String, Item>();
    }

    public Player() {}

    public void setName(String name) {
	this.name = name;
    }

    public void setPos(int y, int x) {
	this.x = x;
	this.y = y;
    }

    public int[] getPos() {
	int[] pos = new int[2];
	pos[0] = x;
	pos[1] = y;
	return pos;
    }

    public void checkLevel(int xp) {

    }

    public void takeDmg(int hp) {
	this.hp -= hp;
    }

    public void addGp(int gp) {
	this.gp += gp;
    }

    public void spendGp(int gp) {
	if((this.gp - gp) >= 0) {
	    this.gp -= gp;
	} else {
	    System.out.println("Not enough money");
	}
    }

    public void setDmg(int dmg) {
	this.dmg = dmg;
    }

    public int getMaxHp() {
	return maxHp;
    }
	    
    public void getStats() {
	System.out.println("====================\n" +
			   "Name: " + name +
			   "\nLevel: " + lvl +
			   "\nXp: " + xp +
			   "\nDMG: " + dmg +
			   "\nHp: " + hp + " / " + maxHp +
			   "\nGP: " + gp  +
			   "\nAtkRating: " + atkRating +
			   "\nCrit: " + crit +
			   "\n====================\n");
    }

    public void addXp(int xp) {
	this.xp += xp;
    }

    public String getLocation() {
	return location;
    }
    
    public void setLocation(String location) {
	this.location = location;
    }
}

