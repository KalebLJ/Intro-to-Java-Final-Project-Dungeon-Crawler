package project;

import java.util.Scanner;

public class RestRoom extends Room {

	public RestRoom() {
		super("You enter a room with with a bed and a small fountian filled with glowing water and hear a voice say:\n"
				+"		Do you wish to rest or improve yourself?");
	}

	@Override
	public void runRoom(Hero hero, Scanner in) {
		System.out.println(description);
		System.out.println("\n1. Rest restore all hp");
		System.out.println("2. Increase max health by 20");
		System.out.println("3. Increase armor by +1");
		System.out.println("4. Increase attack by +2");
		System.out.println("5. Increase damage by +5");
		
		int input;
		while(true)
		{
			try
			{
				input = in.nextInt();
				if(input == 1)
				{
					hero.setHealth(hero.getMaxHealth(), "h");
					break;
				}
				else if(input == 2)
				{
					hero.setMaxHealth(hero.getMaxHealth() + 20);
					hero.setHealth(20, "h");
					break;
				}
				else if(input == 3)
				{
					hero.setArmor(hero.getArmor() +1);
					break;
				}
				else if(input == 4)
				{
					hero.setAttack(hero.getAttack() + 2);
					break;
				}
				else if(input == 5)
				{
					hero.setDamage(hero.getDamage() + 5);
					break;
				}
				else
				{
					System.out.println("Please enter 1, 2, 3, 4, or 5");
				}
			}
			catch(Exception e)
			{
				in.nextLine();
				System.out.println("Please enter 1, 2, 3, 4, or 5");
			}
		}
		System.out.println("You feel rested and more powerfull after you leave!");
		Room.roomNumber++;
	}

}
