package project;

import java.util.Scanner;

public abstract class Room {
	
	protected String description;
	public static int roomNumber = 0;
	public abstract void runRoom(Hero hero, Scanner in);

	public Room(String des)
	{
		description = des;
	}
}
