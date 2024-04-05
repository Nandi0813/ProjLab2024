package com.bucikft.Person;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Items.Transistor;

import java.util.Scanner;

/**
 * Represents a student in the game.
 */
public class Student extends Person {

    private boolean alive;
    private boolean masked = false;

    /**
     * Uses the specified item.
     *
     * @param item The item to use.
     * @throws IllegalStateException If the student cannot use more items in their turn.
     */
    public void use(Item item) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Can the student use more items in their turn? (y/n): ");
        boolean choice = scanner.next().charAt(0)=='y';
        if (!choice) throw new IllegalStateException("The student cannot use more items.");
        item.effect(this);
    }

    /**
     * Drops the specified item.
     *
     * @param item The item to drop.
     * @throws IllegalStateException If there is not enough room in the room for the item.
     */
    public void drop(Item item) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);

        // Test if room has enough room for the item
        // todo
        System.out.println("Is there enough room in the room for the item? (y/n): ");
        boolean choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("There is not enough room for the item in the room.");

        // Drop item
        // todo
        System.out.println("*The item has been dropped in the room*");

        // Remove item from inventory
        // todo
        System.out.println("*The item has been removed from the player's inventory*");
    }

    /**
     * Checks if the student can be killed.
     *
     * @return true if the student can be killed, otherwise false.
     */
    public boolean isKillable() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pickUp(Item item) throws IllegalStateException {
        if (itemList.size()>5) throw new IllegalStateException("The player has no more space for items.");
        itemList.add(item); // Only for testing, pickUp mechanism will be different
    }

    /**
     * Joins two transistors.
     *
     * @param t1 The first transistor.
     * @param t2 The second transistor.
     * @throws IllegalStateException If either of the transistors already has a pair.
     */
    public void join(Transistor t1, Transistor t2) throws IllegalStateException {
        if (t1.pair != null || t2.pair != null) throw new IllegalStateException("The transistors already have pairs.");
        t1.pair = t2;
        t2.pair = t1;
        System.out.println("The transistors have been paired.");
    }

    /**
     * Checks if the student is alive.
     *
     * @return true if the student is alive, otherwise false.
     */
    public boolean isAlive() { return this.alive; }

    /**
     * Sets the status of the student's life.
     *
     * @param alive The status of the student's life.
     */
    public void setAlive(final boolean alive) { this.alive = alive; }

    /**
     * Checks if the student is masked.
     *
     * @return true if the student is masked, otherwise false.
     */
    public boolean isMasked() { return this.masked; }

    /**
     * Sets the status of the student's mask.
     *
     * @param masked The status of the student's mask.
     */
    public void setMasked(final boolean masked) { this.masked = masked; }
}
