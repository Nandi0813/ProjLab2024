package com.bucikft.Tests;

import com.bucikft.Person.Student;
import com.bucikft.Room;

public class StudentMoveTest {
    public Student TestStudent = new Student();
    public Room TestRoom1 = new Room();
    public Room TestRoom2 = new Room();
    public void studentMoveTest() {
        // Test student move
        try {
            TestStudent.move(TestRoom2);
        }
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A teszt sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
