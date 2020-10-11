package rpgGame2;

import rpgGame2.character.Player;
import rpgGame2.Inventory;
import rpgGame2.worlds.World;
import rpgGame2.worlds.Town;
import rpgGame2.worlds.Forest;
import java.util.HashMap;
import java.util.Scanner;
import rpgGame2.item.*;

public class GameLoop {

    public void print(char[][] array) {
	for(int i = 0; i < array.length; i++) {
	    for(int j = 0; j < array[0].length; j++) {		
		System.out.print(array[i][j]);
	    }
	    System.out.println();
	}
    }
    
    public static void cls() {
	System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }
    
    public GameLoop() {
    	Menu menu = new Menu();
	Player player = new Player("John", 1, 200, 200, 50, .6, .1, 4, 0);
	Inventory inv = new Inventory();
	WorldMap map = new WorldMap();
	String location;
	player.setLocation("Town");
	player.setPos(1, 1);
	World w = new Town();
	char[][] array;
	array = map.TOWN;
	int[] pos = new int[2];
	Scanner sc = new Scanner(System.in);

	System.out.println("please input a(up), a (left), d (right) or s (down)\n" +
			   "c (character stats), i (inventory), e (equip items), u (unequip items)");
	print(array);
	char dir = ' ';

	while(true) {
	    
    	    pos[0] = w.getX();
	    pos[1] = w.getY();
	    location = player.getLocation();
	    
	    if(!location.equals(w.getClass().getName().substring(16))){
	    	switch(location) {
	    	case "Town":
	    	    w = new Town();				     
	    	    player.setPos(7, 8);
	    	    player.setLocation("Town");
		    pos[0] = w.getX();
		    pos[1] = w.getY();
	    	    array = map.TOWN;
		    cls();
		    print(array);
	    	    break;
	    	case "Forest":
	    	    w = new Forest();
	    	    player.setPos(2, 1);
		    pos[0] = w.getX();
		    pos[1] = w.getY();
	    	    player.setLocation("Forest");
    	    	    array = map.FOREST;
		    cls();
		    print(array);
	    	    break;
	    	case "Cave":
	    	    break;
	    	}
	    }
	    
	    System.out.println(pos[0] + " " + pos[1] + " Location: " +
			       location + " " + w.getClass().getName().substring(16));
	    dir = menu.runMenu(sc, "aAsSwWdDiIeEuUcCqQ");
	    cls();	    	
	    switch(dir) {
	    case 'a':
	    case 'A':
		w.west(player);
		print(array);
		break;
	    case 's':
	    case 'S':
		w.south(player);
		print(array);
		break;
	    case 'd':
	    case 'D':
		w.east(player);
		print(array);
		break;
	    case 'w':
	    case 'W':
		w.north(player);
		print(array);
		break;
	    case 'c':
	    case 'C':
		player.getStats();
		print(array);
		break;
	    case 'i':
	    case 'I':
		inv.displayInv(player);
		print(array);
		break;
    	    case 'e':
	    case 'E':
	    	menu.runEquipMenu(sc, player);
	    	print(array);
	    	break;
	    case 'u':
	    case 'U':
	    	menu.runUnequipMenu(sc, player);
	    	print(array);
	    	break;
    	    case 'q':
	    case 'Q':
		System.out.println("You have quit the game");
		System.exit(0);
		break;
	    case 'z':
	    case 'Z':
		System.out.println("Must input a character n, e, s, w");
		print(array);
		break;	    
	    default:
		System.out.println("invalid key");
		print(array);
		break;
	    }// end switch
	}// end while
    }
}
