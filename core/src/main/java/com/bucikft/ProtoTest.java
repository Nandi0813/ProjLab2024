
package com.bucikft;

import com.bucikft.commands.*;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ProtoTest {

    public boolean protoTestbool = false;

    private Game game;
    public ProtoTest(Game game){
        this.game = game;
        this.protoTestbool = true;
        ConsoleUI cui = new ConsoleUI(game);

    }

    public void mainLoop() {
        while (protoTestbool){
            try {
                game.getUI().readCommands();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void MapLoad(String filePath){
        try {
            // Create a FileReader object
            FileReader fileReader = new FileReader(filePath);

            // Wrap FileReader in BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read the file line by line
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if(i ==0){
                    String [] parts = line.split(" ");
                    game.generateRooms(Integer.parseInt(parts[0]));
                    game.generateStudents(Integer.parseInt(parts[1]));
                    game.generateProfessors(Integer.parseInt(parts[2]));
                    game.generateCleaners(Integer.parseInt(parts[3]));
                }
                else if(i == 1){
                    String [] parts = line.split(" ");
                    game.generateDoors(parts);
                }
                else if (i == 2){
                    game.generateItems(line);
                }
                else if (i == 3){
                    game.placePeople(line);
                }
                i++;
            }

            // Close the BufferedReader
            bufferedReader.close();
            game.setIsStarted(true);
            game.startGame();
            mainLoop();
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }
}
