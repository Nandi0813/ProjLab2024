package com.bucikft.commands;

import com.bucikft.Game;

public class Load implements Command {

    /**
     * The execute method of the Load class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 2) {
            System.out.println("invalid arguments");
            return;
        }
        try {
            game.getProtoTest().MapLoad(args[1], true, null);
            System.out.println("loaded from " + args[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
