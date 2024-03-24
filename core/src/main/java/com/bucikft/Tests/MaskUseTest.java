package com.bucikft.Tests;

import com.bucikft.Items.Mask;
import com.bucikft.Person.Student;

public class MaskUseTest {
    private Mask TestMask = new Mask();
    private Student TestStudent = new Student();

    public void MaskTest() {
        System.out.println("\nMaszk használatának tesztelése.");
        try {
            TestStudent.use(TestMask);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
