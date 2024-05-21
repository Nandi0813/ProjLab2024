package com.bucikft;

import com.bucikft.Person.*;
import javafx.beans.Observable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game session.
 */
public class Game implements Serializable {
    private Map map; // Added to keep track of the map
    private final RoundManager roundManager; // Added to keep track of the round manager
    private final List<Student> students; // Added to keep track of students
    private final List<Student> deadStudents; // Added to keep track of dead students
    private final List<Professor> professors; // added to keep track of professors
    private final List<Cleaner> cleaners; // Added to keep track of cleaners
    private Person focusedPerson; // Added to keep track of the focused person

    /**
     * Initializes a new game.
     */
    public Game() {
        this.roundManager = new RoundManager(this);
        this.students = new ArrayList<>();
        this.deadStudents = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.cleaners = new ArrayList<>();
    }

    /**
     * Sets the focused person.
     *
     * @param person The person to set as focused.
     */
    public void setFocusedPerson(Person person) {
        this.focusedPerson = person;
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

    /**
     * Retrieves the list of dead students in the game.
     *
     * @return The list of dead students.
     */
    public RoundManager getRoundManager() {
        return roundManager;
    }

    /**
     * Retrieves the list of dead students in the game.
     *
     * @return The list of dead students.
     */
    public Person getFocusedPerson() {
        return focusedPerson;
    }

    /**
     * Retrieves the list of dead students in the game.
     *
     * @return The list of dead students.
     */
    public List<Professor> getProfessors() {
        return professors;
    }

    /**
     * Retrieves the list of dead students in the game.
     *
     * @return The list of dead students.
     */
    public List<Cleaner> getCleaners() {
        return cleaners;
    }

    /**
     * Start game.
     *
     * @param playerCount the player count
     * @param mapSize     the map size
     */
    public void startGame(int playerCount, int mapSize) {
        for (int i = 1; i <= playerCount; i++) {
            students.add(new Student(String.valueOf(i)));
        }
        for (int i = 1; i <= (playerCount / 3 + 1); i++) {
            if(i == 1){
                professors.add(new BossProfessor(String.valueOf(i)));
            }
            else{
                professors.add(new Professor(String.valueOf(i)));
            }
        }
        for (int i = 1; i <= (playerCount / 4 + 1); i++) {
            cleaners.add(new Cleaner(String.valueOf(i)));
        }

        this.map = new Map(mapSize, students, professors, cleaners);

        System.out.println("Game started with "
                + students.size() + " players, "
                + professors.size() + " professors, "
                + cleaners.size() + " cleaners and "
                + mapSize + " map size.");
        focusedPerson = students.get(0);
    }


}
