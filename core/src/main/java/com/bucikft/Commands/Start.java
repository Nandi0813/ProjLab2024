package com.bucikft.Commands;

import com.bucikft.Game;
import com.bucikft.Map;

public class Start implements Command {

    /**
     * The execute method of the Start class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        try {
            int playerCount = Integer.parseInt(args[1]);
            int mapSize = Integer.parseInt(args[2]);

            if (mapSize < 3 || mapSize > 10) {
                throw new IllegalStateException("Map size has to be between 3 and 10.");
            }

            System.out.println("Game started with " + playerCount + " players, " + mapSize + " size.");
            game.setIsStarted(true);
            game.startGame(playerCount, mapSize);
        } catch (NumberFormatException e) {
            System.out.println("Invalid parameters. Please enter a number for player count and map size.");
        }
    }
}
