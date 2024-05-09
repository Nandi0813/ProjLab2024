
package com.bucikft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProtoTest {

    private boolean protoTest; // Added to keep track of the proto test state
    private boolean testMode = false; // Added to keep track of the test mode
    
    String filePath; // Added to keep track of the file path

    private final Game game; // Added to keep track of the game

    /**
     * Constructor to initialize a ProtoTest object.
     * @param game The game object to store.
     */
    public ProtoTest(Game game) {
        this.game = game;
        this.protoTest = true;
    }

    /**
     * The main loop of the proto test.
     */
    public void mainLoop() {
        while (protoTest){
            try {
                game.getUI().readCommands();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Loads the map from the specified file path.
     * @param filePath The file path to load the map from.
     * @param testmode The test mode to set.
     * @param in The input to set.
     */
    public void MapLoad(String filePath, boolean testmode, String in){
        this.testMode = testmode;
        if (testmode){
            this.filePath = in;
        }
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

    /**
     * Gets the test mode of the proto test.
     * @return The test mode of the proto test.
     */
    public boolean isTestMode(){
        return this.testMode;
    }

    /**
     * Gets the file path of the proto test.
     * @return The file path of the proto test.
     */
    public String getFilePath(){
        return this.filePath;
    }

    /**
     * Sets the file path of the proto test.
     * @param filePath The file path to set.
     */
    public void setFilepath(String filePath){
        this.filePath = filePath;
    }

    /**
     * Sets the test mode of the proto test.
     * @param b The test mode to set.
     */
    public void setProtoTest(boolean b){
        this.protoTest = b;
    }

}
