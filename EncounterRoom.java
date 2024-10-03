package project;

import java.util.Scanner;

public class EncounterRoom extends Room {
	private Monster monster;

	public EncounterRoom(Monster monster) {
		super("The room is hazy and indinstinct however you see something moving in the  fog!");
		this.monster = monster;
	}

	@Override
	public void runRoom(Hero hero, Scanner in) {
		System.out.println(description);
		System.out.println("As you enter the room you see a " + monster.getDescription() + " and attacks!" );
		Turn.runCombat(hero, monster, in);
		System.out.println("You have defeated the: " + monster.getName() + " !");
		Hero.killlist.add(monster.getName());
		System.out.println("As you stand over your defeated foe you notice some loot that was hidden in the room");
		
		monster.getLoot(hero, in);
		
		Room.roomNumber ++;
		System.out.println("You now venture into the next room!");

	}

}
