package rpgGame2.worlds;

import rpgGame2.character.Player;
import rpgGame2.WorldMap;
import rpgGame2.shop.Shop;
import rpgGame2.shop.TownShop;
import rpgGame2.Inventory;

public class Town extends World {
    
    private char[][] array = map.TOWN;
    private Inventory inv = new Inventory();
    
    public Town() {
	
    }
    
    public void west(Player p) {
	if(array[y][x] == 'p') {
	    switch(array[y][x-1]) {
	    case '.':
		array[y][x] = '.';
		array[y][--x] = 'p';
		break;
	    case 's':
		System.out.println("You have entered the shop");
		Shop shop = new TownShop();
		shop.display(p, inv);
		break;
	    case 'h':
		p.resetHp();
		System.out.println("At your house you rest. Your health is refilled");
		break;
	    }
	}
    }
    
    public void south(Player p) {
	if(array[y][x] == 'p'){
	    switch(array[y+1][x]){
	    case '.':
		array[y][x] = '.';
		array[++y][x] = 'p';
		break;
	    case 's':
		System.out.println("You have entered the shop");
		Shop shop = new TownShop();
		shop.display(p, inv);
		break;
	    case 'h':
		p.resetHp();
		System.out.println("Your health is refilled");
		break;
	    case '>':
		System.out.println("You've entered the forest");		
		p.setLocation("Forest");
		p.setPos(1,2);
		setPos(1,2);
		break;
	    }
	}		 
    }

    public void east(Player p) {
	if(array[y][x] == 'p'){
	    switch(array[y][x+1]) {
	    case '.':
		array[y][x] = '.';
		array[y][++x] = 'p';
		break;
	    case 's':
		System.out.println("You entered the shop");
		Shop shop = new TownShop();
		shop.display(p, inv);
		break;
	    case 'h':
		p.resetHp();
		System.out.println("Your health is refilled");
		break;
	    case '>':
		System.out.println("You've entered the forest");
		p.setLocation("Forest");
		p.setPos(1,2);
		setPos(1, 2);
		break;
	    }
	}
    }

    public void north(Player p) {
	if(array[y][x] == 'p'){
	    switch(array[y-1][x]) {
	    case '.':
		array[y][x] = '.';
		array[--y][x] = 'p';
		break;
	    case's':
		System.out.println("You've entered the shop");
		Shop shop = new TownShop();
		shop.display(p, inv);
		break;
	    case 'h':
		p.resetHp();
		System.out.println("Your health is refilled");
		break;
	    }
	}
    }
}
