package com.bucikft.Person;

import com.bucikft.Room;

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
     * Moves the cleaner to the given room and removes all other people from the room.
     * @param room The room to move to.
     */
    @Override
    public void move(Room room) {
        super.move(room);
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
