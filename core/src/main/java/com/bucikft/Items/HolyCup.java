package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Menu;
import com.bucikft.Person.Student;
import com.bucikft.Room;

/**
 * Represents a Holy Cup item, which shows the shortest path to the SlipStick when used by a Student.
 * When used, the student loses a random item from his/her inventory.
 */
public class HolyCup extends Item {

    public HolyCup(String ID, boolean isFalseItem) {
        super(ID, isFalseItem);
        this.turns = 0;
    }

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

        this.setBroken(true);
    }

    @Override
    public String toString() {
        return "HolyCup#" + ID;
    }
}
