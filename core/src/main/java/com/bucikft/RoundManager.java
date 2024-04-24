package com.bucikft;

import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

/**
 * Manages the rounds in the game.
 */
public class RoundManager {

    private Game game;
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

        // TODO do AI movement and actions of professors and cleaners
        System.out.println("playing AI turns....");


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
