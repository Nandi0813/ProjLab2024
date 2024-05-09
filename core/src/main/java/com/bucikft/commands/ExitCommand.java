package com.bucikft.commands;

import com.bucikft.Game;

public class ExitCommand implements Command {

    /**
     * The execute method of the ExitCommand class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        game.endGame();
        game.getProtoTest().setProtoTest(false);

        System.out.println("Exiting...");
        System.exit(0);
    }

}
