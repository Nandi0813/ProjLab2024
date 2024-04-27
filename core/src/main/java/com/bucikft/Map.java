package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Door.Exit;
import com.bucikft.Items.*;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Cleaner;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;
import com.bucikft.commands.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Represents the game map.
 */
public class Map {

    private List<Room> roomList;
    private List<Item> itemList;
    private HashMap<String, Item> items = new HashMap<>();


    public Map(int mapSize, List<Student> students, List<Professor> professors, List<Cleaner> cleaners, IDmaker idMaker){
        items.put("AirFreshener", new AirFreshener(idMaker.makeID(), false));
        items.put("DKC", new DKC(idMaker.makeID(), false));
        items.put("EnergyDrink", new EnergyDrink(idMaker.makeID(), false));
        items.put("HolyCup", new HolyCup(idMaker.makeID(), false));
        items.put("Hammer", new Hammer(idMaker.makeID(), false));
        items.put("SlipStick", new SlipStick(idMaker.makeID(), false));
        items.put("Transistor", new Transistor(idMaker.makeID(), false));
        items.put("TVSZ", new TVSZ(idMaker.makeID(), false));
        items.put("WetRag", new WetRag(idMaker.makeID(), false));
        items.put("Zyn", new Zyn(idMaker.makeID(), false));
        items.put("Mask", new Mask(idMaker.makeID(), false));

        this.roomList = new ArrayList<>();
        this.itemList = new ArrayList<>();


        // generate doors between rooms
        for (int x=0; x<mapSize; x++) {
            Room room = new Room(x);
            roomList.add(room);
        }
    }

    public void generateDoors(String[] doorLocations){
        for (String doorLocation : doorLocations) {
            if(doorLocation.contains("-")) {
                String[] parts = doorLocation.split("-");
                int room1 = Integer.parseInt(parts[0]);
                int room2 = Integer.parseInt(parts[1]);
                Door door = new Door(roomList.get(room1-1), roomList.get(room2-1));
                roomList.get(room1-1).getDoorList().add(door);
                roomList.get(room2-1).getDoorList().add(door);
            }
            else{
                doorLocation = doorLocation.replace("E", "");
                int room = Integer.parseInt(doorLocation);
                Door door = new Exit(roomList.get(room-1), null);
                roomList.get(room-1).getDoorList().add(door);
            }
        }
    }

    public void generateItems(String itemsToGenerate){
        String[] parts = itemsToGenerate.split("\\s+");
        int roomNumber = -1;
        for (String part : parts) {
            part = part.replace(",", "").replace(":", "");
            if (part.matches("\\d+")) {
                roomNumber = Integer.parseInt(part);
            } else {
                Item itemToGenerate = this.items.get(part.trim());
                roomList.get(roomNumber-1).getItemsList().add(itemToGenerate);
                itemList.add(itemToGenerate);
            }
        }
    }


    /**
     * Splits a room into two rooms.
     *
     * @param room The room to split.
     */
    public void split(Room room) {
        Room newRoom = new Room(roomList.size());
        newRoom.setGassed(room.isGassed());
        newRoom.setSticky(room.isSticky());

        int halfCapacity = room.getCapacity()/2;
        room.setCapacity(room.getCapacity()-halfCapacity);
        newRoom.setCapacity(halfCapacity);

        int halfItemCapacity = room.getItemCapacity()/2;
        room.setItemCapacity(room.getItemCapacity()-halfItemCapacity);
        newRoom.setItemCapacity(halfItemCapacity);

        if(room.getItemsList().size() > halfItemCapacity ){
            for(int i = halfItemCapacity; i < room.getItemsList().size(); i++){
                newRoom.getItemsList().add(room.getItemsList().remove(i));
            }
        }

        for (Person p : room.getPersonList()) {

        }

        for (Door d : room.getDoorList()) {

        }
    }

    /**
     * Finds a path in the map.
     *
     * @return The list of rooms representing the path.
     */
    public List<Room> pathFinding(){
        return roomList; // Temporary return value
    }

    /**
     * Retrieves the list of rooms in the map.
     *
     * @return The list of rooms.
     */
    public List<Room> getRoomList() { return this.roomList; }

    /**
     * Retrieves the list of items in the map.
     *
     * @return The list of items.
     */
    public List<Item> getItemList() { return this.itemList; }
}
