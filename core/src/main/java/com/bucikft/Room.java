package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a room in the game.
 */
public class Room {

    private int capacity;
    private int itemCapacity; // Added to track the how many items can be in room
    private boolean gassed;
    private boolean isSticky;
    private List<Item> itemsList;
    private List<Door> doorList;
    private List<Person> personList;

    private String ID;
    private final int x;

    public int getX() {
        return this.x;
    }


    /**
     * Initializes a new room.
     */
    public Room(int x) {
        this.gassed = false;
        this.isSticky = false;
        this.itemsList = new ArrayList<>();
        this.doorList = new ArrayList<>();
        this.personList = new ArrayList<>();
        this.capacity = 5;
        this.itemCapacity = 5;
        this.ID = "Room#"+x;
        this.x = x;

    }

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
    public void setGassed(boolean gassed) {
        this.gassed = gassed;
    }

    /**
     * Checks if the room is sticky.
     * @return True if the room is sticky, false otherwise.
     */
    public boolean isSticky() {
        return this.isSticky;
    }

    /**
     * Sets the sticky status of the room.
     */
    public void setSticky(boolean sticky) {
        this.isSticky = sticky;
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

    public int getItemCapacity() {
        return this.itemCapacity;
    }
    public String getID() {
        return this.ID;
    }

    public void setItemCapacity(int i) {
        this.itemCapacity = i;
    }
    @Override
    public String toString() {
        return "Room#"+this.ID;
    }

}
