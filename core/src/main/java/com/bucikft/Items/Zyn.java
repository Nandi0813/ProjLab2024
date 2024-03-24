package com.bucikft.Items;

import com.bucikft.Person.Student;

import java.util.Scanner;

/**
 * Represents a Zyn item, which can revive the first dead student in the room when used by a student.
 */
public class Zyn extends Item {

    /**
     * Applies the effect of the Zyn item, reviving the first dead student in the room.
     *
     * @param user The student who uses the Zyn item.
     * @throws IllegalStateException If there is no dead student in the room or if the Zyn item is broken.
     */
    public void effect(Student user) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);

        // Test if there is a dead student in the room
        // Todo: Implement check, for now ask tester
        System.out.println("Is there a dead student in the room? (y/n): ");
        boolean choice = scanner.next().equals("y");
        if (!choice) {
            throw new IllegalStateException("There is no dead student in the room.");
        }

        // Revive the first dead student in the room
        // Todo: Implement reviving
        System.out.println("*The Zyn revives the first dead student in the room*");

        // Break item
        setBroken(true);
    }
}
