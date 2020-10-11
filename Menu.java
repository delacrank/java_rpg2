package rpgGame2;

import java.util.Scanner;
import rpgGame2.Inventory;
import rpgGame2.character.Player;
import rpgGame2.item.Item;

public class Menu {
    
    public char runMenu(Scanner sc, String characters) {

	System.out.println("Choose an option: \n" +
			   "----------------\n" +
			   "1) Up press w \n" +
			   "2) Left press a \n" +
			   "3) Right press d \n" +
			   "4) Down press s \n" +
			   "5) Character stats press c \n" +
			   "6) Inventory press i \n" +
			   "7) Equip Items press e \n" +
			   "8) Unequip Items press u \n" + 
			   "8) Quit press q \n");

	while(sc.hasNext()) {
	    char action = sc.next().charAt(0);
	    if(Character.toString(action).matches("[" + characters + "]")) {
		return action;
	    } else {
		return 'z';
	    }
	}
	return 'z';
    }

    public void runEquipMenu(Scanner sc,  Player p) {
        
	Inventory stor = new Inventory();
	int range = 0;
	range = p.inv.size();
    	for(Item i : p.inv.values()) {
    	    if(i.getConsumable() == false && i.getEquipped() == false) {
		for(int j = 1; j < range + 1; j++) {			
		    System.out.println("Choose an item to Equip:\n" + j + ") Press " + j + " to equip " + i.getName());
		    System.out.println("\nPress 0 to quit");

		    while(sc.hasNext()) {
			if(sc.hasNextInt()) {
			    int action = sc.nextInt();
			    if(action == 0) break;
			    if(action > 0 && action <= range) {
				stor.equipInv(i.getName(), p);
				System.out.println("Would you like to equip another item?");
			    } else {
				System.out.println("Number must be within range");			    
			    }
			} else {
			    System.out.println("Thats not a number");
			    sc.next();
			}	
		    }
		}            
	    }
	}
    }

    public void runUnequipMenu(Scanner sc,  Player p) {        
	Inventory stor = new Inventory();
	int range = 0;
	range = p.inv.size();
    	for(Item i : p.inv.values()) {
    	    if(i.getConsumable() == false && i.getEquipped() == true) {
		for(int j = 1; j < range + 1; j++) {			
		    System.out.println("Choose an item to unequip:\n" + j + ") Press " + j + " to unequip " + i.getName());
		    System.out.println("\nPress 0 to quit");

		    while(sc.hasNext()) {
			if(sc.hasNextInt()) {
			    int action = sc.nextInt();
			    if(action == 0) break;
			    if(action > 0 && action <= range) {
				stor.unequipInv(i.getName(), p);
				System.out.println("Would you like to unequip another item?");
			    } else {
				System.out.println("Number must be within range");			    
			    }
			} else {
			    System.out.println("Thats not a number");
			    sc.next();
			}	
		    }
		}            
	    }
	}
    }
}

