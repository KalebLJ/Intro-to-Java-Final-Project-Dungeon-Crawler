package project;
import java.util.ArrayList;
import java.util.Random;

public class Hero extends Character{
	
	private Weapon weapon;
	private int potionNum;
	static ArrayList<String> killlist = new ArrayList<String>();
	
	public Hero(String name, int health, int armor, int attack, int damage, Weapon wep)
	{
		super(name, health, armor, attack, damage);
		weapon = wep;
		potionNum = 1;
	}
	public String toString()
	{
		return "Name: " + super.getName() + " Health " +  super.getHealth() + "/" + super.getMaxHealth() +
				" Armor: " + super.getArmor() + " Attack: " + super.getAttack() + " Damage: " + super.getDamage()
				+ " Potions: "  + potionNum + " " + weapon.getWepStats();
	}
	public Hero(int attack)
	{
		super(attack);
	}
	public int getPotionNum()
	{
		return potionNum;
	}
	public void setPotionNum(int add)
	{
		potionNum = potionNum + add;
	}
	
	public Weapon getWeapon()
	{
		return weapon;
	}
	
	public void setWeapon(Weapon wep)
	{
		if(weapon.getStatBonus() == null)
		{
			adjustWepStats(wep, 1);
		}
		else
		{
			adjustWepStats(weapon, -1);
			adjustWepStats(wep, 1);
		}
		weapon = wep;
	}
	@Override
	public int getAttackRoll()
	{
		return super.getAttackRoll() + weapon.getAccuracyBonus();
	}
	
	public int getDamageRoll()
	{
		Random ran = new Random();
		return (ran.nextInt(weapon.getDamage()+1) + super.getDamage() + weapon.getDamageBonus());
	}
	private void adjustWepStats(Weapon wep, int modifier)
	{
		switch(wep.getStatBonus())
		{
			case "armor":
			{
				super.setArmor(super.getArmor() + (wep.getDamageBonus() * modifier));
				break;
			}
			case "maxHealth":
			{
				super.setMaxHealth(super.getMaxHealth() + (wep.getDamageBonus() * modifier * 2) );
				super.setHealth(wep.getDamageBonus() * modifier * 2, posOrNeg(modifier));
				break;
			}
			case "attack":
			{
				super.setAttack(super.getAttack() + (wep.getDamageBonus() * modifier));
				break;
			}
			case "damage":
			{
				super.setDamage(super.getDamage() + (wep.getDamageBonus() * modifier));
				break;
			}
			default:
				break;
		}
	}
	
	private String posOrNeg(int mod)
	{
		if(mod == -1) {return"d";} else{return"h";}
	}
	
}
