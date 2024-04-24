package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

import java.util.Scanner;

/**
 * Represents a Hammer item, which can split a room when used by a student.
 */
public class Hammer extends Item {

    public Hammer(String ID) {
        super(ID);
    }

    /**
     * Applies the effect of the Hammer item on the user (a student).
     *
     * @param user The student who uses the Hammer item.
     * @throws IllegalStateException If the room cannot be split.
     */
    public void effect(Student user) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);

        // Test if room is big enough for splitting
        if (user.getCurrentRoom().getItemCapacity()>=2) throw new IllegalStateException("The room cannot be split.");

        // Split room
        // Todo: Implement room splitting

        System.out.println("*The room has been split*");

        // Break item
        this.setBroken(true);
    }

    @Override
    public String toString() {
        return "Hammer#" + ID;
    }
}
