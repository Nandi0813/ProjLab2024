package com.bucikft.Tests;

import com.bucikft.Items.Zyn;
import com.bucikft.Person.Student;

/**
 * Class for testing the use of Zyn.
 */
public class ZynUseTest {
    private Zyn TestZyn = new Zyn();
    private Student TestStudent = new Student();

    /**
     * Method to perform the Zyn use test.
     */
    public void zynUseTest() {
        System.out.println("\nSnüci használatának tesztelése.");
        try {
            TestStudent.use(TestZyn);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
