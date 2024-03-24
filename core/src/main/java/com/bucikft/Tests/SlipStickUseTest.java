package com.bucikft.Tests;

import com.bucikft.Items.SlipStick;
import com.bucikft.Person.Student;

public class SlipStickUseTest {
    private SlipStick TestSlipStick = new SlipStick();
    private Student TestStudent = new Student();

    public void slipStickUseTest() {
        System.out.println("\nLogarléc használatának tesztelése.");
        try {
            TestStudent.use(TestSlipStick);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }

    }
}
