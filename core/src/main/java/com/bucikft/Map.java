package com.bucikft;

import com.bucikft.Items.Interface.Item;

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
    public Map(){
        this.roomList = new ArrayList<>();
        this.itemList = new ArrayList<>();
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
