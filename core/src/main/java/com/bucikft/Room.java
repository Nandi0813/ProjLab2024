package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Door.Exit;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a room in the game.
 */
public class Room {

    private int capacity; // Added to track the capacity of the room
    private int itemCapacity; // Added to track the how many items can be in room
    private boolean gassed; // Added to track if the room is gassed

    // Attributes related to cleaning
    public static final int STICKY_AT = 6;
    private int visitorsSinceLastCleaning;
    private boolean isSticky;

    private final List<Item> itemList; // Added to track the items in the room
    private final List<Door> doorList; // Added to track the doors in the room
    private final List<Person> personList; // Added to track the persons in the room

    private final String ID; // Added to track the ID of the room

    /**
     * Initializes a new room.
     */
    public Room(int x) {
        this.gassed = false;
        this.isSticky = false;
        this.itemList = new ArrayList<>();
        this.doorList = new ArrayList<>();
        this.personList = new ArrayList<>();
        this.capacity = 5;
        this.itemCapacity = 6;
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

    public boolean isNeighbour(Room room) {
        for (Door door : this.getDoorList())
            if (room == door.getRoomTo() || room == door.getRoomFrom())
                return true;
        return false;
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
    public List<Item> getItemList() {
        return this.itemList;
    }

    /**
     * Gets the item with the specified ID.
     * @param id The ID of the item to get.
     * @return The item with the specified ID.
     */
    public Item getItem(String id) {
        for (Item item : this.itemList)
            if (item.getID().equals(id))
                return item;
        return null;
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

    /**
     * Retrieves the capacity of the room.
     * @return The capacity of the room.
     */
    public int getItemCapacity() {
        return this.itemCapacity;
    }

    /**
     * Retrieves the ID of the room.
     * @return The ID of the room.
     */
    public String getID() {
        return this.ID;
    }

    /**
     * Sets the item capacity of the room.
     * @param i The item capacity to set.
     */
    public void setItemCapacity(int i) {
        this.itemCapacity = i;
    }

    @Override
    public String toString() {
        return this.ID;
    }

}
