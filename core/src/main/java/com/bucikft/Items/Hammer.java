package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

import java.util.Scanner;

/**
 * Represents a Hammer item, which can split a room when used by a student.
 */
public class Hammer extends Item {

    /**
     * Applies the effect of the Hammer item on the user (a student).
     *
     * @param user The student who uses the Hammer item.
     * @throws IllegalStateException If the room cannot be split.
     */
    public void effect(Student user) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);

        // Test if room is big enough for splitting
        // Todo: Implement test, meanwhile ask tester
        System.out.print("Is the room big enough to be split? (y/n): ");
        boolean choice = scanner.next().charAt(0) == 'y';
        if (!choice) {
            throw new IllegalStateException("The room cannot be split.");
        }

        // Split room
        // Todo: Implement room splitting
        System.out.println("*The room has been split*");

        // Break item
        this.setBroken(true);
    }
}
