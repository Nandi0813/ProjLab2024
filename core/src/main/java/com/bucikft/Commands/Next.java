package com.bucikft.Commands;

import com.bucikft.Game;

public class Next implements Command {

    /**
     * The execute method of the Next class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        System.out.println("Turn ended.");
        game.getRoundManager().nextTurn();
    }

}
