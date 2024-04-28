package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

/**
 * Represents a Wet Rag item, which can stun all professors in the room when used by a student.
 */
public class WetRag extends Item {

    /**
     * The constructor of the WetRag class.
     * @param ID The unique identifier of the item.
     * @param isFalseItem Indicates whether the item is a false item or not.
     */
    public WetRag(String ID, boolean isFalseItem) {
        super(ID, isFalseItem);
    }

    /**
     * Applies the effect of the Wet Rag item, stunning all professors in the room.
     *
     * @param user The student who uses the Wet Rag item.
     */
    public void effect(Student user) {

        // Stun all professors in the room
        for (Person person : user.getCurrentRoom().getPersonList()) {
            if (person instanceof Professor) {
                person.stun(3);
            }
        }

        // Break item
        setBroken(true);
    }

    /**
     * Returns a string representation of the Wet Rag item.
     * @return The string representation of the Wet Rag item.
     */
    @Override
    public String toString() {
        return "WetRag#"+ID;
    }

}
