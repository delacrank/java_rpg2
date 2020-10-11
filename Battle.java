package rpgGame2;

import java.util.Scanner;
import java.util.Random;
import rpgGame2.Inventory;
import rpgGame2.character.Player;
import rpgGame2.character.Entity;
import rpgGame2.character.Bat;
import rpgGame2.character.Toad;

public class Battle {

    private Player p;
    private Entity m;
    
    public Battle(Player p, Entity m) {
	this.p = p;
	this.m = m;
    }

    public void fight() {
	System.out.println("You have taken " + m.getDmg());
	p.loseHp(m.getDmg());
	m.loseHp(p.getDmg());
	if(p.getHp() <= 0) {
	    System.out.println("You have died");
	    System.exit(0);
	}
	System.out.println("Remaining hp " + p.getHp());
	System.out.println("Remaining monster hp " + m.getHp());		     
    }

    public void flee() {
	System.out.println("You have taken " + m.getDmg());
	p.loseHp(m.getDmg());
	if(p.getHp() <= 0) {
	    System.out.println("You have died");
	    System.exit(0);
	}
	System.out.println("Remaining hp " + p.getHp());
    }
    
    public void battleMenu() {
	int action = 0;
	System.out.println();
	System.out.println("   Battle menu   ");
	System.out.println("-----------------");
	System.out.println();
	boolean success = false;
	boolean flee = false;
        Random rand = new Random();
	System.out.println("You have encountered a wild " + m.getName());
			   
	while(true) {
	   System.out.println("====================\n" +
                               p.getName() + "\n" +
			       "DMG: " + p.getDmg() + "\n" +
			       "HP: " + p.getMaxHp() + " / " + p.getHp() + "\n" +
			       "====================\n");
			       
	    System.out.println("\t\t\t\t\t\tChoose an option: \n" + 
	    "\t\t\t\t\t\t1) Fight \n" +
	    "\t\t\t\t\t\t2) Use item \n" +
	    "\t\t\t\t\t\t3) Flee");

	    System.out.println("====================\n" +
                               m.getName() + "\n" +
			       "DMG: " + m.getDmg() + "\n" +
			       "HP: " + m.getMaxHp() + " / " +  m.getHp() + "\n" +
			       "====================\n");
	    Scanner sc = new Scanner(System.in);
	    while(!sc.hasNextInt()) {
		System.out.println("Thats not a number.");
		sc.next();
	    }
	    action = sc.nextInt();
	    switch(action) {
	       case 1:
		   fight();
		   if(m.getHp() <= 0)
		       success = true;
		   break;
	       case 2:
		   //p.usePot();
		   break;
	       case 3:
		   int run = rand.nextInt(2);
		   if(run == 1) {
		       flee();		     	                               break;
		   } else {
		       flee = true;
		       break;
		   }
	       default:
		   System.out.println("invalid input");
		   break;
	    }
	    if(success) {
		System.out.println( "====================\n" +
				    "Gained " + m.getXp() +  " XP\n" +
				    "Gained " + m.getGp() + " Gold\n");
				    // "Gained " + m.getItem() + " Item(s)\n");
		p.addGp(m.getGp());
		// p.addInv(m.getItem());
		p.addXp(m.getXp());
		// p.checkLevel(p.getXp());
		m.resetHp();
		break;
	    }
	    if(flee) {
		m.resetHp();
		break;
	    }
	}
    }
}
