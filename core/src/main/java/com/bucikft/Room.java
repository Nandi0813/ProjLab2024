package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Door.Exit;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a room in the game.
 */
public class Room {

    private static Random rand = new Random();

    private int capacity;
    private int itemCapacity; // Added to track the how many items can be in room
    private boolean gassed;

    // Attributes related to cleaning
    public static final int STICKY_AT = 6;
    private int visitorsSinceLastCleaning;
    private boolean isSticky;

    private final List<Item> itemsList;
    private final List<Door> doorList;
    private final List<Person> personList;

    private final String ID;

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
    }

    public Room getRandomNeighbourRoom() {
        for (Door door : this.getDoorList())
        {
            if (door instanceof Exit) continue;

            Room room = door.getWhereTo(this);
            if (!room.isMaxCapacity())
                return room;
        }
        
        return null;
    }

    /**
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
     * @return Whether the room is at maximum capacity or not
     */
    public boolean isMaxCapacity() {
        return this.getCapacity() < this.getPersonList().size();
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
     * @return The number of visitors since the last cleaning happened by a cleaner.
     */
    public int getVisitorsSinceLastCleaning() { return this.visitorsSinceLastCleaning; }

    /**
     * @param visitorsSinceLastCleaning The number of visitors since the last cleaning.
     */
    public void setVisitorsSinceLastCleaning(int visitorsSinceLastCleaning) { this.visitorsSinceLastCleaning = visitorsSinceLastCleaning; }

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
        return this.ID;
    }

}
