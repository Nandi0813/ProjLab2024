package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Cleaner;
import com.bucikft.Person.Person;
import com.bucikft.Person.Student;
import com.bucikft.Room;

/**
 * Represents the DKC item, which fills a room with gas when used by a Student.
 */
public class DKC extends Item {

    /**
     * The constructor of the DKC class.
     * @param ID The unique identifier of the item.
     * @param isFalseItem Indicates whether the item is a false item or not.
     */
    public DKC(String ID, boolean isFalseItem) {
        super(ID, isFalseItem, TileType.DKC);
    }

    /**
     * Applies the effect of the DKC item on the user (a student).
     *
     * @param user The student who uses the DKC item.
     * @throws IllegalStateException If the room is already filled with gas.
     */
    public void effect(Student user) throws IllegalStateException {
        // Test if room is filled with gas
        if (user.getCurrentRoom().isGassed()) {
            throw new IllegalStateException("The room is already filled with gas.");
        }

        Room room = user.getCurrentRoom();

        // Gas the room
        room.setGassed(true);

        for (Person person : room.getPersonList()) {
            if (person instanceof Cleaner) {
                System.out.println("The room cannot be filled with gas because it contains a cleaner.");
                room.setGassed(false);
                break;
            }
        }

        // Break the item
        this.setBroken(true);
    }

}
