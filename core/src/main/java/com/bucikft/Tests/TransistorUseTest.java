package com.bucikft.Tests;

import com.bucikft.Items.Transistor;
import com.bucikft.Person.Student;

/**
 * Class for testing the use of transistors.
 */
public class TransistorUseTest {
    private Transistor TestTransistor1 = new Transistor();
    private Transistor TestTransistor2 = new Transistor();
    private Student TestStudent = new Student();

    /**
     * Method to perform the transistor use test.
     */
    public void transistorUseTest() {
        System.out.println("\nTesting the use of transistors.");
        System.out.println("Pairing the transistors.");
        try {
            TestStudent.join(TestTransistor1, TestTransistor2);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Pairing transistors failed.");
        }
        System.out.println("Using the transistors.");
        try {
            TestStudent.use(TestTransistor1);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to use the item.");
        } finally {
            System.out.println("End of the test.\n");
        }

    }
}
