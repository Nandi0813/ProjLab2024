package com.bucikft.Tests;

import com.bucikft.Items.HolyCup;
import com.bucikft.Person.Student;

public class HolyCupTest {
    private HolyCup TestHolyCup = new HolyCup();
    private Student TestStudent = new Student();

    public void holyCupTest() {
        try {
            TestStudent.use(TestHolyCup);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A Szent Söröspohár használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
