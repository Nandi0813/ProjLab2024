package com.bucikft.commands;

import com.bucikft.Game;

public class Start implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length!=3) {
            System.out.println("invalid arguments");
            return;
        }
        try {
            int playerCount = Integer.parseInt(args[1]);
            int mapSize = Integer.parseInt(args[2]);
            if (mapSize<3 || mapSize>10) {
                System.out.println("map size has to be between 3 and 10");
                return;
            }
            System.out.println("game started with " + playerCount + " players, " + mapSize + " size");
            game.startGame(playerCount, mapSize);
        } catch (NumberFormatException e) {
            System.out.println("invalid arguments");
            return;
        }
    }
}
