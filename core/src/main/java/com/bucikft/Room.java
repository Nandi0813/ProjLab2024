package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Items.Item;
import com.bucikft.Person.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a room in the game.
 */
public class Room {

    private int capacity;
    private boolean gassed = false;
    private List<Item> itemsList;
    private List<Door> doorList;
    private List<Person> personList;

    /**
     * Initializes a new room.
     */
    public Room() {
        this.itemsList = new ArrayList<>();
        this.doorList = new ArrayList<>();
        this.personList = new ArrayList<>();
    }

    /**
     * Removes and returns an item from the specified coordinates in the room.
     *
     * @param x The x-coordinate of the item.
     * @param y The y-coordinate of the item.
     * @return The removed item.
     */
    public Item popItem(int x, int y) {
        return null;
    }

    /**
     * Retrieves the neighbor room of the specified coordinates in the room.
     *
     * @param x The x-coordinate of the neighbor.
     * @param y The y-coordinate of the neighbor.
     * @return The neighbor room.
     */
    public Room getNeighbor(int x, int y) {
        return null;
    }

    /**
     * Retrieves the capacity of the room.
     *
     * @return The capacity of the room.
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Sets the capacity of the room.
     *
     * @param capacity The capacity to set.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Checks if the room is gassed.
     *
     * @return True if the room is gassed, false otherwise.
     */
    public boolean isGassed() {
        return this.gassed;
    }

    /**
     * Sets the gassed status of the room.
     *
     * @param gassed The gassed status to set.
     */
    public void setIsGassed(boolean gassed) {
        this.gassed = gassed;
    }

    /**
     * Retrieves the list of items in the room.
     *
     * @return The list of items.
     */
    public List<Item> getItemsList() {
        return this.itemsList;
    }

    /**
     * Retrieves the list of doors in the room.
     *
     * @return The list of doors.
     */
    public List<Door> getDoorList() {
        return this.doorList;
    }

    /**
     * Retrieves the list of persons in the room.
     *
     * @return The list of persons.
     */
    public List<Person> getPersonList() {
        return this.personList;
    }

}
