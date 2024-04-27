package com.bucikft.Person;

import com.bucikft.Door.Door;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents an abstract Person in the game.
 */
public abstract class Person {

    protected String name;
    protected int movesLeft;
    protected int usesLeft; // Added so we can track moves and uses separately
    protected List<Item> itemList;
    protected Room currentRoom;
    protected int capacity; // Added to track the capacity of the inventory
    protected boolean godMode = false;

    public void setGodMode(boolean godMode) {
        this.godMode = godMode;
    }
    public boolean isGodMode() {
        return this.godMode;
    }

    /**
     * Constructor to initialize a Person object.
     */
    protected Person(String name) {
        this.itemList = new ArrayList<>();
        this.name = name;
        this.movesLeft = 1;
        this.usesLeft = 1;
        this.capacity = 5;
    }

    /**
     * Moves the person to the specified room.
     *
     * @param room The room to move to.
     * @throws IllegalStateException If the player has no moves left or if the rooms are not neighbors.
     */
    public void move(Room room) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);

        // Test if the player has moves left
        if (!godMode && this.movesLeft <= 0) {
            throw new IllegalStateException("The player has no more moves left.");
        }

        // Test if the rooms are neighbors
        boolean neighbor = false;
        for (Door door : this.currentRoom.getDoorList()) {
            if (room.getDoorList().contains(door)) {
                neighbor = true;
                break;
            }
        }
        if (!neighbor) {
            throw new IllegalStateException("The rooms are not neighbors.");
        }

        // Move the person to the room
        this.currentRoom.getPersonList().remove(this);
        room.getPersonList().add(this);
        this.currentRoom = room;

        // Decrement movesLeft
        if (!godMode) movesLeft--;
    }

    public int getUsesLeft() {
        return this.usesLeft;
    }

    /**
     * Picks up the specified item.
     *
     * @param item The item to pick up.
     * @throws IllegalStateException If the player has no moves left, if the item is not in the same room, or if the inventory is full.
     */
    public void pickUp(Item item) throws IllegalStateException {
        // removed uses left test because they should be able to pick up as many items as they want

        // Test if the item is in the same room
        if (!this.currentRoom.getItemsList().contains(item)) {
            throw new IllegalStateException("The item is not in the same room.");
        }

        // Test if the inventory is full
        if (this.itemList.size() >= this.capacity) {
            throw new IllegalStateException("The player's inventory is full.");
        }

        // Pick up the item
        this.currentRoom.getItemsList().remove(item);
        this.itemList.add(item);

        // Set item to picked up
        item.setPickedUp(true);

        // Decrement usesLeft
        //this.usesLeft--;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the current room of the person.
     *
     * @return The current room of the person.
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public List<Item> getInventory() {
        return this.itemList;
    }

    /**
     * Sets the current room of the person.
     *
     * @param currentRoom The room to set as the current room.
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Gets the number of moves left for the person.
     *
     * @return The number of moves left.
     */
    public int getMovesLeft() {
        return this.movesLeft;
    }

    /**
     * Sets the number of moves left for the person.
     *
     * @param movesLeft The number of moves left to set.
     */
    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }

    public void setUsesLeft(int i) {
        this.usesLeft = i;
    }

    public List<Item> getItemList() {
        return this.itemList;
    }
}
