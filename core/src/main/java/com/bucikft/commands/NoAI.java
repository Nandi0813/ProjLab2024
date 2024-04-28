package com.bucikft.commands;

import com.bucikft.Game;

public class NoAI implements Command {
    @Override
    public void execute(Game game, String[] args) {
        game.setNoAi(!game.getNoAi());

        System.out.println("ai turned " + (game.getNoAi() ? "ON" : "OFF"));
    }
}
