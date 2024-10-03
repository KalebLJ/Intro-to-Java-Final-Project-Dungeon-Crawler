package project;

import java.util.Random;
import java.util.Scanner;

// generates a dungeon full of monsters
public class Dungeon {
	// arrays that hold monster stats 
	//(String name, int health, int armor, int attack, int damage, String description, int level, int damageRoll)
	private static String[] name = new String[] {"HobGoblin", "Goblin", "Orc", "Animated Armor", "Minatuar", "Skeleton", "Ooze"};
	private static int[] health = new int[] {50, 25, 60, 20, 80, 20, 120};
	private static int[] armor = new int[] {16,14, 15, 20, 10, 17, 8};
	private static int[] attack = new int[] {6, 10, 4, 6, 2, 14, 4};
	private static int[] damage = new int[] {2, 12, 2, 6, 8, 8, 1};
	private static String[] description = new String[] {"tall and lanky creature swaggers foreward", "small and mischevious green creature"
			+ "moves foreward", "large green and mean creature stalks toward you", "suit of armor stepts foreward", "large bovin creature lowers its horns"
			, "animated skeleton clacks forward", "blob moves foreward oblivious of it's surroundings"};
	private static int[] damageRoll = new int[] {8, 4, 10, 5, 12, 10, 2};
	
	public static void runDungeon(Room[] dung, Hero hero, Scanner in)
	{
		for(int i = 0; i< dung.length -1; i++)
		{
			dung[i].runRoom(hero, in);
			Room.roomNumber++;
		}
	}
	
	
	public static Room[] generateDungeon(int roomNum)
	{
		Room.roomNumber = 0;
		Room[] dungeon;
		Random ran = new Random();
		int roomCountR = 0;
		int roomCountT = 0;
		if(roomNum < 5)
		{
			dungeon = new Room[5];
		}
		else
		{
			dungeon = new Room[roomNum];
		}
		for (int i = 0; i < dungeon.length -1; i++)
		{
			if(roomCountR == 6)
			{
				RestRoom r = new RestRoom();
				dungeon[i] = r;
				if(roomCountT > 2)
				{
					roomCountT = roomCountT - 2;
				}
				roomCountR = 0;
				Room.roomNumber++;
			}
			else if(roomCountT == 10)
			{
				TreasureRoom r = new TreasureRoom();
				dungeon[i] = r;
				roomCountT = 0;
				Room.roomNumber++;
			}
			else
			{
				int roll = ran.nextInt(5) + 1;
				if(roll == 1 || roll == 2 || roll == 3)
				{
					roll = ran.nextInt(7);
					Monster mos = new Monster(name[roll], health[roll], armor[roll], attack[roll], damage[roll], description[roll],
							Room.roomNumber, damageRoll[roll]);
					EncounterRoom E = new EncounterRoom(mos);
					dungeon[i] = E;
					roomCountR++;
					roomCountT++;
				}
				else if(roll == 4)
				{
					RestRoom r = new RestRoom();
					dungeon[i] = r;
					if(roomCountT > 2)
					{
						roomCountT = roomCountT - 2;
					}
					roomCountR = 0;
					Room.roomNumber++;
				}
				else
				{
					TreasureRoom r = new TreasureRoom();
					dungeon[i] = r;
					roomCountT = 0;
					Room.roomNumber++;
				}
			}
		}
		Room.roomNumber = 0;
		return dungeon;
	}
}
