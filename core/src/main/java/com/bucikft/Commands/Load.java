package com.bucikft.Commands;

import com.bucikft.Game;

public class Load implements Command {

    /**
     * The execute method of the Load class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 2)
            throw new IllegalArgumentException("Invalid number of arguments.");

        try {
            System.out.println("Loaded from " + args[1] + ".");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
