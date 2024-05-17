package com.bucikft.Commands;

import com.bucikft.Game;

public class MenuCommand implements Command {

    /**
     * The execute method of the MenuCommand class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args){
        game.endGame();
        System.out.println("Quit to main menu.");
    }

}
