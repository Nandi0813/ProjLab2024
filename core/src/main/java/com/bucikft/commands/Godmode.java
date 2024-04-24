package com.bucikft.commands;

import com.bucikft.Game;

public class Godmode implements Command{
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 1) throw new IllegalArgumentException("invalid number of arguments");
        game.getFocusedPerson().setGodMode(!game.getFocusedPerson().isGodMode());
        System.out.println("godmode "+ (game.getFocusedPerson().isGodMode()? "ON" : "OFF"));
    }
}
