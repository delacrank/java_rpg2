package rpgGame2.item;

public class Item {

    protected String iName;
    protected int iHealth;
    protected int iDmg;
    protected int iAtkRating;
    protected int iDef;
    protected int iGp;
    protected boolean iConsumable;    
    protected boolean iEquipped;
    
    public Item() {
    }

    public String getName() {
	return iName;
    }

    public int getHealth() {
	return iHealth;
    }
   
    public int getDmg() {
	return iDmg;
    }

    public int getAtkRating() {
	return iAtkRating;
    }

    public int getDef() {
	return iDef;
    }

    public int getGp() {
	return iGp;
    }
    
    public boolean getConsumable() {
	return iConsumable;
    }

    public boolean getEquipped() {
	return iEquipped;
    }

    public void setEquipped(boolean value) {
	iEquipped = value;
    }

}
