package project;

import java.util.Scanner;

public class TreasureRoom extends Room implements Loot{

	public TreasureRoom() {
		super("You enter and see a stone table with 3 weapons and 1 potion on it before you with the words: "
				+ "\npick one to continue your journy");
	}

	@Override
	public void runRoom(Hero hero, Scanner in) {
		System.out.println(description);
		
		getLoot(hero, in);
		System.out.println("You now continue on to the next room!");
		Room.roomNumber++;

	}
	
	public void getLoot(Hero hero, Scanner in)
	{
		Weapon w1 = Weapon.generateWeapon(roomNumber);
		Weapon w2 = Weapon.generateWeapon(roomNumber);
		Weapon w3 = Weapon.generateWeapon(roomNumber);
		System.out.println("Make your choice!");
		System.out.println("1. " + w1.getWepStats());
		System.out.println("2. " + w2.getWepStats());
		System.out.println("3. " + w3.getWepStats());
		System.out.println("4. 1 health potion");
		int input;
		while(true)
		{
			try 
			{
				input = in.nextInt();
				if( input == 1)
				{
					hero.setWeapon(w1);
					break;
				}
				else if( input == 2)
				{
					hero.setWeapon(w2);
					break;
				}
				else if( input == 3)
				{
					hero.setWeapon(w3);
					break;
				}
				else if(input == 4)
				{
					hero.setPotionNum(1);
					break;
				}
				else
				{
					System.out.println("Please select 1, 2, 3, or 4");
				}
			}
			catch(Exception e)
			{
				in.nextLine();
				System.out.println("Please select 1, 2, 3, or, 4");
			}
		}
		
	}
	
	

}
