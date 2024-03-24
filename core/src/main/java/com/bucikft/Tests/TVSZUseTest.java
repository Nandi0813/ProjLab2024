package com.bucikft.Tests;

import com.bucikft.Items.TVSZ;
import com.bucikft.Person.Student;

public class TVSZUseTest {
    private TVSZ TestTVSZ = new TVSZ();
    private Student TestStudent = new Student();

    public void TVSZUseTest() {
        System.out.println("\nTVSZ használatának tesztelése.");
        try {
            TestStudent.use(TestTVSZ);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }

    }
}
