package com.bucikft.commands;

import com.bucikft.Game;

public class Next implements Command {
    @Override
    public void execute(Game game, String[] args) {
        System.out.println("turn ended");
        game.getRoundManager().nextTurn();

    }
}
