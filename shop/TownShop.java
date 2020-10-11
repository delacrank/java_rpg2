package rpgGame2.shop;

import rpgGame2.character.Player;
import rpgGame2.item.Potion;
import rpgGame2.item.SmallSword;
import rpgGame2.item.Item;
import rpgGame2.Inventory;
import java.util.Scanner;

public class TownShop extends Shop {

    private int option = 0;
    private boolean leave = false;    
    
    public void display(Player p, Inventory i) {
	while(leave == false) {
	    System.out.println();
	    System.out.println("   Welcome to the Shop   ");
	    System.out.println("-------------------------");
	    System.out.println("1) Small potion: 20 hp, 30gp\n" +
			       "2) Small sword: +10 dmg, 70gp\n" +
			       "3) Leave shop \n");
	    Item potion = new Potion();
	    Item smallSword = new SmallSword();
	    Scanner sc = new Scanner(System.in);
	    while(!sc.hasNextInt()) {
		System.out.println("Thats not a number.");
		sc.next();
	    }
	    option = sc.nextInt();
	    switch(option) {
	    case 1:
		if(p.getGp() >= potion.getGp()) {
		    System.out.println("You have purchased a small pot.");
		    p.spendGp(potion.getGp());		    
		    i.addInv(potion.getName(), p);
		} else {
		    System.out.println("You don't have enough money");
		}
		break;
	    case 2:
		if(p.getGp() >= smallSword.getGp()) {
		    System.out.println("You have purchased a Small Sword.");
		    p.spendGp(smallSword.getGp());
		    i.addInv(smallSword.getName(), p);
		} else {
		    System.out.println("You don't have enough money");
		}
		break;
	    case 3:
		System.out.println("You have left the shop");
		leave = true;
		break;
	    default:
		System.out.println("invalid input");
		break;
	    }
	}
    }
}
		
		
