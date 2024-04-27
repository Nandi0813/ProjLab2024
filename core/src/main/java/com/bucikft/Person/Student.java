package com.bucikft.Person;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Items.Transistor;

import java.util.Scanner;

/**
 * Represents a student in the game.
 */
public class Student extends Person {

    private boolean alive = true;
    private boolean masked = false;
    private boolean protection = false; // Counter to track protection duration

    public Student(String name) {
        super(name);
    }

    /**
     * Uses the specified item.
     *
     * @param item The item to use.
     * @throws IllegalStateException If the student cannot use more items in their turn.
     */
    public void use(Item item) throws IllegalStateException {
        if (usesLeft <= 0) throw new IllegalStateException("The student cannot use more items in their turn.");
        item.effect(this);
        if (item.isBroken()) {
            this.itemList.remove(item);
        }
        usesLeft--;
    }

    /**
     * Drops the specified item.
     *
     * @param item The item to drop.
     * @throws IllegalStateException If there is not enough room in the room for the item.
     */
    public void drop(Item item) throws IllegalStateException {

        // Test if room has enough room for the item
        if (this.getCurrentRoom().getItemsList().size() >= this.getCurrentRoom().getItemCapacity())
            throw new IllegalStateException("There is not enough room for the item in the room.");

        // Drop item
        this.getCurrentRoom().getItemsList().add(item);

        // Remove item from inventory
        this.itemList.remove(item);

        // Set item to not picked up
        item.setPickedUp(false);
    }

    /**
     * Checks if the student can be killed.
     *
     * @return true if the student can be killed, otherwise false.
     */
    public boolean isKillable() {
        // for now, could be other things too
        return !protection;
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
    }

    /**
     * Checks if the student is alive.
     *
     * @return true if the student is alive, otherwise false.
     */
    public boolean isAlive() {
        return this.alive;
    }

    /**
     * Sets the status of the student's life.
     *
     * @param alive The status of the student's life.
     */
    public void setAlive(final boolean alive) {
        this.alive = alive;
    }

    /**
     * Checks if the student is masked.
     *
     * @return true if the student is masked, otherwise false.
     */
    public boolean isMasked() {
        return this.masked;
    }

    /**
     * Sets the status of the student's mask.
     *
     * @param masked The status of the student's mask.
     */
    public void setMasked(final boolean masked) {
        this.masked = masked;
    }

    public void setProtected(boolean prot) {
        this.protection = prot;
    }

    @Override
    public String toString() {
        return "Student#" + this.getName() + " " + (this.alive ? "alive" : "dead");
    }
}
