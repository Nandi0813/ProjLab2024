package com.bucikft.commands;

import com.bucikft.Game;

public class Godmode implements Command {

    /**
     * The execute method of the Godmode class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 1) throw new IllegalArgumentException("invalid number of arguments");
        game.getFocusedPerson().setGodMode(!game.getFocusedPerson().isGodMode());
        System.out.println("godmode "+ (game.getFocusedPerson().isGodMode()? "ON" : "OFF"));
    }
}
