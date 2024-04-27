package com.bucikft;

public class Menu {

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("welcome to the game!");
        while(!game.isStarted()) {
            try {
                game.getProtoTest().MapLoad("/Users/gaszneradam/Documents/BME/3. félév/Szoftvertechnológia/ProjLab2024/core/src/main/java/com/bucikft/map.txt");
                System.out.println(game.isStarted());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }




    }
}
