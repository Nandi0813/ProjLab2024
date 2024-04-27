package com.bucikft.commands;

import com.bucikft.Game;

public class Load implements Command{
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 2) {
            System.out.println("invalid arguments");
            return;
        }
        try {
            game.getProtoTest().MapLoad(args[1], true, null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
