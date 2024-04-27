package com.bucikft.commands;

import com.bucikft.Game;

public class ExitCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
        game.endGame();
        game.getProtoTest().protoTestbool = false;
        System.out.println("exiting...");
        System.exit(0);
    }
}
