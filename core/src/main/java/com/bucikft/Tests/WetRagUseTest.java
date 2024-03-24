package com.bucikft.Tests;

import com.bucikft.Items.WetRag;
import com.bucikft.Person.Student;

public class WetRagUseTest {
    private WetRag TestWetRag = new WetRag();
    private Student TestStudent = new Student();

    public void wetRagUseTest() {
        try {
            TestStudent.use(TestWetRag);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
