package com.bucikft.Commands;

import com.bucikft.Game;

public class Debug implements Command {

    /**
     * Sets the debug mode of the game.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        game.setDebugMode(!game.getDebugMode());
        System.out.println("\nDebug mode " + (game.getDebugMode() ? "ON" : "OFF"));
    }

}
