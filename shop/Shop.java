package rpgGame2.shop;

import rpgGame2.character.Player;
import rpgGame2.Inventory;

public abstract class Shop {

    protected Player p = new Player();
    protected int option;
    protected boolean leave;

    public abstract void display(Player p, Inventory i);
	    
}
