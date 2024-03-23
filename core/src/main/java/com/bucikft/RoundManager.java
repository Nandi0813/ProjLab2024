package com.bucikft;

public class RoundManager {

    private Game game;
    private int currentRound = 0;

    public RoundManager(Game game) {
        this.game = game;
    }

    public void nextRound() {
        currentRound++;
    }

    public void endRound() {

    }

    public int getCurrentRound() { return this.currentRound; }
    public void setCurrentRound(final int currentRound) { this.currentRound = currentRound; }

}
