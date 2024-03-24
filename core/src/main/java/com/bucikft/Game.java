package com.bucikft;

import com.bucikft.Person.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game session.
 */
public class Game {

    private Map map;
    private RoundManager roundManager;
    private List<Student> students;
    private List<Student> deadStudents;

    /**
     * Initializes a new game.
     */
    public Game() {
        this.map = new Map();
        this.roundManager = new RoundManager(this);
        this.students = new ArrayList<>();
        this.deadStudents = new ArrayList<>();
    }

    /**
     * Starts the game.
     */
    public void startGame() {

    }

    /**
     * Ends the game.
     */
    public void endGame() {

    }

    /**
     * Retrieves the game map.
     *
     * @return The game map.
     */
    public Map getMap() {
        return this.map;
    }

    /**
     * Retrieves the list of students in the game.
     *
     * @return The list of students.
     */
    public List<Student> getStudents() {
        return this.students;
    }

    /**
     * Retrieves the list of dead students in the game.
     *
     * @return The list of dead students.
     */
    public List<Student> getDeadStudents() {
        return this.deadStudents;
    }

}
