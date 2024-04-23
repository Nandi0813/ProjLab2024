package com.bucikft;

import com.bucikft.commands.Command;
import com.bucikft.commands.Debug;
import com.bucikft.commands.Start;

import java.util.Scanner;
import java.util.HashMap;

public class Menu {

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("welcome to the game!");
        while(!game.isStarted()) {
            game.getUI().readCommands();
        }




    }
}
