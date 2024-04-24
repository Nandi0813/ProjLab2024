package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Cleaner;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the game map.
 */
public class Map {

    private List<Room> roomList;
    private List<Item> itemList;

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
        // x x x x
        // x x x x
        // x x x x
        // x x x x

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

        // generate items and put them in rooms


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
