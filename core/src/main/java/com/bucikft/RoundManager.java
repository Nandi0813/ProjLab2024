package com.bucikft;

/**
 * Manages the rounds in the game.
 */
public class RoundManager {

    private Game game;
    private int currentRound = 0;

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

}
