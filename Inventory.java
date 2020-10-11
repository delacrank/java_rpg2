package rpgGame2;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import rpgGame2.item.Item;
import rpgGame2.item.Potion;
import rpgGame2.item.SmallSword;
import rpgGame2.character.Player;

public class Inventory {

    public void displayInv(Player p) {
    	for(HashMap.Entry<String, Integer> i : p.showInv.entrySet()) {
    	    for(HashMap.Entry<String, Item> e : p.inv.entrySet()) {
    		if(e.getValue().getEquipped() == true) {
    		    System.out.println("Item: " + i.getKey() + " Amount: " + i.getValue());
		    System.out.println("Item: " + e.getKey() + " Equipped: " + e.getValue().getEquipped());
    		} else {
    		    System.out.println("Item: " + i.getKey() + " Amount: " + i.getValue());
    		}	
    	    }
    	}
    }

    public void addInv(String s, Player p) {
	switch(s) {
	case "Potion":
	    Item Potion = new Potion();
	    p.inv.put(s, Potion);
	    break;
	case "SmallSword":
	    Item SmallSword = new SmallSword();
	    p.inv.put(s, SmallSword);
	    break;
	default:
	    System.out.println("Item not found");
	    break;
	}        
	if(p.showInv.containsKey(s)) {
	    Integer count = p.showInv.get(s);
	    p.showInv.put(s, count + 1);	           
	} else {
	    p.showInv.put(s, 1);	   
	}
    }
	    
    public void dropInv(String s, Player p) {
	if(p.showInv.containsKey(s) && p.inv.containsKey(s)) {
	    if(p.showInv.get(s) == 1) {
		p.showInv.remove(s);
		p.inv.remove(s);
	    } else {
		Integer count = p.showInv.get(s);
		p.showInv.put(s, count - 1);
		p.inv.remove(s);
	    }
	} else {
	    System.out.println("There is no item to remove");
	}
    }


    public void equipInv(String s, Player p) {
	if(p.inv.containsKey(s)) {
	    for(Item i : p.inv.values()) {
		if(i.getConsumable() == false && i.getEquipped() == false && !p.equipped.contains(s)) {
		    p.equipped.add(s);
		    p.addDmg(i.getDmg());		    
		    i.setEquipped(true);
		    System.out.println("You equipped the " + s);
		} else {
		    System.out.println("Cannot be equipped");
		}
	    }
	} else {
	    System.out.println("Item doesn't exist");	    
	}
    }

    public void unequipInv(String s, Player p) {
	if(p.inv.containsKey(s)) {
	    for(Item i : p.inv.values()) {
		if(i.getEquipped() == true && p.equipped.contains(s)) {
    		    p.equipped.remove(s);
		    p.removeDmg(i.getDmg());
		    i.setEquipped(false);
		    System.out.println("You have unequipped the " + s);
		} else {
		    System.out.println("Not Equipped");
		}
	    }
	} else {
	    System.out.println("Item doesn't exist");
	}	
    }	
}
