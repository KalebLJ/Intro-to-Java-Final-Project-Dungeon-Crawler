package project;

import java.util.Scanner;

public class projectMainPage {
	
	
//make sure to test out combat
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Room[] dungeon;
		//Weapon wep = Weapon.generateWeapon(0);
		//Weapon wept = new Weapon("test", 0, 2, 1, "maxHealth");
		//Weapon wt = new Weapon("test2", 0, 1, 1, null);
		//Hero hero = new Hero("John", 100, 16, 5, 5, wt);
		//System.out.println(hero);
		//hero.setWeapon(wept);
		//System.out.println(hero);
		
		//Room[] dung = Dungeon.generateDungeon(5);
		//Dungeon.runDungeon(dung, hero, in);
		//mon.getLoot(hero);
		
		//test.runRoom(hero, in);
		System.out.println("Greetings Hero what is your name?");
		String s;
		while(true)
		{
			s = in.nextLine();
			try
			{
				if(s.isEmpty() || s.isBlank())
				{
					throw new Exception();
				}
				else
				{
					break;
				}
			}
			catch(Exception e)
			{
				System.out.println("Please enter something for a name");
			}
		}
		System.out.println("Now that you have a name please select a weapon");
		Weapon w1 = Weapon.generateStartingWeapon(0);
		Weapon w2 = Weapon.generateStartingWeapon(0);
		Weapon w3 = Weapon.generateStartingWeapon(0);
		System.out.println( "1."+ w1.getWepStats() +  "\n2." + w2.getWepStats() + "\n3." + w3.getWepStats());
		int input;
		while(true)
		{
			try
			{
				input = in.nextInt();
				if(input == 1|| input == 2||  input == 3)
				{
					break;
				}
			}
			catch(Exception e)
			{
				in.nextLine();
				System.out.println("Please select 1, 2, or 3");
			}
		}
		Hero hero;
		
		if(input == 1)
		{
			hero = new Hero(s, 100, 14, 5, 2, w1);
		}
		else if( input == 2)
		{
			hero = new Hero(s, 100, 14, 5, 2, w2);
		}
		else
		{
			hero = new Hero(s, 100, 14, 5, 2, w3);
		}
		System.out.println(hero);
		while(true)
		{
			System.out.println("Now what size of dungeon would you like to delve into?");
			while(true)
			{
				try
				{
					input = in.nextInt();
					if(input <= 0)
					{
						throw new Exception();
					}
					else
					{
						break;
					}
				}
				catch(Exception e)
				{
					in.nextLine();
					System.out.println("Please enter a number greater than zero");
				}
			}
			dungeon = Dungeon.generateDungeon(input);
			Dungeon.runDungeon(dungeon, hero, in);
			System.out.println(hero);
			System.out.println("Congradulations hero! you have conqured a dungeon with " + dungeon.length + " rooms!\n"
					+ "Would you like to go again?(press y/Y for yes)" );
			s = in.next();
			if(s.equalsIgnoreCase("y"))
			{
				
			}
			else
			{
				break;
			}
		}
		System.out.println("Congradulations you have killed " + Hero.killlist.size() + " enemies!");
		for(String k : Hero.killlist)
		{
			System.out.println(k);
		}
		
		
		in.close();
	}
	
}
