package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Door.Exit;
import com.bucikft.Items.*;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;

import java.util.*;

/**
 * Represents the game map.
 */
public class Map {

    private final List<Room> roomList; // List of rooms in the map
    private final List<Item> itemList; // List of items in the map




    /**
     * Constructor to initialize a Map object.
     * @param mapSize The size of the map.
     */
    public Map(int mapSize) {
        this.roomList = new ArrayList<>();
        this.itemList = new ArrayList<>();

        // generate doors between rooms
        for (int x=0; x<mapSize; x++) {
            Room room = new Room(x);
            roomList.add(room);
        }
    }

    /**
     * Generate the doors by a given string array
     *
     * @param doorLocations string array from config file
     */
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

    /**
     * Generate the items by a given string.
     *
     * @param itemsToGenerate string from the config file
     */
    public void generateItems(String itemsToGenerate){
        IDmaker idMaker = Menu.getGame().getIdMaker();
        String[] parts = itemsToGenerate.split("\\s+");
        int roomNumber = -1;
        for (String part : parts) {
            part = part.replace(",", "").replace(":", "");
            if (part.matches("\\d+")) {
                roomNumber = Integer.parseInt(part);
            } else {
                Item itemToGenerate = null;
                switch (part.trim()){
                    case "AirFreshener":
                        itemToGenerate = new AirFreshener(idMaker.makeID(), false);
                        break;
                    case "DKC":
                        itemToGenerate = new DKC(idMaker.makeID(), false);
                        break;
                    case "EnergyDrink":
                        itemToGenerate = new EnergyDrink(idMaker.makeID(), false);
                        break;
                    case "HolyCup":
                        itemToGenerate = new HolyCup(idMaker.makeID(), false);
                        break;
                    case "Hammer":
                        itemToGenerate = new Hammer(idMaker.makeID(), false);
                        break;
                    case "SlipStick":
                        itemToGenerate = new SlipStick(idMaker.makeID(), false);
                        break;
                    case "Transistor":
                        itemToGenerate = new Transistor(idMaker.makeID(), false);
                        break;
                    case "TVSZ":
                        itemToGenerate = new TVSZ(idMaker.makeID(), false);
                        break;
                    case "WetRag":
                        itemToGenerate = new WetRag(idMaker.makeID(), false);
                        break;
                    case "Zyn":
                        itemToGenerate = new Zyn(idMaker.makeID(), false);
                        break;
                    case "Mask":
                        itemToGenerate = new Mask(idMaker.makeID(), false);
                        break;
                    default:
                }

                roomList.get(roomNumber-1).getItemList().add(itemToGenerate);
                itemList.add(itemToGenerate);
            }
        }
    }

    /**
     * Moves the person to a certain room.
     *
     * @param person The person who moves.
     * @param roomTo The room where he moves to.
     */
    public void move(Person person, Room roomTo)
    {
        if (roomTo == null)
            throw new IllegalStateException("No roomTo parameter.");

        person.setCurrentRoom(roomTo);

        Room currentRoom = person.getCurrentRoom();
        currentRoom.getPersonList().remove(person);

        roomTo.getPersonList().add(person);

        if (!person.isGodMode() && person.getMovesLeft() <= 1 )
            person.setMovesLeft(person.getMovesLeft() - 1);

        roomTo.setVisitorsSinceLastCleaning(roomTo.getVisitorsSinceLastCleaning() + 1);
        if (roomTo.getVisitorsSinceLastCleaning() >= Room.STICKY_AT)
            roomTo.setSticky(true);
    }

    /**
     * Splits a room into two rooms.
     *
     * @param room The room to split.
     */
    public void split(Room room) {
        Room newRoom = new Room(roomList.size());
        roomList.add(newRoom);
        newRoom.setGassed(room.isGassed());
        newRoom.setSticky(room.isSticky());

        int halfCapacity = room.getCapacity()/2;
        room.setCapacity(room.getCapacity()-halfCapacity);
        newRoom.setCapacity(halfCapacity);

        int halfItemCapacity = room.getItemCapacity()/2;
        room.setItemCapacity(room.getItemCapacity()-halfItemCapacity);
        newRoom.setItemCapacity(halfItemCapacity);

        if (room.getItemList().size() > halfItemCapacity ){
            for(int i = halfItemCapacity; i < room.getItemList().size(); i++){
                newRoom.getItemList().add(room.getItemList().remove(i));
            }
        }

        Random rand = new Random();
        for (Person p : new ArrayList<>(room.getPersonList())) {
            if (rand.nextInt(2) % 2 == 0 && newRoom.getPersonList().size() <= newRoom.getCapacity()) {
                newRoom.getPersonList().add(p);
            } else {
                room.getPersonList().add(p);
            }
        }

        Door newDoor = new Door(room, newRoom);
        room.getDoorList().add(newDoor);
        newRoom.getDoorList().add(newDoor);
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
     * Retrieves a room by its ID.
     * @param id The ID of the room.
     * @return The room with the given ID.
     */
    public Room getRoom(String id) {
        for (Room room : roomList)
            if (room.getID().equals(id))
                return room;
        return null;

    }

    /**
     * Retrieves the list of items in the map.
     *
     * @return The list of items.
     */
    public List<Item> getItemList() { return this.itemList; }
}
