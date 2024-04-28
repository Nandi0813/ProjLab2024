package com.bucikft.commands;

import com.bucikft.Game;

public class Debug implements Command {

    /**
     * Sets the debug mode of the game.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        game.setDebugMode();
        System.out.println("\ndebug mode " + (game.getDebugMode() ? "ON" : "OFF"));
    }
}
