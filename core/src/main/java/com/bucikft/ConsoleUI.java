package com.bucikft;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;
import com.bucikft.commands.Command;
import com.bucikft.commands.Debug;
import com.bucikft.commands.ExitCommand;
import com.bucikft.commands.Start;

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
        Student currentPlayer = game.getStudents().get(turn);

        // draw map
        System.out.println("game with " + game.getStudents().size() + " players");
        System.out.println("current round: " + game.getRoundManager().getCurrentRound());
        System.out.println("current player: "+ currentPlayer);
        System.out.println("moves left: " + currentPlayer.getMovesLeft());
        System.out.println("uses left: " + currentPlayer.getUsesLeft());
        System.out.println("\ninventory:");
        for (Item item : currentPlayer.getItemList()) {
            System.out.println(item);
        }

    }
}
