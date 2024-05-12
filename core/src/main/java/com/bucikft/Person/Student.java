package com.bucikft.Person;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Items.Transistor;
import com.bucikft.Menu;

/**
 * Represents a student in the game.
 */
public class Student extends Person {

    private boolean alive = true; // Indicates whether the student is alive or not
    private boolean masked = false; // Indicates whether the student is wearing a mask or not
    private boolean protection = false; // Counter to track protection duration

    public Student(String name) {
        super(name);
    }

    /**
     * Uses the specified item.
     *
     * @param item The item to use.
     * @throws IllegalStateException If  student cannot use more items in their turn.
     */
    public void use(Item item) throws IllegalStateException {
        if (this.stunned > 0)
            throw new IllegalStateException("Student is stunned.");

        if (usesLeft <= 0)
            throw new IllegalStateException("The student cannot use more items in their turn.");

        // Test if the item is broken
        if (item.isBroken())
            throw new IllegalStateException("The item is broken.");

        try {
            item.effect(this);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        if (item.isBroken()) {
            this.itemList.remove(item);
        }

        if (!godMode)
            usesLeft--;
   }

    /**
     * Drops the specified item.
     *
     * @param item The item to drop.
     * @throws IllegalStateException If there is not enough room in the room for the item.
     */
    public void drop(Item item) throws IllegalStateException {
        if (this.stunned > 0)
            throw new IllegalStateException("Student is stunend.");

        // Test if room has enough room for the item
        if (this.getCurrentRoom().getItemList().size() >= this.getCurrentRoom().getItemCapacity())
            throw new IllegalStateException("There is not enough room for the item in the room.");

        // Drop item
        this.getCurrentRoom().getItemList().add(item);

        // Remove item from inventory
        this.itemList.remove(item);
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
        t1.connect(t2,this );
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

        if (alive)
            Menu.getGame().getDeadStudents().remove(this);
        else
            Menu.getGame().getDeadStudents().add(this);
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

    /**
     * Checks if the student is protected.
     * @param prot The status of the student's protection.
     */
    public void setProtected(boolean prot) {
        this.protection = prot;
    }

    /**
     * Checks if the student is protected.
     * @return true if the student is protected, otherwise false.
     */
    @Override
    public boolean canMove() {
        return this.isAlive() && this.getStunned() == 0;
    }

    /**
     * Returns a string representation of the student.
     * @return The string representation of the student.
     */
    @Override
    public String toString() {
        return "Student#" + this.getName() + " " + (this.alive ? "alive" : "dead") + " " + (this.getStunned() <= 0 ? "not stunned" : "stunned");
    }
}
