package com.bucikft.Commands;

import com.bucikft.Game;

public class Start implements Command {

    /**
     * The execute method of the Start class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Invalid number of arguments.");
        }

        try {
            int playerCount = Integer.parseInt(args[1]);
            int mapSize = Integer.parseInt(args[2]);

            if (mapSize < 3 || mapSize > 10) {
                throw new IllegalStateException("Map size has to be between 3 and 10.");
            }

            if (playerCount < 1) {
                throw new IllegalStateException("Player count must be at least 1.");
            }

            if (playerCount > mapSize) {
                throw new IllegalStateException("Player count cannot be greater than map size.");
            }

            game.startGame(playerCount, mapSize);
        } catch (NumberFormatException e) {
            System.out.println("Invalid parameters. Please enter a number for player count and map size.");
        }
    }
}
