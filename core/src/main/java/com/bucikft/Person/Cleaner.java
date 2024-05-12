package com.bucikft.Person;

/**
 * Represents a cleaner person, who can remove all other people from a room.
 */
public class Cleaner extends Person {

    /**
     * The constructor of the Cleaner class.
     * @param name The name of the cleaner.
     */
    public Cleaner(String name) {
        super(name);
    }

    /**
     * Returns whether the cleaner can move or not.
     * @return True, since the cleaner can move.
     */
    @Override
    public boolean canMove() {
        return true;
    }

    /**
     * Returns a string representation of the cleaner.
     * @return The string representation of the cleaner.
     */
    @Override
    public String toString() {
        return "Cleaner#" + this.getName();
    }

}
