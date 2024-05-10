package com.bucikft;

import com.bucikft.Commands.Command;
import com.bucikft.Commands.Debug;
import com.bucikft.Commands.Start;

import java.util.Scanner;
import java.util.HashMap;

public class Menu {

    private static Game game;
    public static void main(String[] args) {
        game = new Game();
        System.out.println("welcome to the game!");
        while(!game.isStarted()) {
            try {
                game.getUI().readCommands();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Game getGame() {
        return game;
    }
}