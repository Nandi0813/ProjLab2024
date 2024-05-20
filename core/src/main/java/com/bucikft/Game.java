package com.bucikft;

import com.bucikft.Person.Cleaner;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;
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
    private ArrayList<Observable> observers; // Added to keep track of the observers

    private boolean debug = false; // Added to keep track of the debug mode
    private boolean started = false; // Added to keep track of the game state
    private boolean noAi = false; // Added to keep track of the AI state

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
     * Sets the game state.
     * @param started The game state to set.
     */
    public void setStarted(boolean started) {
        this.started = started;
    }

    /**
     * Retrieves the game state.
     * @return The game state.
     */
    public boolean isStarted() {
        return this.started;
    }

    /**
     * Sets the focused person.
     * @param person The person to set as focused.
     */
    public void setFocusedPerson(Person person) {
        this.focusedPerson = person;
    }

    /**
     * Retrieves the focused person.
     * @return The focused person.
     */
    public boolean getNoAi() { return noAi; }

    /**
     * Sets the AI state.
     * @param newai The AI state to set.
     */
    public void setNoAi(boolean newai) { noAi = newai; }

    /**
     * Ends the game.
     */
    public void endGame() {
        this.started = false;
    }

    /**
     * Retrieves the game map.
     * @return The game map.
     */
    public Map getMap() {
        return this.map;
    }

    public Room getRoom(String id) {
        for (Room room : this.getMap().getRoomList())
            if (room.getID().equalsIgnoreCase(id))
                return room;
        return null;
    }

    /**
     * Retrieves the list of students in the game.
     * @return The list of students.
     */
    public List<Student> getStudents() {
        return this.students;
    }

    /**
     * Retrieves the list of dead students in the game.
     * @return The list of dead students.
     */
    public List<Student> getDeadStudents() {
        return this.deadStudents;
    }

    /**
     * Retrieves the student with the specified ID.
     * @param id The ID of the student to retrieve.
     * @return The student with the specified ID.
     */
    public Student getStudent(String id) {
        for (Student student : this.students)
            if (student.getName().equals(id))
                return student;
        return null;
    }

    /**
     * Retrieves the list of dead students in the game.
     * @return The list of dead students.
     */
    public RoundManager getRoundManager() {
        return roundManager;
    }

    /**
     * Retrieves the list of dead students in the game.
     * @return The list of dead students.
     */
    public Person getFocusedPerson() {
        return focusedPerson;
    }

    /**
     * Sets the debug mode.
     * @param b The debug mode to set.
     */
    public void setDebugMode(boolean b) {
        this.debug = b;
    }

    /**
     * Retrieves the debug mode.
     * @return The debug mode.
     */
    public boolean getDebugMode() { return this.debug; }

    /**
     * Retrieves the list of dead students in the game.
     * @return The list of dead students.
     */
    public List<Professor> getProfessors() {
        return professors;
    }

    /**
     * Retrieves the student with the specified ID.
     * @param id The ID of the professor to retrieve.
     * @return The professor with the specified ID.
     */
    public Professor getProfessor(String id) {
        for (Professor professor : this.professors)
            if (professor.getName().equals(id))
                return professor;
        return null;
    }

    /**
     * Retrieves the list of dead students in the game.
     * @return The list of dead students.
     */
    public List<Cleaner> getCleaners() {
        return cleaners;
    }

    /**
     * Retrieves the cleaner with the specified ID.
     * @param id The ID of the cleaner to retrieve.
     * @return The cleaner with the specified ID.
     */
    public Cleaner getCleaner(String id) {
        for (Cleaner cleaner : this.cleaners)
            if (cleaner.getName().equals(id))
                return cleaner;
        return null;
    }

    public void startGame(int playerCount, int mapSize) {
        for (int i = 1; i <= playerCount; i++) {
            students.add(new Student(String.valueOf(i)));
        }
        for (int i = 1; i <= (playerCount / 2 + 1); i++) {
            professors.add(new Professor(String.valueOf(i)));
        }
        for (int i = 1; i <= (playerCount / 3 + 1); i++) {
            cleaners.add(new Cleaner(String.valueOf(i)));
        }

        this.map = new Map(mapSize, students, professors, cleaners);
        this.setStarted(true);

        System.out.println("Game started with "
                + students.size() + " players, "
                + professors.size() + " professors, "
                + cleaners.size() + " cleaners and "
                + mapSize + " map size.");
        focusedPerson = students.get(0);
    }


}
