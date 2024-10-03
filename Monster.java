package project;
import java.util.Random;
import java.util.Scanner;

public class Monster extends Character implements Loot {
	
	private String description;
	private int level; // added to damage rolls based upon room number
	private int damageRoll; // size of dice rolled for damage
	
	
	public Monster(String name, int health, int armor, int attack, int damage, 
			String description, int level, int damageRoll)
	{
		super(name, health, armor, attack, damage);
		this.description = description; // description of monster when first seen
		this.level = level; // extra damage determined by room number # of rooms cleared /2
		this.damageRoll = damageRoll; // size of dice rolled for damage
	}
	
	public String getDescription()
	{
		return description;
	}
	public int getDamageRoll()
	{
		Random ran = new Random();
		return (ran.nextInt(damageRoll)+1 + super.getDamage() + ((level) + (level / 2)));
	}
	
	public void getLoot(Hero hero, Scanner in)
	{
		Random r = new Random();
		int roll = (r.nextInt(5)) + 1;
		switch(roll)
		{
		case 1:
		case 2:
			System.out.println("You have found a health potion!");
			hero.setPotionNum(hero.getPotionNum() +1);
			break;
		case 3:
		case 4:
			System.out.println("You have found a new weapon!");
			Weapon wep = Weapon.generateWeapon(level);
			System.out.println(wep.getWepStats());
			System.out.println("Would you like to replace your old weapon?");
			System.out.println(hero.getWeapon().getWepStats());
			int input;
			while(true)
			{
				System.out.println("Press 1 for yes or 2 for no.");
				input = in.nextInt();
				try
				{
					if( input == 1)
					{
						hero.setWeapon(wep);
						break;
					}
					if(input == 2)
					{
						break;
					}
				}
				catch(Exception e) 
				{
					in.nextLine();
				}
			}
			break;
		case 5:
			System.out.println("You have found two health potions!");
			hero.setPotionNum(hero.getPotionNum() +2);
			break;
		default:
			break;
		}
	}

}
