package com.bucikft;

import com.bucikft.commands.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ProtoTest {

    private Game game;
    private HashMap<String, Command> commands = new HashMap<String, Command>();
    public ProtoTest(Game game){
        this.game = game;
        commands.put("debug", new Debug());
        commands.put("start", new Start());
        commands.put("exit", new ExitCommand());
        commands.put("next", new Next());
        commands.put("skip", new Skip());
        commands.put("pickup", new PickUp());
        commands.put("spawn", new Spawn());
        commands.put("drop", new Drop());
        commands.put("menu", new MenuCommand());
        commands.put("use", new Use());
        //commands.put("move", new Move());
        commands.put("godmode", new Godmode());
    }



    public void MapGenerate(String filePath){
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
                    String [] parts = line.split(" ");
                    game.placePeople(parts);
                }
                System.out.println(line);
                i++;
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }
}
