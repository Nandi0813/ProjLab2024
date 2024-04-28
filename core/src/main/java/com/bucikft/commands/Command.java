package com.bucikft.commands;

import com.bucikft.Game;

public interface Command {

    /**
     * Executes the command.
     *
     * @param game The game object.
     * @param args The arguments of the command.
     */
    void execute(Game game, String[] args);
}
