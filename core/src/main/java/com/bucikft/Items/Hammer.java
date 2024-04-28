package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Menu;
import com.bucikft.Person.Student;
import com.bucikft.Room;

/**
 * Represents a Hammer item, which can split a room when used by a student.
 */
public class Hammer extends Item {

    public Hammer(String ID, boolean isFalseItem) {
        super(ID, isFalseItem);
    }

    /**
     * Applies the effect of the Hammer item on the user (a student).
     *
     * @param student The student who uses the Hammer item.
     * @throws IllegalStateException If the room cannot be split.
     */
    public void effect(Student student) throws IllegalStateException {
        // Test if room is big enough for splitting
        if (student.getCurrentRoom().getItemCapacity() <= 2) {
            throw new IllegalStateException("The room cannot be split.");
        }

        // Split room
        Menu.getGame().getMap().split(student.getCurrentRoom());

        System.out.println("*The room has been split*");

        // Break item
        this.setBroken(true);
    }

    @Override
    public String toString() {
        return "Hammer#" + ID;
    }
}
