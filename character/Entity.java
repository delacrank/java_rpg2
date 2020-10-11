package rpgGame2.character;

import rpgGame2.item.Item;

public class Entity {

    protected String name;
    protected int lvl;
    protected int hp;
    protected int maxHp;
    protected int gp;
    protected int dmg;
    protected int xp;
    protected Item item;

    public Entity() {}

    public String getName() {
	return name;
    }

    public int getLvl() {
	return lvl;
    }

    public int getHp() {
	return hp;
    }

    public int getMaxHp() {
	return maxHp;
    }

    public void setHp(int hp) {
	this.hp = hp;
    }

    public void loseHp(int hp) {
	this.hp -= hp;
    }

    public void resetHp() {
	hp = maxHp;
    }

    public int getGp() {
	return gp;
    }

    public int getDmg() {
	return dmg;
    }

    public void addDmg(int dmg) {
	this.dmg += dmg;
    }

    public void removeDmg(int dmg) {
	this.dmg -= dmg;
    }

    public int getXp() {
	return xp;
    }

    // public String getItem() {
    // 	Item item = new Item();
    // 	return 
    // }
}
