package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Person.Cleaner;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

import java.util.Random;

/**
 * Manages the rounds in the game.
 */
public class RoundManager {

    private final Game game;
    private int currentRound = 0;
    private int currentTurn = 0;

    /**
     * Initializes a new round manager for the specified game.
     *
     * @param game The game to manage rounds for.
     */
    public RoundManager(Game game) {
        this.game = game;
    }

    /**
     * Moves to the next round.
     */
    public void nextRound() {
        currentRound++;
        // reset student characters
        for (Student student: game.getStudents()) {
            student.setMovesLeft(1);
            student.setUsesLeft(1);
        }

        Random rand = new Random();

        for (Professor professor: game.getProfessors()) {
            if (professor.getMovesLeft() > 0) {
                Room currentRoom = professor.getCurrentRoom();
                Door door = currentRoom.getDoorList().get(rand.nextInt(currentRoom.getDoorList().size() - 1));

                Room roomTo = door.getWhereTo(currentRoom);

                game.getMap().move(professor, roomTo);

                for (Person p : roomTo.getPersonList()) {
                    if (professor.getMovesLeft() == 0)
                        break;

                    if (p instanceof Student s) {
                        try {
                            professor.killStudent(s);
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }

        for (Cleaner cleaner: game.getCleaners()) {
            if (cleaner.getMovesLeft() > 0) {
                Room currentRoom = cleaner.getCurrentRoom();
                Door door = currentRoom.getDoorList().get(rand.nextInt(currentRoom.getDoorList().size() - 1));

                Room roomTo = door.getWhereTo(currentRoom);

                game.getMap().move(cleaner, roomTo);
            }
        }


        // reset ai characters
        for (Professor professor: game.getProfessors()) {
            professor.setMovesLeft(1);
            professor.setUsesLeft(1);
            professor.setKillsLeft(1);
        }
        for (Person cleaner: game.getCleaners()) {
            cleaner.setMovesLeft(1);
            cleaner.setUsesLeft(1);
        }
        // set turn to 0
        currentTurn = 0;
        game.setFocusedPerson(game.getStudents().get(0));
    }

    public void nextTurn() {
        currentTurn++;
        if (currentTurn == game.getStudents().size()) {
            nextRound();
        } else {
            game.setFocusedPerson(game.getStudents().get(currentTurn));
        }
    }

    public void play() {
        ConsoleUI ui = game.getUI();
        game.setFocusedPerson(game.getStudents().get(0));
        for (Student student: game.getStudents()) {
            student.setMovesLeft(1);
            student.setUsesLeft(1);
        }
        while (game.isStarted()) {
            try {
                if (!game.getDebugMode()) ui.printGameState();
                ui.readCommands();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Ends the current round.
     */
    public void endRound() {

    }

    /**
     * Retrieves the current round number.
     *
     * @return The current round number.
     */
    public int getCurrentRound() {
        return this.currentRound;
    }

    /**
     * Sets the current round number.
     *
     * @param currentRound The round number to set.
     */
    public void setCurrentRound(final int currentRound) {
        this.currentRound = currentRound;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }
}
