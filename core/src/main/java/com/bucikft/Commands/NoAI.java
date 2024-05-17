package com.bucikft.Commands;

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

        System.out.println("AI turned " + (game.getNoAi() ? "ON" : "OFF") + ".");
    }

}
