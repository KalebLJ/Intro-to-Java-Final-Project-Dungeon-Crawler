package project;
import java.util.Scanner;

//Holds methods for running combat and other input as well as the end of game screen
public class Turn {

	
	public static void runCombat(Hero hero, Monster foe, Scanner in)
	{
		wait(5000);
		System.out.println("Combat begins against the " + foe.getName() + "!");
		int acB = 0;
		int dmgB = 0;
		int roll;
		int choice;
		System.out.println("You strike first!");
		while(true)
		{
			choice = 0;
			System.out.println("\nIt is your turn what do you do?");
			System.out.println("Hero: " + hero.getName() + " Health: " + hero.getHealth() + "/" + hero.getMaxHealth() + 
					" Armor: " + (hero.getArmor() + acB) + " Potions: "  + hero.getPotionNum());
			while(true)
			{
				System.out.println("1. Attack: make 2 attacks with your weapon");
				System.out.println("2. Warding Attack: make 1 attack and increase\n your armor by 2 for the combat");
				System.out.println("3. Weakening Attack: make 1 attack and weaken your enemy \nmaking them take extra damage"
						+ "for the duration of the combat");
				System.out.println("4. Drink a health potion: heal 50 hp");
				try
				{
					choice = in.nextInt();
					if(choice == 1 || choice == 2 || choice ==3 || choice ==4)
					{
						break;
					}
				}
				catch(Exception e)
				{
					in.nextLine();
					System.out.println("Please select an action!");
				}
			}
			switch(choice)
			{
			case 1:
				System.out.println("You attack once!");
				roll = hero.getAttackRoll();
				if(roll >= foe.getArmor())
				{
					int dmg = hero.getDamageRoll() + dmgB;
					System.out.println("You hit the " + foe.getName() + " for " + dmg + " damage!");
					foe.setHealth(dmg, "d");
				}
				else
				{
					System.out.println("You miss with your first attack");
				}
				if(foe.getHealth() <= 0)
				{
					return;
				}
				wait(2000);
				System.out.println("Your second attack");
				roll = hero.getAttackRoll();
				if(roll >= foe.getArmor())
				{
					int dmg = hero.getDamageRoll() + dmgB;
					System.out.println("You hit the " + foe.getName() + " for " + dmg + " damage!");
					foe.setHealth(dmg, "d");
				}
				else
				{
					System.out.println("You miss with your second attack");
				}
				if(foe.getHealth() <= 0)
				{
					return;
				}
				break;
			case 2:
				System.out.println("Your armor increases by 2!");
				acB = acB + 2;
				System.out.println("You attack!");
				roll = hero.getAttackRoll();
				if(roll >= foe.getArmor())
				{
					int dmg = hero.getDamageRoll() + dmgB;
					System.out.println("You hit the " + foe.getName() + "for " + dmg + " damage!");
					foe.setHealth(dmg, "d");
				}
				else
				{
					System.out.println("You miss with your attack");
				}
				if(foe.getHealth() <= 0)
				{
					return;
				}
				break;
			case 3:
				System.out.println("Your damage increases by 2!");
				dmgB = dmgB + 2;
				System.out.println("You attack!");
				roll = hero.getAttackRoll();
				if(roll >= foe.getArmor())
				{
					int dmg = hero.getDamageRoll() + dmgB;
					System.out.println("You hit the " + foe.getName() + "for " + dmg + " damage!");
					foe.setHealth(dmg, "d");
				}
				else
				{
					System.out.println("You miss with your attack");
				}
				if(foe.getHealth() <= 0)
				{
					return;
				}
				break;
			case 4:
				if(hero.getPotionNum() > 0)
				{
					hero.setPotionNum(-1);
					hero.setHealth(50, "h");
					System.out.println("Your health is now: " + hero.getHealth() + "/" + hero.getMaxHealth());
				}
				else
				{
					System.out.println("Not enough potions! You attack twice instead!");
					wait(3000);
					System.out.println("You attack once!");
					roll = hero.getAttackRoll();
					if(roll >= foe.getArmor())
					{
						int dmg = hero.getDamageRoll() + dmgB;
						System.out.println("You hit the " + foe.getName() + "for " + dmg + " damage!");
						foe.setHealth(dmg, "d");
					}
					else
					{
						System.out.println("You miss with your first attack");
					}
					if(foe.getHealth() <= 0)
					{
						return;
					}
					wait(2000);
					System.out.println("Your second attack");
					roll = hero.getAttackRoll();
					if(roll >= foe.getArmor())
					{
						int dmg = hero.getDamageRoll() + dmgB;
						System.out.println("You hit the " + foe.getName() + "for " + dmg + " damage!");
						foe.setHealth(dmg, "d");
					}
					else
					{
						System.out.println("You miss with your second attack");
					}
					if(foe.getHealth() <= 0)
					{
						return;
					}
				}
				break;
			}
			System.out.println("....");
			wait(5000);
			System.out.println("The " + foe.getName() + " attacks!");
			int dmg;
			roll = foe.getAttackRoll();
			if(roll - foe.getAttack() == 20)
			{
				dmg = foe.getDamageRoll();
				System.out.println("The " + foe.getName() + " hits you for " + dmg + " damage!");
				hero.setHealth(dmg, "d");
				if(hero.getHealth() <= 0)
				{
					death(hero, foe.getName(), in);
				}
			}
			else if(roll > (hero.getArmor() + acB))
			{
				dmg = foe.getDamageRoll();
				System.out.println("The " + foe.getName() + " hits you for " + dmg + " damage!");
				hero.setHealth(dmg, "d");
				if(hero.getHealth() <= 0)
				{
					death(hero, foe.getName(), in);
				}
				else
				{
					hero.setHealth(dmg, "d");
				}
			}
			else
			{
				System.out.println("The " + foe.getName() + " misses!");
			}
			wait(3000);
		}
	}
	
	public static void death(Hero hero, String killer, Scanner in)
	{
		System.out.println("You have been killed by a " + killer + "!");
		if(Hero.killlist.size() == 0)
		{
			System.out.println("You didn't manage to kill anything!");
		}
		else
		{
			System.out.println("Before you died you killed:");
			for(String s : Hero.killlist)
			{
				System.out.println(s);
			}
		}
		System.out.println("Relaunch to try again!");
		in.close();
		System.exit(0);
	}
	
	public static void wait(int ms)
	{
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}
	
}
