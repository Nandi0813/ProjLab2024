package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;
import com.bucikft.Person.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Zyn item, which can revive the first dead student in the room when used by a student.
 */
public class Zyn extends Item {

    public Zyn(String ID, boolean isFalseItem) {
        super(ID, isFalseItem);
    }

    /**
     * Applies the effect of the Zyn item, reviving the first dead student in the room.
     *
     * @param user The student who uses the Zyn item.
     * @throws IllegalStateException If there is no dead student in the room or if the Zyn item is broken.
     */
    public void effect(Student user) throws IllegalStateException {
        // Test if there is a dead student in the room
        boolean deadStudentExists = false;
        List<Student> deadStudents = new ArrayList<>();
        for (Person person : user.getCurrentRoom().getPersonList()) {
            if (person instanceof Student student) {
                if (!student.isAlive()) {
                    deadStudentExists = true;
                    deadStudents.add(student);
                }
            }
        }
        if (!deadStudentExists) throw new IllegalStateException("There is no dead student in the room.");

        // Revive the dead students in the room
        for (Student deadStudent : deadStudents) {
            System.out.println("Student#" + deadStudent.getName()+ " has been revived.");
            deadStudent.setAlive(true);
        }

        // Break item
        setBroken(true);
    }
    @Override
    public String toString() {
        return "Zyn#" + ID;
    }
}
