package com.bucikft.Items;

import com.bucikft.Menu;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;
import com.bucikft.Room;

/**
 * Represents a Transistor item, which can be used to teleport between rooms.
 */
public class Transistor extends Item {

    /**
     * The constructor of the Transistor class.
     * @param ID The unique identifier of the item.
     * @param isFalseItem Indicates whether the item is a false item or not.
     */
    public Transistor(String ID, boolean isFalseItem) {
        super(ID, isFalseItem);
    }

    /** The paired Transistor item. */
    public Transistor pair = null;

    public void connect(Transistor t, Student user) throws IllegalStateException {
        if(user.getCurrentRoom().getItemList().contains(t) && !t.pickedUp) {
            pair = t;
            System.out.println("\n Transistors paired.\n");
        }
        else
            throw new IllegalStateException("Cannot connect transistors.");
    }
    /**
     * Applies the effect of the Transistor item on the user (a student).
     *
     * @param user The student who uses the Transistor item.
     * @throws IllegalStateException If the Transistor doesn't have a pair or if the pair hasn't been put down.
     */
    public void effect(Student user) throws IllegalStateException {
        if (pair == null) throw new IllegalStateException("The Transistor doesn't have a pair.");
        if (pair.pickedUp) throw new IllegalStateException("The pair has been picked up.");

        for(Room r: Menu.getGame().getMap().getRoomList()){
            if(r.getItemList().contains(pair))
                if(r.getCapacity() > r.getPersonList().size()){
                    Menu.getGame().getMap().move(user,r);
                    user.setMovesLeft(user.getMovesLeft()+1);
                }
                else throw new IllegalStateException("Room is full, cannot teleport.");
        }

        this.setBroken(true);
        this.pair.setBroken(true);
    }

    /**
     * Returns a string representation of the Transistor item.
     * @return The string
     */
    @Override
    public String toString() {
        return "Transistor#" + ID;
    }

}
