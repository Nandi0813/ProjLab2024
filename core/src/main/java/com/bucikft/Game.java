package com.bucikft;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Cleaner;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

import java.nio.file.Path;
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
    private List<Professor> professors; // added to keep track of professors
    private List<Cleaner> cleaners; // added to keep track of cleaners
    private Person focusedPerson;
    private ConsoleUI UI;
    private boolean debug = false;
    private IDmaker idMaker = new IDmaker();
    private boolean started = false;


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

    }

    /**
     * Starts the game.
     */
    public void startGame(int playerCount, int mapSize) {
        // create students and professors with unique id-s
        // number of professors may change based on future agreements
        for (int i = 0; i < playerCount; i++) {
            Student student = new Student(idMaker.makeID());
            this.students.add(student);
            Professor professor = new Professor(idMaker.makeID());
            this.professors.add(professor);
        }
        Cleaner cleaner = new Cleaner(idMaker.makeID());
        this.cleaners.add(cleaner);

        this.map = new Map(mapSize, students, professors, cleaners, idMaker);
        this.started = true;
        this.roundManager.play();

    }



    public boolean isStarted() {
        return this.started;
    }

    public void setFocusedPerson(Person person) {
        this.focusedPerson = person;
    }

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
     * Retrieves the list of dead students in the game.
     *
     * @return The list of dead students.
     */
    public List<Student> getDeadStudents() {
        return this.deadStudents;
    }
    public RoundManager getRoundManager() {
        return roundManager;
    }
    public Person getFocusedPerson() {
        return focusedPerson;
    }
    public void setDebugMode() {
        this.debug = !this.debug;
    }
    public boolean getDebugMode() {
        return this.debug;
    }


    public List<Professor> getProfessors() {
        return professors;
    }

    public List<Cleaner> getCleaners() {
        return cleaners;
    }

    public ConsoleUI getUI() {
        return UI;
    }

    public void generateStudents(int number) {
        for(int i = 0; i < number; i++){
            Student student = new Student(idMaker.makeID());
            this.students.add(student);
        }
    }

    public void generateRooms(int number){
            this.map = new Map(number, students, professors, cleaners, idMaker);
    }

    public void generateProfessors(int number) {
        for (int i = 0; i < number; i++) {
            Professor professor = new Professor(idMaker.makeID());
            this.professors.add(professor);
        }
    }

    public void generateCleaners(int number) {
        for (int i = 0; i < number; i++) {
            Cleaner cleaner = new Cleaner(idMaker.makeID());
            this.cleaners.add(cleaner);
        }
    }

    public void generateDoors(String[] parts) {
        this.map.generateDoors(parts);
    }

    public void generateItems(String parts) {
        this.map.generateItems(parts);
    }

    public void placePeople(String people) {
        String[] parts = people.split(":");
        int roomNumber = -1;
        for (String part : parts) {
            part = part.trim();
            if (part.matches("\\d+")) {
                roomNumber = Integer.parseInt(part);
            } else {
                String[] peopletoplace = part.split(",");
                for (String p : peopletoplace) {
                    String[] type =  p.trim().split("#");
                    if(type[0].equals("St")){
                        students.get(Integer.parseInt(type[1])).setCurrentRoom(roomNumber);
                    }
                    Item itemToGenerate = this.items.get(item.trim());
                    roomList.get(roomNumber-1).getItemsList().add(itemToGenerate);
                    itemList.add(itemToGenerate);
                }
            }
        }
    }

}
