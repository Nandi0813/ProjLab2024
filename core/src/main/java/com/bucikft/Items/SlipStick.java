package com.bucikft.Items;

import com.bucikft.Person.Student;

import java.util.Scanner;

/**
 * Represents a SlipStick item, which can open the Emergency Exit.
 */
public class SlipStick extends Item {

    /**
     * Applies the effect of the SlipStick item on the user (a student).
     *
     * @param user The student who uses the SlipStick item.
     * @throws IllegalStateException If the room does not have an emergency exit or if the SlipStick item is already broken.
     */
    public void effect(Student user) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);

        // Check if the room has an emergency exit
        // Todo: Implement checking if room has emergency exit
        System.out.print("Does the room have an emergency exit? (y/n): ");
        boolean choice = scanner.next().equals("y");
        if (!choice) {
            throw new IllegalStateException("The room does not have an emergency exit.");
        }

        // Open the exit
        // Todo: Implement exit opening
        System.out.println("*The emergency exit has opened*");

        // Break the item
        this.setBroken(true);
    }
}
