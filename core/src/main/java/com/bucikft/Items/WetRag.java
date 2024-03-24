package com.bucikft.Items;

import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

/**
 * Represents a Wet Rag item, which can stun all professors in the room when used by a student.
 */
public class WetRag extends Item {

    /**
     * Applies the effect of the Wet Rag item, stunning all professors in the room.
     *
     * @param user The student who uses the Wet Rag item.
     */
    public void effect(Student user) {

        // Stun all professors in the room
        // Todo: Implement stunning professors
        System.out.print("*The Wet Rag stuns all professors*");

        // Break item
        setBroken(true);
    }
}
