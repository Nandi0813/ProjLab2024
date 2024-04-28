package com.bucikft.commands;

import com.bucikft.Game;

public class Skip implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (!game.getDebugMode()) throw new IllegalArgumentException("debug mode not ON");
        game.getRoundManager().nextRound();
        System.out.println("round skipped, now playing: Student#" + game.getFocusedPerson().getName());
    }
}
