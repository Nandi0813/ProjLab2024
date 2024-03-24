package com.bucikft.Tests;

import com.bucikft.Items.DKC;
import com.bucikft.Person.Student;

/**
 * Class for testing the use of DKC.
 */
public class DKCUseTest {
    private DKC TestDKC = new DKC();
    private Student TestStudent = new Student();

    /**
     * Method to perform the DKC use test.
     */
    public void DKCTest() {
        System.out.println("\nDKC használatának tesztelése.");
        try {
            TestStudent.use(TestDKC);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
