package com.bucikft.Tests;

import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

public class StudentKillTest {
    private Student TestStudent = new Student();
    private Professor TestProfessor = new Professor();

    public void studentKillTest() {
        System.out.println("\nHallgató megölésének tesztelése.");
        try {
            TestProfessor.killStudent(TestStudent);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A hallgató megölése sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
