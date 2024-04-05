package com.bucikft.Person;

import com.bucikft.Items.Interface.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a Professor in the game.
 */
public class Professor extends Person {

    private List<Student> killedStudents; // List to keep track of killed students

    /**
     * Constructor to initialize a Professor object.
     */
    public Professor() {
        this.killedStudents = new ArrayList<>();
    }

    private int stunned = 0; // Counter to track stun duration

    /**
     * Sets the stun duration for the professor.
     *
     * @param n The duration of the stun.
     */
    public void stun(int n) {
        stunned = n;
    }

    /**
     * Checks if the professor is currently stunned.
     *
     * @return The stun duration.
     */
    public int isStunned() {
        return stunned;
    }

    /**
     * Adds a killed student to the list.
     *
     * @param killedStudent The student that was killed.
     */
    public void addKilledStudent(Student killedStudent) {
        killedStudents.add(killedStudent);
    }

    /**
     * Removes a killed student from the list.
     *
     * @param killedStudent The student to remove.
     */
    public void removeKilledStudent(Student killedStudent) {
        killedStudents.remove(killedStudent);
    }

    /**
     * Kills a student in the same room as the professor.
     *
     * @param student The student to kill.
     * @throws IllegalStateException If the student and the professor are not in the same room, if the student is already dead, if the student is protected, or if the professor has no moves left.
     */
    public void killStudent(Student student) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);

        // Check if student is in the same room
        // Todo
        System.out.println("A hallgató és a professzor egy szobában vannak? y/n: ");
        boolean choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A hallgató és a professzor nem egy szobában vannak.");

        // Check if student is alive
        // Todo
        System.out.println("A hallgató él? y/n: ");
        choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A hallgató már halott.");

        // Check if student is protected
        // Todo
        System.out.println("A hallgató védve van? y/n: ");
        choice = scanner.next().equals("y");
        if (choice) throw new IllegalStateException("A hallgató védve van.");

        // Check if prof has moves left in his turn
        // Todo
        System.out.println("Van még lépése hátra a professzornak? y/n: ");
        choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A professzornak nincs több lépése.");


        // Kill student
        // Todo
        System.out.println("*A hallgató meghalt*");

        // Todo:
        // Decrease moves of professor
        // Add to killed students
    }

    @Override
    public void pickUp(Item item) {
        // Method overridden from superclass, not used in Professor class
    }
}
