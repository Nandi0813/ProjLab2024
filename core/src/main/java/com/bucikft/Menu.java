package com.bucikft;

public class Menu {

    private static Game game;

    public static void main(String[] args) {
        game = new Game();

        System.out.println("Welcome to the game!");

        while (!game.isStarted()) {
            try {
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Game getGame() {
        return game;
    }

}