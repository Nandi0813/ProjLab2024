package com.bucikft.Person;

import com.bucikft.Door.Door;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Menu;
import com.bucikft.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an abstract Person in the game.
 */
public abstract class Person {

    protected String name; // Added to track the name of the person
    protected int movesLeft; // Added so we can track moves and uses separately
    protected int usesLeft; // Added so we can track moves and uses separately
    protected List<Item> itemList; // Added to track the items in the inventory
    protected Room currentRoom; // Added to track the current room of the person
    protected int capacity; // Added to track the capacity of the inventory
    protected boolean godMode = false; // Added to track if the person is in god mode
    protected int stunned = 0; // Added to track the stun duration

    /**
     * Sets the god mode of the person.
     * @param godMode The god mode to set.
     */
    public void setGodMode(boolean godMode) {
        this.godMode = godMode;
    }

    /**
     * Gets the god mode of the person.
     * @return The god mode of the person.
     */
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
        if (this.stunned > 0)
            throw new IllegalStateException("Person is stunned.");

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
        Menu.getGame().getMap().move(this, room);
    }

    /**
     * Uses the specified item.
     * @return The item that was used.
     */
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
        if (this.stunned > 0)
            throw new IllegalStateException("Student is stunned.");

        if (this.currentRoom.isSticky())
            throw new IllegalStateException("The room is sticky, the item cannot be picked up.");

        // Test if the item is in the same room
        if (!this.currentRoom.getItemList().contains(item)) {
            throw new IllegalStateException("The item is not in the same room.");
        }

        // Test if the inventory is full
        if (this.itemList.size() >= this.capacity) {
            throw new IllegalStateException("The player's inventory is full.");
        }

        // Pick up the item
        this.currentRoom.getItemList().remove(item);
        this.itemList.add(item);

        // Set item to picked up
        item.setPickedUp(true);
    }
    public String getName() {
        return this.name;
    }

    /**
     * Gets the current room of the person.
     *
     * @return The current room of the person.
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Gets the inventory of the person.
     * @return The inventory of the person.
     */
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

    public abstract boolean canMove();

    /**
     * Sets the number of moves left for the person.
     *
     * @param movesLeft The number of moves left to set.
     */
    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }

    /**
     * Sets the number of uses left for the person.
     * @param i The number of uses left to set.
     */
    public void setUsesLeft(int i) {
        this.usesLeft = i;
    }

    /**
     * Gets the capacity of the inventory.
     * @return The capacity of the inventory.
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
     * Sets the stun duration for the professor.
     *
     * @param n The duration of the stun.
     */
    public void stun(int n) {
        stunned = n;
    }

    /**
     * Checks if the professor is currently stunned.
     *
     * @return The stun duration.
     */
    public int getStunned() {
        return stunned;
    }

}
