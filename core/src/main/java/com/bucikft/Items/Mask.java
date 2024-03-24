package com.bucikft.Items;

import com.bucikft.Person.Student;

import java.util.Scanner;

/**
 * Represents a Mask item, which can be equipped and used to defend a Student from poison gas.
 */
public class Mask extends Item {

    /**
     * Applies the effect of the Mask item on the user (a student).
     *
     * @param user The student who uses the Mask item.
     * @throws IllegalStateException If the student is already wearing a mask.
     */
    public void effect(Student user) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);
        // Test if user is already wearing a mask
        // Todo: Test if user is already masked, meanwhile ask tester
        System.out.print("Is the student already wearing a mask? (y/n): ");
        boolean choice = scanner.next().charAt(0) == 'y';
        if (choice) {
            throw new IllegalStateException("The student is already wearing a mask");
        }

        // Put on mask
        // Todo: Implement putting on mask
        System.out.println("*The student put on the mask*");

        // Break item
        this.setBroken(true);
    }
}
