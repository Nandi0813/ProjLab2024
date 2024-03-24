package com.bucikft.Items;

import com.bucikft.Person.Student;

import java.util.Scanner;

/**
 * Represents the DKC item, which fills a room with gas when used by a Student.
 */
public class DKC extends Item {

    /**
     * Applies the effect of the DKC item on the user (a student).
     *
     * @param user The student who uses the DKC item.
     * @throws IllegalStateException If the room is already filled with gas.
     */
    public void effect(Student user) throws IllegalStateException {
        // Test if room is filled with gas
        // Todo: Test if room is gas filled, meanwhile ask tester
        Scanner scanner = new Scanner(System.in);
        System.out.print("Is the room already filled with gas? (y/n): ");
        boolean choice = scanner.next().charAt(0) == 'y';
        if (choice) {
            throw new IllegalStateException("The room is already filled with gas.");
        }

        // Gas the room
        // Todo: Implement filling the room with gas
        System.out.println("*The room has been filled with gas*");

        // Break the item
        this.setBroken(true);
    }
}
