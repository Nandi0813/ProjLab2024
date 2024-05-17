package com.bucikft.Controllers;
import com.bucikft.Door.Door;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Game;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;
import com.bucikft.Room;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    private Game game;
    private static final Random random = new Random();

    // converts current room to list of tiles
    public Tile[][] getTileList() {
        Room currentRoom = game.getFocusedPerson().getCurrentRoom();
        int maxCap = currentRoom.getItemCapacity() + currentRoom.getPersonCapacity();
        int roomSize = (int)Math.floor(Math.sqrt(maxCap)+3);
        System.out.println("Roomsize: "+roomSize);
        Tile[][] tileList = new Tile[roomSize][roomSize];
        List<Pair<Integer,Integer>> usedTiles = new ArrayList<>();

        System.out.println("list size: " + currentRoom.getDoorList().size());

        for (Door door : currentRoom.getDoorList()) {
            Pair<Integer, Integer> doorLoc = null;
            DoorLocation loc = (door.getRoomFrom()==currentRoom)?door.getLocationFrom():door.getLocationTo();

            switch (loc) {
                case TOP:
                    doorLoc = new Pair<>(roomSize/2, 0);
                    break;
                case RIGHT:
                    doorLoc = new Pair<>(roomSize-1, roomSize/2);
                    break;
                case BOTTOM:
                    doorLoc = new Pair<>(roomSize/2, roomSize-1);
                    break;
                case LEFT:
                    doorLoc = new Pair<>(0, roomSize/2);
                    break;
            }

            if (doorLoc != null) {
                tileList[doorLoc.getKey()][doorLoc.getValue()] = new Tile(TileType.Door,door);
                usedTiles.add(doorLoc);
            }
        }

        // walls
        for (int x= 0; x < roomSize; x++) {
            for(int y = 0; y < roomSize; y++) {
                if ((x == 0 || y==0) || (x==roomSize-1 || y==roomSize-1))  {
                    Pair<Integer, Integer> wallLoc = new Pair<>(x,y);
                    if (!usedTiles.contains(wallLoc)) {
                        tileList[x][y] = new Tile(TileType.Wall, null);
                        usedTiles.add(wallLoc);
                    }
                }
            }
        }


        for (Person person : currentRoom.getPersonList())
        {
            Pair<Integer, Integer> randomTile = getUnusedTile(roomSize, usedTiles);
            usedTiles.add(randomTile);

            tileList[randomTile.getKey()][randomTile.getValue()] = new Tile(person.getType(),person);
        }

        for (Item item : currentRoom.getItemList())
        {
            Pair<Integer, Integer> randomTile = getUnusedTile(roomSize, usedTiles);
            usedTiles.add(randomTile);

            tileList[randomTile.getKey()][randomTile.getValue()] = new Tile(item.getType(),item);
        }

        for (int x=0; x < roomSize; x++) {
            for (int y = 0; y < roomSize; y++) {
                Pair<Integer, Integer> coords = new Pair(x,y);
                if (!usedTiles.contains(coords)) {
                    tileList[x][y] = new Tile(TileType.Floor,null);
                }
            }
        }

        return tileList;
    }

    private static Pair<Integer, Integer> getUnusedTile(final int roomSize, final List<Pair<Integer,Integer>> usedTiles) {
        Pair<Integer, Integer> randomTile;

        do {
            randomTile = new Pair<>(random.nextInt(roomSize - 2) + 1, random.nextInt(roomSize - 2) + 1);
        } while (usedTiles.contains(randomTile));

        return randomTile;
    }

    public void newGameStart(int playerCount, int mapSize) {
        game = new Game();
        game.startGame(playerCount,mapSize);
    }



}
