package com.bucikft.commands;

import com.bucikft.Game;

public class MenuCommand implements Command {
    @Override
    public void execute(Game game, String[] args){
        game.endGame();
        System.out.println("quit to main menu");
    }
}
