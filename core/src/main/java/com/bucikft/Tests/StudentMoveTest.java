package com.bucikft.Tests;

import com.bucikft.Person.Student;
import com.bucikft.Room;

/**
 * Class for testing the movement of students.
 */
public class StudentMoveTest {
    public Student TestStudent = new Student();
    public Room TestRoom1 = new Room();
    public Room TestRoom2 = new Room();

    /**
     * Method to perform the student move test.
     */
    public void studentMoveTest() {
        // Test student move
        try {
            TestStudent.move(TestRoom2);
        }
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("The test failed.");
        } finally {
            System.out.println("End of the test.\n");
        }
    }
}
