package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;
import com.bucikft.Room;

/**
 * Represents a Transistor item, which can be used to teleport between rooms.
 */
public class Transistor extends Item {

    public Transistor(String ID, boolean isFalseItem) {
        super(ID, isFalseItem);
    }

    /** The paired Transistor item. */
    public Transistor pair = null;
    private Room currentRoom;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room r){
        currentRoom = r;
    }



    /**
     * Applies the effect of the Transistor item on the user (a student).
     *
     * @param user The student who uses the Transistor item.
     * @throws IllegalStateException If the Transistor doesn't have a pair or if the pair hasn't been put down.
     */
    public void effect(Student user) throws IllegalStateException {
        // Test if Transistor has a pair
        if (pair == null) throw new IllegalStateException("The Transistor doesn't have a pair.");

        // Test if pair has been put down
        if (pair.pickedUp) throw new IllegalStateException("The pair Transistor hasn't been put down.");

        // Teleport if the Transistor has a pair
        // Todo: Implement teleportation


        // Break items
        this.setBroken(true);
        this.pair.setBroken(true);
    }
    @Override
    public String toString() {
        return "Transistor#" + ID;
    }
}
