package com.bucikft.Tests;

import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

/**
 * Class for testing the killing of students by professors.
 */
public class StudentKillTest {
    private Student TestStudent = new Student();
    private Professor TestProfessor = new Professor();

    /**
     * Method to perform the student kill test.
     */
    public void studentKillTest() {
        System.out.println("\nTesting the killing of a student.");
        try {
            TestProfessor.killStudent(TestStudent);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to kill the student.");
        } finally {
            System.out.println("End of the test.\n");
        }
    }
}
