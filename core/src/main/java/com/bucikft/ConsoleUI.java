package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;
import com.bucikft.Commands.*;

import java.util.HashMap;
import java.util.Scanner;

public class ConsoleUI {

    private final HashMap<String, Command> commands = new HashMap<>(); // Added to store the commands
    private final Game game; // Added to store the game object
    private final Scanner scanner = new Scanner(System.in); // Added to read user input

    /**
     * Constructor to initialize a ConsoleUI object.
     * @param game The game object to store.
     */
    public ConsoleUI(Game game) {
        this.game = game;
        commands.put("debug", new Debug());
        commands.put("start", new Start());
        commands.put("exit", new ExitCommand());
        commands.put("next", new Next());
        commands.put("skip", new Skip());
        commands.put("pickup", new PickUp());
        commands.put("spawn", new Spawn());
        commands.put("drop", new Drop());
        commands.put("menu", new MenuCommand());
        commands.put("use", new Use());
        commands.put("move", new Move());
        commands.put("godmode", new Godmode());
        commands.put("load", new Load());
        commands.put("force", new Force());
        commands.put("join", new Join());
        commands.put("noai",new NoAI());
    }

    /**
     * Reads the commands from the user input.
     * @throws IllegalArgumentException If the command is invalid.
     */
    public void readCommands() throws IllegalArgumentException {
            System.out.println("please enter a command:");
            String command = scanner.nextLine();
            String[] commandParts = command.split(" ");

            try {
                if (commands.containsKey(commandParts[0])) {
                    commands.get(commandParts[0]).execute(game, commandParts);
                } else {
                    throw new IllegalArgumentException("invalid command");
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
    }

    /**
     * Prints the current state of the game.
     */
    public void printGameState() {
        for (int i = 0; i < 4; i++) {
            System.out.println();
        }

        Person currentPlayer = game.getFocusedPerson();

        // draw map
        System.out.println("game with " + game.getStudents().size() + " players");
        System.out.println("current room: " + currentPlayer.getCurrentRoom());
        System.out.println(currentPlayer.getCurrentRoom().isGassed()? "room is gassed" : "room is not gassed");
        System.out.println("current round: " + game.getRoundManager().getCurrentRound());
        System.out.println("current player: "+ currentPlayer);
        System.out.println("in the room: "+ currentPlayer);
        for (Person p : currentPlayer.getCurrentRoom().getPersonList()) {
            if(p != currentPlayer) System.out.println("\t" + p.toString());
        }
        System.out.println("moves left: " + currentPlayer.getMovesLeft());
        System.out.println("uses left: " + currentPlayer.getUsesLeft());
        System.out.println("doors in room:");
        for (Door door : currentPlayer.getCurrentRoom().getDoorList()) {
            door.printDoor(currentPlayer.getCurrentRoom());
        }
        System.out.println("\nitems in room:");
        for (Item item : currentPlayer.getCurrentRoom().getItemList()) {
            System.out.println(item);
        }
        System.out.println("\ninventory: ");
        if (!currentPlayer.getItemList().isEmpty()) {
            for (Item item : currentPlayer.getItemList()) {
                System.out.println(item);
            }
        } else {
            System.out.println("empty");
        }

        System.out.println("Current student: Student#" + game.getFocusedPerson().getName());
    }

}
