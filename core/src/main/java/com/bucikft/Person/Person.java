package com.bucikft.Person;

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

    /**
     * Constructor to initialize a Person object.
     */
    protected Person() {
        this.itemList = new ArrayList<>();
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
        // Todo
        System.out.println("Does the player have moves left? (y/n): ");
        boolean choice = scanner.next().equals("y");
        if (!choice) {
            throw new IllegalStateException("The player has no more moves left.");
        }

        // Test if the rooms are neighbors
        // Todo
        System.out.println("Are the rooms neighbors? (y/n): ");
        choice = scanner.next().equals("y");
        if (!choice) {
            throw new IllegalStateException("The rooms are not neighbors.");
        }

        // Move the person to the room
        // Todo: Implement movement
        System.out.println("*Person moved*");

        // Decrement movesLeft
        // Todo: Decrement moves left
    }

    /**
     * Picks up the specified item.
     *
     * @param item The item to pick up.
     * @throws IllegalStateException If the player has no moves left, if the item is not in the same room, or if the inventory is full.
     */
    public void pickUp(Item item) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);

        // Test if the player has moves left
        // Todo
        System.out.println("Does the player have moves left? (y/n): ");
        boolean choice = scanner.next().equals("y");
        if (!choice) {
            throw new IllegalStateException("The player has no more moves left.");
        }

        // Test if the item is in the same room
        // Todo
        System.out.println("Is the item in the player's room? (y/n): ");
        choice = scanner.next().equals("y");
        if (!choice) {
            throw new IllegalStateException("The item is not in the player's room.");
        }

        // Test if the inventory is full
        // Todo
        System.out.println("Is the player's inventory full? (y/n): ");
        choice = scanner.next().equals("y");
        if (choice) {
            throw new IllegalStateException("The player's inventory is full.");
        }

        // Pick up the item
        // Todo: Implement picking up item
        System.out.println("*The player picked up the item*");

        // Decrement usesLeft
        // Todo: Decrement uses left
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
}
