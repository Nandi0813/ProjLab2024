package com.bucikft.commands;

import com.bucikft.Game;

public class Debug implements Command {

    @Override
    public void execute(Game game, String[] args) {
        game.setDebugMode();
        System.out.println("debug mode " + (game.getDebugMode() ? "ON" : "OFF"));
    }
}
