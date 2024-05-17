package com.bucikft.Commands;

import com.bucikft.Game;

public class Skip implements Command {

    /**
     * The execute method of the Skip class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (!game.getDebugMode()) {
            throw new IllegalArgumentException("Debug mode not ON.");
        }

        game.getRoundManager().nextRound();
        System.out.println("Round skipped, now playing: Student#" + game.getFocusedPerson().getName() + ".");
    }

}
