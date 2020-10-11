package rpgGame2.worlds;

import rpgGame2.character.Player;
import rpgGame2.WorldMap;

public abstract class World {

    protected WorldMap map;
    public Player p = new Player();
    protected int x = p.getPos()[0];
    protected int y = p.getPos()[1];
    protected char[][] array;
    
    public abstract void west(Player p);
    public abstract void north(Player p);
    public abstract void east(Player p);
    public abstract void south(Player p);

     public int getY() {
	return x;
    }

    public int getX() {
	return y;
    }

    public void setPos(int x, int y) {
	this.x = x;
	this.y = y;
    }


}
