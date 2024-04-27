package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;
import com.bucikft.Person.Student;
import com.bucikft.commands.*;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleUI {

    private HashMap<String, Command> commands = new HashMap<String, Command>();
    private Game game;
    private Scanner scanner = new Scanner(System.in);
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
        //commands.put("move", new Move());
        commands.put("godmode", new Godmode());
    }
    public void readCommands() throws IllegalArgumentException {
        System.out.println("please enter a command:");
        String command = scanner.nextLine();
        String[] commandParts = command.split(" ");
            if (commands.containsKey(commandParts[0])) {
                commands.get(commandParts[0]).execute(game, commandParts);
            } else {
                throw new IllegalArgumentException("invalid command");
            }
    }

    public void printGameState() {
        for (int i=0; i<4; i++) {
            System.out.println();
        }
        int turn = game.getRoundManager().getCurrentTurn();
        Person currentPlayer = game.getFocusedPerson();

        // draw map
        System.out.println("game with " + game.getStudents().size() + " players");
        System.out.println("current room: " + currentPlayer.getCurrentRoom());
        System.out.println(currentPlayer.getCurrentRoom().isGassed()? "room is gassed" : "room is not gassed");
        System.out.println("current round: " + game.getRoundManager().getCurrentRound());
        System.out.println("current player: "+ currentPlayer);
        System.out.println("moves left: " + currentPlayer.getMovesLeft());
        System.out.println("uses left: " + currentPlayer.getUsesLeft());
        System.out.println("doors in room:");
        for (Door door : currentPlayer.getCurrentRoom().getDoorList()) {
            door.printDoor(currentPlayer.getCurrentRoom());
        }
        System.out.println("\nitems in room:");
        for (Item item : currentPlayer.getCurrentRoom().getItemsList()) {
            System.out.println(item);
        }
        System.out.println("\ninventory:");
        for (Item item : currentPlayer.getItemList()) {
            System.out.println(item);
        }

    }
}
