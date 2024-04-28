package com.bucikft.commands;

import com.bucikft.Game;

public class NoAI implements Command {

    /**
     * The execute method of the NoAI class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        game.setNoAi(!game.getNoAi());

        System.out.println("ai turned " + (game.getNoAi() ? "ON" : "OFF"));
    }
}
