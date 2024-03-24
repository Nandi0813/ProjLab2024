package com.bucikft.Tests;

import com.bucikft.Items.Hammer;
import com.bucikft.Person.Student;

public class HammerUseTest {
    private Hammer TestHammer = new Hammer();
    private Student TestStudent = new Student();

    public void hammerTest() {
        System.out.println("\nKalapács használatának tesztelése.");
        try {
            TestStudent.use(TestHammer);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
