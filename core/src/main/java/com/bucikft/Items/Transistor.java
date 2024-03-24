package com.bucikft.Items;

import com.bucikft.Person.Student;

import java.util.Scanner;

/**
 * Represents a Transistor item, which can be used to teleport between rooms.
 */
public class Transistor extends Item {

    /** The paired Transistor item. */
    public Transistor pair = null;


    /**
     * Applies the effect of the Transistor item on the user (a student).
     *
     * @param user The student who uses the Transistor item.
     * @throws IllegalStateException If the Transistor doesn't have a pair or if the pair hasn't been put down.
     */
    public void effect(Student user) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);

        // Test if Transistor has a pair
        if (pair == null) {
            throw new IllegalStateException("The Transistor doesn't have a pair.");
        }

        // Test if pair has been put down
        System.out.print("Is the pair Transistor put down? (y/n): ");
        boolean choice = scanner.next().equals("y");
        if (!choice) {
            throw new IllegalStateException("The pair Transistor hasn't been put down.");
        }

        // Teleport if the Transistor has a pair
        // Todo: Implement teleportation
        System.out.println("*The player teleported to the other Transistor*");

        // Break items
        this.setBroken(true);
        this.pair.setBroken(true);
    }
}
