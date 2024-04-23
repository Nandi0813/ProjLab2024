package com.bucikft;

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

    /**
     * Initializes a new map.
     */
    public Map(int mapSize, List<Student> students, List<Professor> professors, List<Cleaner> cleaners){
        this.roomList = new ArrayList<>();
        this.itemList = new ArrayList<>();
        // generate rooms
        for (int i = 0; i < mapSize; i++) {
            Room room = new Room();
            roomList.add(room);
        }
        // generate doors between rooms

        // TODO I HAVE NO IDEA HOW WE'RE GONNA DO THE GENERATION OF THE MAP XDDD


        // generate items and put them in rooms


        // put students in rooms
        for (Student student : students) {
            int randomRoomIndex = (int) (Math.random() * roomList.size());
            Room randomRoom = roomList.get(randomRoomIndex);
            randomRoom.getPersonList().add(student);
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
