package com.bucikft.Items;

import com.bucikft.Person.Student;

/**
 * Represents a Holy Cup item, which shows the shortest path to the SlipStick when used by a Student.
 */
public class HolyCup extends Item {

    private int turns; // The number of turns remaining until the effect of the Holy Cup wears off.

    /**
     * Gets the number of turns remaining until the effect wears off.
     *
     * @return The number of turns remaining.
     */
    public int getTurns() {
        return turns;
    }

    /**
     * Sets the number of turns remaining until the effect wears off.
     *
     * @param newTurns The new number of turns remaining.
     */
    public void setTurns(int newTurns) {
        turns = newTurns;
    }

    /**
     * Applies the effect of the Holy Cup item on the user (a student).
     *
     * @param user The student who uses the Holy Cup item.
     * @throws IllegalStateException If the item is already broken.
     */
    public void effect(Student user) throws IllegalStateException {

        // Display the path to SlipStick
        // Todo: Implement path display
        System.out.println("*The path to SlipStick has appeared*");

        // Break the item
        this.setBroken(true);
    }
}