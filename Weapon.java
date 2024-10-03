package project;
import java.util.Random;

public class Weapon {
	private String name;
	private int damage; // size of damage dice
	private int damageBonus; // bonus to accuracy
	private int accuracyBonus; // bonus to accuracy
	private String statBonus = null;
	
	// lists for weapon generation
	private static String[] statList = new String[] {"armor", "attack", "damage", "maxHealth", null}; // stat bonuses
	private static String[] nameList = new String[] {"Dagger", "Longsword", "Greatsword", "Handaxe", "Axe", 
			"Greataxe", "Lance"}; // list of names of possible weapons
	private static int[] damageDiceList = new int[] {4, 8, 10, 6, 8, 12, 14}; // list of damage dice index corresponds with weapon name
	private static int[] damageBonusList = new int[] {6, 4, 6, 7, 5, 8, 9};
	private static int[] accuracyBonusList = new int[] {8, 5, 4, 6, 4, 2, 0};
	
	public Weapon(String name, int damage, int damageBonus, int accuracyBonus)
	{
		this.name = name;
		this.damage = damage;
		this.damageBonus = damageBonus;
		this.accuracyBonus = accuracyBonus;
	}
	
	public Weapon(String name, int damage, int damageBonus, int accuracyBonus, String statBonus)
	{
		this.name = name;
		this.damage = damage;
		this.damageBonus = damageBonus;
		this.accuracyBonus = accuracyBonus;
		this.statBonus = statBonus;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStatBonus()
	{
		return statBonus;
	}

	public int getDamage() {
		Random ran  = new Random();
		return (ran.nextInt(damage) + 1) + damageBonus;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDamageBonus() {
		return damageBonus;
	}

	public void setDamageBounus(int damageBounus) {
		this.damageBonus = damageBounus;
	}

	public int getAccuracyBonus() {
		return accuracyBonus;
	}

	public void setAccuracyBonus(int accuracyBonus) {
		this.accuracyBonus = accuracyBonus;
	}
	
	public String getWepStats()
	{
		if(statBonus == null)
		{
			return name + " Damage: 1d" + damage + " + " + damageBonus + " To Hit Bonus: " + accuracyBonus;
		}
		else if(statBonus == "maxHealth")
		{
			return name + " Damage: 1d" + damage + " + " + damageBonus + " To Hit Bonus: " 
		+ accuracyBonus + " Extra Health: " + (damageBonus * 2);
		}
		else
		{
			return name + " Damage: 1d" + damage + " + " + damageBonus + " To Hit Bonus: " 
					+ accuracyBonus + " Extra " + statBonus + ": " + damageBonus;
		}
	}

	public static Weapon generateWeapon(int rarity)
	{
		Random ran = new Random();
		int roll = ran.nextInt(7);
		int roll2 = ran.nextInt(5);
		Weapon wep = new Weapon(nameList[roll], damageDiceList[roll] + rarity, damageBonusList[roll] + rarity, 
				accuracyBonusList[roll] + rarity, statList[roll2]);
		return wep;
	}
	public static Weapon generateStartingWeapon(int rarity)
	{
		Random ran = new Random();
		int roll = ran.nextInt(7);
		Weapon wep = new Weapon(nameList[roll], damageDiceList[roll] + rarity, damageBonusList[roll] + rarity, 
				accuracyBonusList[roll] + rarity, null);
		return wep;
	}
	
	
	
	

}
