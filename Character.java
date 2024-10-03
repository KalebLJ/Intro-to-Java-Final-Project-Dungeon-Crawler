package project;
import java.util.Random;

public abstract class Character {
	
	private String name; // name of character
	private int maxHealth; // the max amount of health a character can have
	private int health; // amount of damage they can take before dying
	private int armor; // how hard they are to damage
	private int attack; // bonus to hitting enemies
	private int damage; // bonus to damaging enemies
	//private Weapon weapon;
	
	public Character(String name, int health, int armor, int attack, int damage)
	{
		this.name = name;
		maxHealth = health;
		this.health = health;
		this.armor = armor;
		this.attack = attack;
		this.damage = damage;
	}
	
	public Character(int attack)
	{
		this.attack = attack;
	}
	
	public String getName() {
		return name;
	}
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health, String posOrNeg) {
		if(posOrNeg.equalsIgnoreCase("h"))
		{
		  this.health = this.health + health;
		  if(this.health > maxHealth)
		  {
			  this.health = maxHealth;
		  }
		}
		else
			this.health = this.health - health;
		
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAttackRoll()
	{
		Random ran = new Random();
		return (ran.nextInt(20)+1) + attack;
	}
	
	public abstract int getDamageRoll();
	
	

}
