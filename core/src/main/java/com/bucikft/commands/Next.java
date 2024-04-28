package com.bucikft.commands;

import com.bucikft.Game;

public class Next implements Command {

    /**
     * The execute method of the Next class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        System.out.println("turn ended");
        game.getRoundManager().nextTurn();

    }
}
