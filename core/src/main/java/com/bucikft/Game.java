package com.bucikft;

import com.bucikft.Person.Cleaner;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Represents a game session.
 */
public class Game {

    private Map map; // Added to keep track of the map
    private final RoundManager roundManager; // Added to keep track of the round manager
    private final List<Student> students; // Added to keep track of students
    private final List<Student> deadStudents; // Added to keep track of dead students
    private final List<Professor> professors; // added to keep track of professors
    private final List<Cleaner> cleaners; // added to keep track of cleaners
    private Person focusedPerson; // Added to keep track of the focused person
    private final ConsoleUI UI; // Added to keep track of the UI
    private boolean debug = false; // Added to keep track of the debug mode
    private boolean started = false; // Added to keep track of the game state
    private final ProtoTest protoTest; // Added to keep track of the proto test
    private final IDmaker idMaker = new IDmaker(); // Added to keep track of the ID maker
    private boolean noAi = false; // Added to keep track of the AI state

    private ArrayList<Observable> observers;

    /**
     * Initializes a new game.
     */
    public Game() {
        this.roundManager = new RoundManager(this);
        this.students = new ArrayList<>();
        this.deadStudents = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.cleaners = new ArrayList<>();
        this.UI = new ConsoleUI(this);
        this.protoTest = new ProtoTest(this);

    }

    /**
     * Starts the game.
     */
    public void startGame() {
        this.started = true;
        this.roundManager.play();

    }

    /**
     * Retrieves the ProtoTest object.
     * @return The ProtoTest object.
     */
    public ProtoTest getProtoTest(){
        return protoTest;
    }

    /**
     * Sets the game state.
     * @param started The game state to set.
     */
    public void setIsStarted(boolean started) {
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
     * Retrieves the ID maker.
     * @return The ID maker.
     */
    public IDmaker getIdMaker() {
        return idMaker;
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

    /**
     * Retrieves the list of dead students in the game.
     * @return The list of dead students.
     */
    public ConsoleUI getUI() {
        return UI;
    }

    /**
     * Generates a specified number of students and adds them to the list of students.
     * Each student is assigned a unique ID generated by the provided IDMaker.
     *
     * @param number the number of students to generate.
     */
    public void generateStudents(int number) {
        for(int i = 0; i < number; i++){
            Student student = new Student(idMaker.makeID());
            this.students.add(student);
        }
    }

    /**
     * Generates a map with a specified number of rooms using the provided IDMaker.
     *
     * @param number the number of rooms to generate.
     */
    public void generateRooms(int number){
            this.map = new Map(number);
    }


    /**
     * Generates a specified number of professors and adds them to the list of professors.
     * Each professor is assigned a unique ID generated by the provided IDMaker.
     *
     * @param number the number of professors to generate.
     */
    public void generateProfessors(int number) {
        for (int i = 0; i < number; i++) {
            Professor professor = new Professor(idMaker.makeID());
            this.professors.add(professor);
        }
    }

    /**
     * Generates a specified number of cleaners and adds them to the list of cleaners.
     * Each cleaner is assigned a unique ID generated by the provided IDMaker.
     *
     * @param number the number of cleaners to generate.
     */
    public void generateCleaners(int number) {
        for (int i = 0; i < number; i++) {
            Cleaner cleaner = new Cleaner(idMaker.makeID());
            this.cleaners.add(cleaner);
        }
    }

    /**
     * Generates doors on the map based on the provided array of door parts.
     *
     * @param parts an array containing door parts to generate doors on the map.
     *              Each element in the array represents a door part.
     */
    public void generateDoors(String[] parts) {
        this.map.generateDoors(parts);
    }

    /**
     * Generates items on the map based on the provided string of item parts.
     *
     * @param parts a string containing item to generate items on the map.
     *              Each element in the string represents an item.
     */
    public void generateItems(String parts) {
        this.map.generateItems(parts);
    }

    /**
     * Places people in the rooms based on the provided string of people.
     *
     * @param people a string containing people to place in the rooms.
     *              Each element in the string represents a person.
     */
    public void placePeople(String people) {
        String[] parts = people.split("\\s+");
        int roomNumber = -1;

        for (String part : parts) {
            part = part.replace(",", "");
            if(part.contains(":")){
                roomNumber = Integer.parseInt(part.split(":")[0]);
                String name = part.split(":")[1];
                String[] n = name.split("#");
                int id = Integer.parseInt(n[1]);
                if (n[0].equals("St")) {
                    students.get(id-1).setCurrentRoom(map.getRoomList().get(roomNumber-1));
                    map.getRoomList().get(roomNumber-1).getPersonList().add(students.get(id-1));
                }
                else if (n[0].equals("Te")) {
                    professors.get(id-1).setCurrentRoom(map.getRoomList().get(roomNumber-1));
                    map.getRoomList().get(roomNumber-1).getPersonList().add(professors.get(id-1));
                }
                else if (n[0].equals("Cl")) {
                    cleaners.get(id-1).setCurrentRoom(map.getRoomList().get(roomNumber-1));
                    map.getRoomList().get(roomNumber-1).getPersonList().add(cleaners.get(id-1));
                }
            }
            else{
                String[] n = part.split("#");
                int id = Integer.parseInt(n[1]);
                if (n[0].equals("St")) {
                    students.get(id-1).setCurrentRoom(map.getRoomList().get(roomNumber-1));
                    map.getRoomList().get(roomNumber-1).getPersonList().add(students.get(id-1));

                }
                else if (n[0].equals("Te")) {
                    professors.get(id-1).setCurrentRoom(map.getRoomList().get(roomNumber-1));
                    map.getRoomList().get(roomNumber-1).getPersonList().add(professors.get(id-1));
                }
                else if (n[0].equals("Cl")) {
                    cleaners.get(id-1).setCurrentRoom(map.getRoomList().get(roomNumber-1));
                    map.getRoomList().get(roomNumber-1).getPersonList().add(cleaners.get(id-1));
                }
            }

        }

    }

}
