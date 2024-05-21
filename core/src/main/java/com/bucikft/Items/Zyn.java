package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;
import com.bucikft.Person.Student;
import com.bucikft.Controllers.TileType;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Zyn item, which can revive the first dead student in the room when used by a student.
 */
public class Zyn extends Item {

    /**
     * The constructor of the Zyn class.
     *
     * @param ID          The unique identifier of the item.
     * @param isFalseItem Indicates whether the item is a false item or not.
     */
    public Zyn(String ID, boolean isFalseItem) {
        super(ID, isFalseItem, TileType.Zyn);
    }

    /**
     * Applies the effect of the Zyn item, reviving the first dead student in the room.
     *
     * @param user The student who uses the Zyn item.
     * @throws IllegalStateException If there is no dead student in the room or if the Zyn item is broken.
     */
    public void effect(Student user) throws IllegalStateException {
        // Test if there is a dead student in the room
        List<Student> deadStudents = new ArrayList<>();
        for (Person person : user.getCurrentRoom().getPersonList()) {
            if (person instanceof Student student && !student.isAlive()) {
                deadStudents.add(student);
            }
        }

        if (deadStudents.isEmpty()) {
            throw new IllegalStateException("There are no dead students in the room.");
        }

        // Revive the dead students in the room
        for (Student deadStudent : deadStudents) {
            System.out.println("Student#" + deadStudent.getName()+ " has been revived.");
            deadStudent.setAlive(true);
        }

        // Break item
        setBroken(true);
    }

}
