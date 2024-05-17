package com.bucikft.Person;

import com.bucikft.Controllers.TileType;
import com.bucikft.Items.Interface.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a Professor in the game.
 */
public class Professor extends Person {

    private final List<Student> killedStudents; // List to keep track of killed students
    private int killsLeft; // Counter to track the number of kills left in this round

    /**
     * Constructor to initialize a Professor object.
     */
    public Professor(String name) {
        super(name, TileType.Professor);
        this.killedStudents = new ArrayList<>();
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

    public boolean canMove() {
        return this.getStunned() == 0;
    }

    /**
     * Kills a student in the same room as the professor.
     *
     * @param student The student to kill.
     * @throws IllegalStateException If the student and the professor are not in the same room, if the student is already dead, if the student is protected, or if the professor has no moves left.
     */
    public void killStudent(Student student) throws IllegalStateException {
        // Check if student is in the same room
        if (!this.getCurrentRoom().equals(student.getCurrentRoom())) throw new IllegalStateException("A hallgató és a professzor nem egy szobában vannak.");

        // Check if student is alive
        if (!student.isAlive()) throw new IllegalStateException("The student is already dead.");

        // Check if student is protected
        if (!student.isKillable()) {
            student.setProtected(false);
            throw new IllegalStateException("The student is protected");
        }

        // Check if prof has moves left in his turn
        if (this.movesLeft <= 0) throw new IllegalStateException("The professor has no more moves.");

        // Kill student
        student.setAlive(false);

        System.out.printf("Professor#%s killed Student#%s\n", this.getName(), student.getName());

        // Decrease moves of professor
        this.killsLeft--;
        // Add to killed students
        this.addKilledStudent(student);
    }

    @Override
    public void pickUp(Item item) {
        // Method overridden from superclass, not used in Professor class
    }

    /**
     * Resets the professor's moves and the list of killed students.
     * @return The number of kills left.
     */
    public int getKillsLeft() { return this.killsLeft; }

    /**
     * Sets the number of kills left for the professor.
     * @param i The number of kills left.
     */
    public void setKillsLeft(int i) {
        this.killsLeft = i;
    }

    /**
     * Returns a string representation of the professor.
     * @return The string representation of the professor.
     */
    @Override
    public String toString() {
        if (this.getStunned() <= 0) {
            return "Professor#" + this.getName() + " not stunned ";
        } else {
            return "Professor#" + this.getName() + " stunned ";
        }
    }
}
