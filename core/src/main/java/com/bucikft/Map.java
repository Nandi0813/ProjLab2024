package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Items.*;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Cleaner;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the game map.
 */
public class Map {

    private List<Room> roomList;
    private List<Item> itemList;

    private static <T> List<Item> generateItem(Class<T> itemClass, int mapSize, IDmaker idMaker) {
        int itemCount = (int)( Math.random() * (mapSize/3)+1);
        List<Item> items = new ArrayList<>();
        try {
            // Get the constructor of the specified class with the appropriate parameter types

            Constructor<T> constructor = itemClass.getDeclaredConstructor(String.class, boolean.class);
            boolean falseItem = false;
            if (itemClass.equals(TVSZ.class) || itemClass.equals(SlipStick.class) || itemClass.equals(Mask.class)) {
                if (itemCount>1) {
                    falseItem = true;
                }
            }
            if (itemClass.equals(Transistor.class)) itemCount*=2;
            for (int i = 0; i < itemCount; i++) {
                // Create a new instance of the specified class using the constructor and provided arguments
                T newItem = constructor.newInstance(idMaker.makeID(), i == 0 && falseItem);
                // You can initialize any properties or perform additional setup here
                items.add((Item)newItem);
            }
            return items;

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(e.getMessage());// Handle the exception appropriately
            return null; // Or some default value indicating failure
        }

    }
    private Room findRoom(int x, int y) {
        for (Room room : roomList) {
            if (room.getX() == x && room.getY() == y) {
                return room;
            }
        }
        return null;
    }

    private static void generateDoor(Room roomFrom, Room roomTo, DoorLocation location) {
        Door door = new Door(roomFrom, roomTo, location);
        roomFrom.getDoorList().add(door);
        roomTo.getDoorList().add(door);
    }

    /**
     * Initializes a new map.
     */
    public Map(int mapSize, List<Student> students, List<Professor> professors, List<Cleaner> cleaners, IDmaker idMaker){
        this.roomList = new ArrayList<>();
        this.itemList = new ArrayList<>();
        // xxxxxxxxxxx

        // generate doors between rooms
        for (int x=1; x<=mapSize; x++) {
            for (int y=1; y<=mapSize; y++) {
                Room room = new Room(x,y);
                roomList.add(room);
            }
        }

        // generate doors between rooms
        for (Room room : roomList) {
            int x = room.getX();
            int y = room.getY();
            if (x==1) {
                if (y!=mapSize) {
                    generateDoor(room, findRoom(x,y+1), DoorLocation.BOTTOM);
                }
                if (y!=1) generateDoor(room, findRoom(x+1,y), DoorLocation.RIGHT);
            }
            if (y==1) {
                if (x!=mapSize) {
                    generateDoor(room, findRoom(x+1,y), DoorLocation.RIGHT);
                }
                if (x!=1) {
                    generateDoor(room, findRoom(x,y+1), DoorLocation.BOTTOM);
                }
            }
            if (x>1 && y>1) {
                if (x!=mapSize) {
                    generateDoor(room, findRoom(x+1,y), DoorLocation.RIGHT);
                }
                if (y!=mapSize) {
                    generateDoor(room, findRoom(x,y+1), DoorLocation.BOTTOM);
                }
            }

        }
        List<Class<?>> itemClasses = new ArrayList<>(Arrays.asList(AirFreshener.class,DKC.class, Mask.class, SlipStick.class, TVSZ.class, EnergyDrink.class, Hammer.class, HolyCup.class, WetRag.class, Zyn.class, Transistor.class));
        // generate items and put them in rooms
        for (Class<?> itemClass : itemClasses) {
            List<Item> items = generateItem(itemClass, mapSize, idMaker);
            itemList.addAll(items);
            for (Item item : items) {
                // todo test for capacity of room
                int randomRoomIndex = (int) (Math.random() * roomList.size());
                Room randomRoom = roomList.get(randomRoomIndex);
                randomRoom.getItemsList().add(item);
            }
        }



        // put students in rooms
        for (Student student : students) {
            int randomRoomIndex = (int) (Math.random() * roomList.size());
            Room randomRoom = roomList.get(randomRoomIndex);
            randomRoom.getPersonList().add(student);
            student.setCurrentRoom(randomRoom);
        }
        // put professors in rooms
        for (Professor professor : professors) {
            int randomRoomIndex = (int) (Math.random() * roomList.size());
            Room randomRoom = roomList.get(randomRoomIndex);
            randomRoom.getPersonList().add(professor);
        }
        // put cleaners in rooms
        for (Cleaner cleaner : cleaners) {
            int randomRoomIndex = (int) (Math.random() * roomList.size());
            Room randomRoom = roomList.get(randomRoomIndex);
            randomRoom.getPersonList().add(cleaner);
        }
    }

    /**
     * Splits a room into two rooms.
     *
     * @param room The room to split.
     */
    public void split(Room room) {

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
