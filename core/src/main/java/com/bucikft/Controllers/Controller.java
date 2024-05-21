package com.bucikft.Controllers;
import com.bucikft.Commands.Command;
import com.bucikft.Door.Door;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Game;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Items.SlipStick;
import com.bucikft.Items.Transistor;
import com.bucikft.Person.Person;
import com.bucikft.Person.Student;
import com.bucikft.Room;
import com.bucikft.Views.EndScreenView;
import com.bucikft.Views.GameView;
import javafx.util.Pair;
import com.bucikft.Commands.Move;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    private static Game game;
    private static final Random random = new Random();

    public Tile[][] getTileList(Tile[][] initial) {
        Room currentRoom = game.getFocusedPerson().getCurrentRoom();
        int roomSize = initial.length;
        List<Pair<Integer,Integer>> unusedTiles= new ArrayList<>();
        List<Object> drawnObjects = new ArrayList<>();
        for (int x=0;x<roomSize;x++) {
            for (int y=0;y<roomSize;y++) {
                Tile tile = initial[x][y];
                switch (tile.getType()) {
                    case Floor:
                        unusedTiles.add(new Pair(x, y));
                        break;
                    case Student:
                    case Professor:
                    case BossProfessor:
                    case Cleaner:
                        if (!currentRoom.getPersonList().contains((Person)tile.getRef())) {
                            initial[x][y] = new Tile(TileType.Floor,null);
                            unusedTiles.add(new Pair(x,y));
                        } else {
                            drawnObjects.add(tile.getRef());
                        }
                        break;
                    case AirFreshener:
                    case DKC:
                    case EnergyDrink:
                    case Hammer:
                    case HolyCup:
                    case Mask:
                    case SlipStick:
                    case Transistor:
                    case TVSZ:
                    case WetRag:
                    case Zyn:
                        if (!currentRoom.getItemList().contains((Item)tile.getRef())) {
                            initial[x][y] = new Tile(TileType.Floor,null);
                            unusedTiles.add(new Pair(x,y));
                        }
                        else {
                            drawnObjects.add(tile.getRef());
                        }
                        break;
                    case Door:
                        if (!currentRoom.getDoorList().contains((Door)tile.getRef()) || ((Door)tile.getRef()).getDisappeared()>0) {
                            initial[x][y] = new Tile(TileType.Wall,null);
                        } else {
                            drawnObjects.add(tile.getRef());
                        }
                        break;
                }

            }
        }

        for (Person person : currentRoom.getPersonList()) {
            if (!drawnObjects.contains(person)) {
                drawnObjects.add(person);
                Pair<Integer,Integer> randomTile = unusedTiles.get(random.nextInt(unusedTiles.size()));
                initial[randomTile.getKey()][randomTile.getValue()] = new Tile(person.getType(),person);
            }
        }
        for (Item item:currentRoom.getItemList()) {
            if (!drawnObjects.contains(item)) {
                drawnObjects.add(item);
                Pair<Integer,Integer> randomTile = unusedTiles.get(random.nextInt(unusedTiles.size()));
                initial[randomTile.getKey()][randomTile.getValue()] = new Tile(item.getType(),item);
            }
        }
        for (Door door: currentRoom.getDoorList()) {
            if (!drawnObjects.contains(door)) {
                if (door.getDisappeared()>0) continue;
                drawnObjects.add(door);
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
                    initial[doorLoc.getKey()][doorLoc.getValue()] = new Tile(TileType.Door,door);
                }
            }
        }
        return initial;
    }
    // converts current room to list of tiles
    public Tile[][] initializeTileList() {
        Room currentRoom = game.getFocusedPerson().getCurrentRoom();
        int maxCap = 10;
        int roomSize = (int)Math.floor(Math.sqrt(maxCap)+3);
        Tile[][] tileList = new Tile[roomSize][roomSize];

        List<Pair<Integer,Integer>> usedTiles = new ArrayList<>();

        for (Door door : currentRoom.getDoorList()) {
            if (door.getDisappeared()>0) continue;
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


    public List<String> getStatusStrings() {
        Person focusedPerson = game.getFocusedPerson();
        Room currentRoom = focusedPerson.getCurrentRoom();

        List<String> status = new ArrayList<>();
        status.add("Current Round "+ game.getRoundManager().getCurrentRound());
        status.add("Current Turn: " + game.getRoundManager().getCurrentTurn());
        status.add("Focused Person: " + game.getFocusedPerson().getName());
        status.add("you are in " + currentRoom);
        status.add("You are " + ((focusedPerson.getStunned()==0)?"not stunned":"stunnded for"+focusedPerson.getStunned()));
        status.add("\nMoves left: " + focusedPerson.getMovesLeft());
        status.add("\nUses left: " + focusedPerson.getUsesLeft());
        status.add("\nThis room is " + (currentRoom.isCursed()?"cursed":"not cursed"));
        if (focusedPerson instanceof Student) {
            status.add("\nYou are " + (((Student) focusedPerson).isAlive()?"alive":"dead"));
        }
        return status;
    }

    public ActionType tileClicked(Tile tile) throws IllegalStateException, NumberFormatException, IllegalArgumentException {
        System.out.println("Clicked tile: " + tile.getType() + " " + tile.getRef());
        switch (tile.getType()) {
            case Door:
                if (!(game.getFocusedPerson() instanceof Student student)) {
                    throw new IllegalStateException("the focused person is not a student.");
                }

                Room room = student.getCurrentRoom();
                Door door = (Door) tile.getRef();
                Room roomTo = (door.getRoomTo() == room ? door.getRoomFrom() : door.getRoomTo());
                    if (roomTo == null) {
                        boolean slipstick = false;
                        for (Item i : student.getItemList()) {
                            if(i instanceof SlipStick) {
                                slipstick = true;
                                break;
                            }
                        }
                        if (slipstick){
                            EndScreenView endScreenView = new EndScreenView();
                        }
                        throw new IllegalStateException("you don't have a slipstick, you can't leave the room.");
                    }
                    student.move(roomTo, false);
                    System.out.println("Student#" + student.getName() + " moved to " + student.getCurrentRoom() + ".");
                return ActionType.Move;
            case AirFreshener:
            case DKC:
            case EnergyDrink:
            case Hammer:
            case HolyCup:
            case Mask:
            case SlipStick:
            case Transistor:
            case TVSZ:
            case WetRag:
            case Zyn:
                Person person = game.getFocusedPerson();
                Item item = (Item)tile.getRef(); // pickup Name like pickup AirFreshener

                if (item == null) {
                    throw new IllegalStateException("Item not found.");
                }
                person.pickUp(item);
                if(item instanceof com.bucikft.Items.Transistor){
                    ((Transistor) item).setPickedUp(true);
                }
                System.out.println("Item " + item + " picked up by Student#" + person.getName() + ".");
                return ActionType.PickUp;
        }
        return ActionType.None;
    }

    public void setGodMode() {
        game.getFocusedPerson().setGodMode(!game.getFocusedPerson().isGodMode());
        System.out.println("godmode " + (game.getFocusedPerson().isGodMode()?"ON":"OFF"));
    }

    public String inventoryButtonClicked(int idx, boolean use) throws IndexOutOfBoundsException, IllegalStateException {
        Person person = game.getFocusedPerson();
        if (person instanceof Student student) {
            Item item;
            try {item = student.getInventory().get(idx);}
            catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("no item at that slot!");
            }
            String name = item.getType().name() + ".png";
            if (!use) {
                student.drop(item);
                System.out.println("Item " + item + " dropped by student " + student + ".");
            }
            else {
                student.use(item);
                System.out.println("Item " + item + " used by Student#" + student.getName());
            }
            return name;
        }
        return "Floor.png";
    }

    public void nextButtonPressed() {
        game.getRoundManager().nextTurn();
    }

    public void saveGame(File file) throws IOException {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game);
    }

    public void loadGame(File file) throws IOException, ClassNotFoundException {
        game = null;
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            game = (Game) in.readObject();
    }


    public static Game getGame() {
        return game;
    }

    public List<String> getInventoryTextures() {
        Person focusedPerson = game.getFocusedPerson();
        List<String> textures = new ArrayList<>();
        for (Item item: focusedPerson.getInventory()) {
            textures.add(item.getType().name()+".png");
        }
        if (textures.size()<5) {
            for (int i = textures.size()-1;i<5; i++) {
                textures.add("Floor.png");
            }
        }
        return textures;
    }
}
