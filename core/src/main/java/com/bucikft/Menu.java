package com.bucikft;

public class Menu {

    private static Game game;

    public static Game getGame() {
        return game;
    }

    public static void main(String[] args) {
        game = new Game();
        System.out.println("welcome to the game!");
        while(!game.isStarted()) {
            try {
                game.getProtoTest().MapLoad("C:\\Users\\Dani\\Desktop\\Projlab\\ProjLab2024\\core\\src\\main\\java\\com\\bucikft\\map.txt");
                System.out.println(game.isStarted());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
